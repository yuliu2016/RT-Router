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

header = """@file:Suppress("unused", "SpellCheckingInspection", "KDocUnresolvedReference", "UNUSED_VARIABLE")

package ca.warp7.rt.router.tba"""

ft = """
/**
 * {des}
 */
suspend fun TBA.{op_id}({params}): {typing} {{
    val response = {fname}("{k}")
    {body}
}}"""

params_dict = {
    "page_num": "Int",
    "year": "Int",
    "media_tag": "String",
    "team_key": "String",
    "event_key": "String",
    "match_key": "String",
    "district_key": "String"
}

def get_kk(k):
    sp = k.split("_")
    sl = list(map(lambda x: x[0].capitalize() + x[1:], sp))
    kk = "".join(sl)
    return kk

def ctr_for_def(ref_k, name, indent):
    v = defs[ref_k]
    if "properties" in v:
        props = v["properties"]
    else:
        props = {}
    kk = get_kk(ref_k)
    dat = kk + "(\n"
    pz = ["raw = " + name]
    for p, q in props.items():
        # reserved words
        if p == "in":
            dcp = "_in"
        else:
            dcp = p
        argdat = dcp + " = "
        if "$ref" in q:
            ref_k = q["$ref"].split("/")[-1]
            argdat += name + ".obj(\"" + p + "\")?.let { " + p + " ->\n" + " " * (indent + 8) + ctr_for_def(ref_k, p, indent + 8) + "\n" + " " * (indent + 4) + "}"
        elif p == "alliances":
            ref_k = q["properties"]["blue"]["$ref"].split("/")[-1]
            typing = "Alliances<{kk}>".format(kk=get_kk(ref_k))
            argdat += "null"
        else:
            dtype = q["type"]
            if dtype == "object":
                typing = "Map<String, Any?>"
                argdat += "null"
            elif dtype == "number":
                typing = "Double"
                argdat += name + ".double(\"" + p + "\")"
            elif dtype == "string":
                typing = "String"
                argdat += name + ".string(\"" + p + "\")"
            elif dtype == "integer":
                typing = "Int"
                argdat += name + ".int(\"" + p + "\")"
            elif dtype == "boolean":
                typing = "Boolean"
                argdat += name + ".boolean(\"" + p + "\")"
            elif dtype == "array":
                argdat += "null"
                it = q["items"]
                if "$ref" in it:
                    ref_k = it["$ref"].split("/")[-1]
                    typing = get_kk(ref_k)
                else:
                    atype = it["type"]
                    if atype == "object":
                        typing = "List<Map<String, Any?>>"
                    elif atype == "number":
                        typing = "List<Double>"
                    elif atype == "string":
                        typing = "List<String>"
                    elif atype == "integer":
                        typing = "List<Int>"
                    elif atype == "boolean":
                        typing = "List<Boolean>"
                    else:
                        print(it)
                        raise TypeError()
            else:
                raise TypeError()
        pz.append(argdat)
    dat += ",\n".join(map(lambda x: " " * (indent + 4) + x, pz))
    dat += "\n" + " " * indent + ")"
    return dat

def func_for_kk(k, v):
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
    k2 = k
    if (len(actual_params)==0):
        ps = ""
    else:
        pdef = map(lambda x: x + ": " + params_dict[x], actual_params)
        ps = "\n    " + ",\n    ".join(pdef) + "\n"
        for p in actual_params:
            k2 = k2.replace("{" + p + "}", "$" + p)
    body = "TODO()"
    fname = "get"
    if "$ref" in res:
        ref_k = res["$ref"].split("/")[-1]
        typing = get_kk(ref_k)
        body = "return " + ctr_for_def(ref_k, "response", 4)
    elif res["type"] == "array":
        it = res["items"]
        fname= "getArray"
        if "$ref" in it:
            ref_k = it["$ref"].split("/")[-1]
            typing = "List<" + get_kk(ref_k) + ">"
        elif it["type"] == "string":
            typing = "List<String>"
        elif it["type"] == "integer":
            typing = "List<Int>"
        elif it["type"] == "object":
            typing = "List<Map<String, Any?>>"
        else:
            raise TypeError()
    elif res["type"] == "object":
        ref_k = res["additionalProperties"]["$ref"].split("/")[-1]
        typing = "Map<String, " + get_kk(ref_k) + "?>"
    else:
        raise TypeError()
        
    s = ft.format(des=des, op_id=op_id, params=ps, typing=typing, k=k2, body=body, fname=fname)
    return s

with open("Paths.kt", mode="w") as io:
    print(header, file=io)
    for k, v in paths.items():
        print(func_for_kk(k, v), file=io)
        
