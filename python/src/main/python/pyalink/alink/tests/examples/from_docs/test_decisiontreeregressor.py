import unittest
from pyalink.alink import *
import numpy as np
import pandas as pd
class TestDecisionTreeRegressor(unittest.TestCase):
    def test_decisiontreeregressor(self):

        df = pd.DataFrame([
            [1.0, "A", 0, 0, 0],
            [2.0, "B", 1, 1, 0],
            [3.0, "C", 2, 2, 1],
            [4.0, "D", 3, 3, 1]
        ])
        
        batchSource = BatchOperator.fromDataframe(
            df, schemaStr='f0 double, f1 string, f2 int, f3 int, label int')
        streamSource = StreamOperator.fromDataframe(
            df, schemaStr='f0 double, f1 string, f2 int, f3 int, label int')
        
        DecisionTreeRegressor()\
            .setPredictionCol('pred')\
            .setLabelCol('label')\
            .setFeatureCols(['f0', 'f1', 'f2', 'f3'])\
            .fit(batchSource)\
            .transform(batchSource)\
            .print()
        
        DecisionTreeRegressor()\
            .setPredictionCol('pred')\
            .setLabelCol('label')\
            .setFeatureCols(['f0', 'f1', 'f2', 'f3'])\
            .fit(batchSource)\
            .transform(streamSource)\
            .print()
        
        StreamOperator.execute()
        pass