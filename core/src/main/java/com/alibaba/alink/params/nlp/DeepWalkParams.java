package com.alibaba.alink.params.nlp;

import com.alibaba.alink.params.nlp.walk.HasIsToUndigraph;
import com.alibaba.alink.params.nlp.walk.HasSourceCol;
import com.alibaba.alink.params.nlp.walk.HasTargetCol;
import com.alibaba.alink.params.nlp.walk.HasWalkLength;
import com.alibaba.alink.params.nlp.walk.HasWalkNum;
import com.alibaba.alink.params.shared.HasVectorSizeDefaultAs100;
import com.alibaba.alink.params.shared.colname.HasWeightColDefaultAsNull;
import com.alibaba.alink.params.shared.iter.HasNumIterDefaultAs1;

public interface DeepWalkParams<T> extends
	HasSourceCol <T>,
	HasTargetCol <T>,
	HasWeightColDefaultAsNull <T>,
	HasWalkNum <T>,
	HasWalkLength <T>,
	HasIsToUndigraph <T>,
	HasNumIterDefaultAs1 <T>,
	HasVectorSizeDefaultAs100 <T>,
	HasAlpha <T>,
	HasMinCount <T>,
	HasNegative <T>,
	HasRandomWindow <T>,
	HasWindow <T>,
	HasBatchSize <T> {
}
