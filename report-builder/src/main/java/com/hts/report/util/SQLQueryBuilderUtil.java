package com.hts.report.util;

import com.healthmarketscience.sqlbuilder.SelectQuery;
import com.hts.report.domain.ReportDefinition;
import com.hts.report.domain.Resource;

public class SQLQueryBuilderUtil {

    public static String prepareSQLQuery(ReportDefinition reportDefinition) {
        return createSelectQuery(reportDefinition.getResource()).validate().toString();
    }

    public static SelectQuery createSelectQuery(Resource resource) {
        return new SelectQuery().addCustomFromTable(resource.getSourceView());
    }

}
