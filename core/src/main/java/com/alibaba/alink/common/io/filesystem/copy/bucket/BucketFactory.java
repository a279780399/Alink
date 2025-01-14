/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.alink.common.io.filesystem.copy.bucket;

import org.apache.flink.core.fs.Path;
import org.apache.flink.core.fs.RecoverableWriter;
import org.apache.flink.streaming.api.functions.sink.filesystem.RollingPolicy;

import com.alibaba.alink.common.annotation.Internal;

import java.io.IOException;
import java.io.Serializable;

/**
 * A factory able to create {@link Bucket buckets} for the {@link StreamingFileSink}.
 */
@Internal
interface BucketFactory<IN, BucketID> extends Serializable {

	Bucket <IN, BucketID> getNewBucket(
		final RecoverableWriter fsWriter,
		final int subtaskIndex,
		final BucketID bucketId,
		final Path bucketPath,
		final long initialPartCounter,
		final PartFileWriter.PartFileFactory <IN, BucketID> partFileWriterFactory,
		final RollingPolicy <IN, BucketID> rollingPolicy) throws IOException;

	Bucket <IN, BucketID> restoreBucket(
		final RecoverableWriter fsWriter,
		final int subtaskIndex,
		final long initialPartCounter,
		final PartFileWriter.PartFileFactory <IN, BucketID> partFileWriterFactory,
		final RollingPolicy <IN, BucketID> rollingPolicy,
		final BucketState <BucketID> bucketState) throws IOException;
}
