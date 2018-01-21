package com.hts.report.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hts.report.dao.ReportColumnRepository;
import com.hts.report.domain.ReportColumn;
import com.hts.report.domain.Resource;
import com.hts.report.dto.ColumnData;
import com.hts.report.service.IQueryBuilder;
import com.hts.report.service.IQueryExecutor;
import com.hts.report.service.IReportColumnService;
import com.hts.report.service.IResourceService;

@Service
public class ReportColumnService implements IReportColumnService {

    private ReportColumnRepository reportColumnRepository;

    private IQueryBuilder queryBuilder;

    private IQueryExecutor queryExecutor;

    private IResourceService resourceService;

    @Inject
    public ReportColumnService(ReportColumnRepository reportColumnRepository, IQueryBuilder queryBuilder, IQueryExecutor queryExecutor,
            IResourceService resourceService) {
        this.reportColumnRepository = reportColumnRepository;
        this.queryBuilder = queryBuilder;
        this.queryExecutor = queryExecutor;
        this.resourceService = resourceService;
    }

    @Override
    public ReportColumn saveOrUpdate(ReportColumn entity) {
        return reportColumnRepository.save(entity);
    }

    @Override
    public Page<ReportColumn> getAll(Pageable pageable) {
        return reportColumnRepository.findAll(pageable);
    }

    @Override
    public ReportColumn get(Long id) {
        return reportColumnRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        reportColumnRepository.delete(id);
    }

    @Override
    public List<ColumnData> getAvailableColumns(Long resourceId) {
        Resource resource = resourceService.get(resourceId);
        return queryExecutor.getAvailableColumns(resource, queryBuilder.buildColumnDefinitionQuery(resource));
    }
}
