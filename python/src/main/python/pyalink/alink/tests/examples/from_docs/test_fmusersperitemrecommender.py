import unittest
from pyalink.alink import *
import numpy as np
import pandas as pd
class TestFmUsersPerItemRecommender(unittest.TestCase):
    def test_fmusersperitemrecommender(self):

        df_data = pd.DataFrame([
            [1, 1, 0.6],
            [2, 2, 0.8],
            [2, 3, 0.6],
            [4, 1, 0.6],
            [4, 2, 0.3],
            [4, 3, 0.4],
        ])
        
        data = BatchOperator.fromDataframe(df_data, schemaStr='user bigint, item bigint, rating double')
        
        model = FmRecommTrainBatchOp()\
            .setUserCol("user")\
            .setItemCol("item")\
            .setNumFactor(20)\
            .setRateCol("rating").linkFrom(data);
        
        rec = FmUsersPerItemRecommender()\
            .setItemCol("item")\
            .setK(1).setReservedCols(["item"])\
            .setRecommCol("prediction_result")\
            .setModelData(model);
        
        rec.transform(data).print()
        pass