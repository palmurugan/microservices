package com.hts.report.service;

import com.genesis.common.service.IGenericService;
import com.hts.report.domain.ReportFilter;

public interface IReportFilterService extends IGenericService<ReportFilter, Long> {

    public String getReportFilterConfiguration(Long resourceId);
}
