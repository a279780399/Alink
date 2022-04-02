package com.alibaba.alink.params.shared.associationrules;

import org.apache.flink.ml.api.misc.param.ParamInfo;
import org.apache.flink.ml.api.misc.param.ParamInfoFactory;
import org.apache.flink.ml.api.misc.param.WithParams;

import com.alibaba.alink.common.annotation.DescCn;
import com.alibaba.alink.common.annotation.NameCn;

public interface HasMaxConsequentLengthDefaultAs1<T> extends WithParams <T> {
	@NameCn("最大关联规则后继长度")
	@DescCn("最大关联规则后继(consequent)长度")
	ParamInfo <Integer> MAX_CONSEQUENT_LENGTH = ParamInfoFactory
		.createParamInfo("maxConsequentLength", Integer.class)
		.setDescription("Maximum consequent length")
		.setHasDefaultValue(1)
		.build();

	default Integer getMaxConsequentLength() {
		return get(MAX_CONSEQUENT_LENGTH);
	}

	default T setMaxConsequentLength(Integer value) {
		return set(MAX_CONSEQUENT_LENGTH, value);
	}
}
