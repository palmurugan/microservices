package com.hts.report.service;

import java.util.List;

import com.hts.report.domain.Resource;
import com.hts.report.dto.ColumnData;

public interface IQueryExecutor {

    public Object executeQuery(Resource resource, String sql);

    public List<ColumnData> getAvailableColumns(Resource resource, String sql);
}
