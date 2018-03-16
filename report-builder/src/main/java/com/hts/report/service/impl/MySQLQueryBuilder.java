package com.hts.report.service.impl;

import org.springframework.stereotype.Service;

import com.hts.report.domain.ReportDefinition;
import com.hts.report.domain.Resource;
import com.hts.report.service.IQueryBuilder;
import com.hts.report.util.SQLQueryBuilderUtil;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class MySQLQueryBuilder implements IQueryBuilder {

    @Override
    public String buildQuery(ReportDefinition reportDefinition) {
        return SQLQueryBuilderUtil.prepareSQLQuery(reportDefinition);
    }

    @Override
    public String buildColumnDefinitionQuery(Resource resource) {
        return String.format("SELECT COLUMN_NAME, DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='%s'",
                resource.getSourceView());
    }
}
