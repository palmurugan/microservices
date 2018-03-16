package com.hts.report.service;

import com.hts.report.domain.ReportDefinition;
import com.hts.report.domain.Resource;

public interface IQueryBuilder {

    public String buildQuery(ReportDefinition reportDefinition);

    public String buildColumnDefinitionQuery(Resource resource);
}
