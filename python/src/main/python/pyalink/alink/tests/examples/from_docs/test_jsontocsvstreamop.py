import unittest
from pyalink.alink import *
import numpy as np
import pandas as pd
class TestJsonToCsvStreamOp(unittest.TestCase):
    def test_jsontocsvstreamop(self):

        df = pd.DataFrame([
            ['1', '{"f0":"1.0","f1":"2.0"}', '$3$0:1.0 1:2.0', 'f0:1.0,f1:2.0', '1.0,2.0', 1.0, 2.0],
            ['2', '{"f0":"4.0","f1":"8.0"}', '$3$0:4.0 1:8.0', 'f0:4.0,f1:8.0', '4.0,8.0', 4.0, 8.0]])
        
        data = StreamOperator.fromDataframe(df, schemaStr="row string, json string, vec string, kv string, csv string, f0 double, f1 double")
            
        op = JsonToCsvStreamOp()\
            .setJsonCol("json")\
            .setReservedCols(["row"])\
            .setCsvCol("csv")\
            .setSchemaStr("f0 double, f1 double")\
            .linkFrom(data)
        
        op.print()
        
        StreamOperator.execute()
        pass