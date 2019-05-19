import json
import pprint
import io

swagger_file = open("api_v3.json")
json_data = swagger_file.read()
swagger_file.close()

data = json.loads(json_data)

api_version = data["info"]["version"]

paths = data["paths"]
defs = data["definitions"]

simple_paths = []

for k, v in paths.items():
    gt = v["get"]
    op_id = gt["operationId"]
    des = gt["description"]
    params = gt["parameters"]
    actual_params = []
    for i in range(len(params)):
        param_name = params[i]["$ref"].split("/")[-1]
        if param_name != "If-Modified-Since":
            actual_params.append(param_name)
    res = gt["responses"]["200"]["schema"]
    simple_paths.append((k, op_id, des, actual_params, res))

##with io.StringIO() as io:
##    pprint.pprint(simple_paths, io)
##    print(io.getvalue())

k_pkg = "ca.warp7.rt.router.tba.models"

template = """
package {pkg};

/**
 * {clz}
 * ------------------------------
 * {des}
 */

data class {clz}(
    /**
     * Raw Data Map
     */
    raw: Map<String, Any?>{dat}
)
"""

t2 = """,

    /**
     * {des}
     */
    val {name}: {typing}?"""


def def_2_k(k, v):
    if "properties" in v:
        props = v["properties"]
    else:
        props = {}
    if "description" in v:
        des = v["description"]
    else:
        des = "No description available"
    dat = ""
    for p, q in props.items():
        if "description" in q:
            sdes = q["description"]
        else:
            sdes = "No description available"
        if "$ref" in q:
            ref_k = q["$ref"].split("/")[-1]
            typing = get_kk(ref_k)
        elif p == "alliances":
            ref_k = q["properties"]["blue"]["$ref"].split("/")[-1]
            typing = "Alliance<{kk}>".format(kk=get_kk(ref_k))
        else:
            dtype = q["type"]
            if dtype == "object":
                typing = "Map<String, Any?>"
            elif dtype == "number":
                typing = "Double"
            elif dtype == "array":
                typing = "Array<>"
            elif dtype == "string":
                typing = "String"
            elif dtype == "integer":
                typing = "Int"
            elif dtype == "boolean":
                typing = "Boolean"
            else:
                raise TypeError()
        dat += t2.format(des=sdes, name=p, typing=typing)
    s = template.format(pkg=k_pkg, des=des, clz=k, dat=dat)
    return s

def get_kk(k):
    sp = k.split("_")
    sl = list(map(lambda x: x[0].capitalize() + x[1:], sp))
    kk = "".join(sl)
    return kk

with io.StringIO() as io:
    for k, v in defs.items():
        kk = get_kk(k)
        print(def_2_k(kk, v), file=io)
    print(io.getvalue())

    
        

    
