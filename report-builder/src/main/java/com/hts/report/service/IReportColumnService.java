package com.hts.report.service;

import java.util.List;

import com.genesis.common.service.IGenericService;
import com.hts.report.domain.ReportColumn;
import com.hts.report.dto.ColumnData;

public interface IReportColumnService extends IGenericService<ReportColumn, Long> {

    public List<ColumnData> getAvailableColumns(Long resourceId);
}
