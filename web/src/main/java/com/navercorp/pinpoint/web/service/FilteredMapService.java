/*
 * Copyright 2019 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.service;

import com.navercorp.pinpoint.common.server.bo.SpanBo;
import com.navercorp.pinpoint.common.profiler.util.TransactionId;
import com.navercorp.pinpoint.web.applicationmap.ApplicationMap;
import com.navercorp.pinpoint.web.filter.Filter;
import com.navercorp.pinpoint.web.vo.Application;
import com.navercorp.pinpoint.web.vo.LimitedScanResult;
import com.navercorp.pinpoint.web.vo.LoadFactor;
import com.navercorp.pinpoint.web.vo.Range;

import java.util.List;

/**
 * @author netspider
 * @author emeroad
 */
public interface FilteredMapService {

    LimitedScanResult<List<TransactionId>> selectTraceIdsFromApplicationTraceIndex(String applicationName, Range range, int limit);

    LimitedScanResult<List<TransactionId>> selectTraceIdsFromApplicationTraceIndex(String applicationName, Range range, int limit, boolean backwardDirection);


    LoadFactor linkStatistics(Range range, List<TransactionId> traceIdSet, Application sourceApplication, Application destinationApplication, Filter<List<SpanBo>> filter);

    ApplicationMap selectApplicationMap(TransactionId transactionId, int version);

    ApplicationMap selectApplicationMapWithScatterData(List<TransactionId> traceIdList, Range originalRange, Range scanRange, int xGroupUnit, int yGroupUnit, Filter<List<SpanBo>> filter, int version);

}
