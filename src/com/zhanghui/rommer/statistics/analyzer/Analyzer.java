package com.zhanghui.rommer.statistics.analyzer;

import com.zhanghui.rommer.statistics.common.ChartPvUvData;

import java.util.List;

public interface Analyzer {
    List<ChartPvUvData> analyze() throws Exception;
}
