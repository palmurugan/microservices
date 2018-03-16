package com.hts.report.service.impl;

import static com.hts.report.util.FilterUtil.exchangeDataType;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hts.report.dao.ReportFilterRepository;
import com.hts.report.domain.ReportFilter;
import com.hts.report.dto.ColumnData;
import com.hts.report.service.IReportColumnService;
import com.hts.report.service.IReportFilterService;

@Service
public class ReportFilterService implements IReportFilterService {

    private static final String NAME = "name";
    private static final String TYPE = "type";
    private static final String FIELDS = "fields";

    private ReportFilterRepository reportFilterRepository;

    private IReportColumnService reportColumnService;

    @Inject
    public ReportFilterService(ReportFilterRepository reportFilterRepository, IReportColumnService reportColumnService) {
        this.reportFilterRepository = reportFilterRepository;
        this.reportColumnService = reportColumnService;
    }

    @Override
    public ReportFilter saveOrUpdate(ReportFilter entity) {
        return reportFilterRepository.save(entity);
    }

    @Override
    public Page<ReportFilter> getAll(Pageable pageable) {
        return reportFilterRepository.findAll(pageable);
    }

    @Override
    public ReportFilter get(Long id) {
        return reportFilterRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        reportFilterRepository.delete(id);
    }

    @Override
    public String getReportFilterConfiguration(Long resourceId) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode fieldsNode = mapper.createObjectNode();
        ObjectNode columnNode = mapper.createObjectNode();
        List<ColumnData> reportColumns = reportColumnService.getAvailableColumns(resourceId);
        for (ColumnData columnData : reportColumns) {
            ObjectNode dataNode = mapper.createObjectNode();
            dataNode.put(NAME, columnData.getName());
            dataNode.put(TYPE, exchangeDataType(columnData.getType()));
            columnNode.putPOJO(columnData.getName(), dataNode);
        }
        fieldsNode.putPOJO(FIELDS, columnNode);
        return fieldsNode.toString();
    }
}
