import json
import pprint
import io

swagger_file = open("api_v3.json")
json_data = swagger_file.read()
swagger_file.close()

data = json.loads(json_data)

api_version = data["info"]["version"]

paths = data["paths"]

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
##    simple_paths.append((k, op_id, des, actual_params, res))
    simple_paths.append((op_id, res))

with io.StringIO() as io:
    pprint.pprint(simple_paths, io)
    print(io.getvalue())
