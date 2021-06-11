## Description
Transform data type from Triple to Json.

## Parameters
| Name | Description | Type | Required？ | Default Value |
| --- | --- | --- | --- | --- |
| handleInvalid | Strategy to handle unseen token | String |  | "ERROR" |
| tripleColumnCol | Name of the triple column col | String | ✓ |  |
| tripleValueCol | Name of the triple value column | String | ✓ |  |
| reservedCols | Names of the columns to be retained in the output table | String[] |  | null |
| jsonCol | Name of the CSV column | String | ✓ |  |
| tripleRowCol | Name of the triple row column | String |  |  |

## Script Example
### Code
```python
import numpy as np
import pandas as pd


data = np.array([[1,'f1',1.0],[1,'f2',2.0],[2,'f1',4.0],[2,'f2',8.0]])
df = pd.DataFrame({"row":data[:,0], "col":data[:,1], "val":data[:,2]})
data = dataframeToOperator(df, schemaStr="row double, col string, val double",op_type="batch")


op = TripleToJsonBatchOp()\
    .setTripleRowCol("row").setTripleColCol("col").setTripleValCol("val")\
    .setReservedCols(["row"]).setJsonCol("json")\
    .linkFrom(data)
op.print()
```

### Results
    
    |row|json|
    |---|----|
    | 1 |{"f1":"1.0","f2":"2.0"}|
    | 2 |{"f2":"4.0","f4":"8.0"}|