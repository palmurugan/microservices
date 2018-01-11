package com.hts.report.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.hts.report.domain.ReportDefinition;

public class ReportDefinitionMockData {

    public static ReportDefinition getReportDefinitionMockData() {
        ReportDefinition reportDefinition = new ReportDefinition();
        reportDefinition.setDefinitionId(1L);
        reportDefinition.setName("Test");
        reportDefinition.setStatus("A");
        return reportDefinition;
    }

    private static List<ReportDefinition> getReportDefinitionList() {
        List<ReportDefinition> reportDefinitionList = new ArrayList<>();
        ReportDefinition reportDefinition = new ReportDefinition();
        reportDefinition.setDefinitionId(1L);
        reportDefinition.setName("Test");
        reportDefinitionList.add(reportDefinition);
        return reportDefinitionList;
    }

    public static Page<ReportDefinition> getReportDefinitionPagedData() {
        Page<ReportDefinition> reportDefinitionPage = new PageImpl<ReportDefinition>(getReportDefinitionList());
        return reportDefinitionPage;
    }

}
