package com.hts.report.service.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hts.report.dao.ReportDefinitionRepository;
import com.hts.report.domain.ReportDefinition;
import com.hts.report.service.IReportDefinitionService;
import com.hts.report.service.IResourceService;

@Service
@Transactional
public class ReportDefinitionService implements IReportDefinitionService {

	private ReportDefinitionRepository reportDefinitionRepository;

    private IResourceService resourceService;

	@Inject
    public ReportDefinitionService(ReportDefinitionRepository reportDefinitionRepository, IResourceService resourceService) {
		this.reportDefinitionRepository = reportDefinitionRepository;
        this.resourceService = resourceService;
	}

    @Override
    public ReportDefinition saveOrUpdate(ReportDefinition reportDefinition) {
        reportDefinition.setResource(resourceService.get(reportDefinition.getResource().getResourceId()));
		if (Objects.nonNull(reportDefinition.getReportColumns())) {
        	reportDefinition.addReportColumns(reportDefinition.getReportColumns());
        }
		if (Objects.nonNull(reportDefinition.getReportFilter())) {
			reportDefinition.addReportFilter(reportDefinition.getReportFilter());
		}
        return reportDefinitionRepository.save(reportDefinition);
    }

	@Override
	public Page<ReportDefinition> getAll(Pageable pageable) {
		return reportDefinitionRepository.findAll(pageable);
	}

	@Override
	public ReportDefinition get(Long id) {
		return reportDefinitionRepository.findOne(id);
	}

	@Override
	public void remove(Long id) {
		reportDefinitionRepository.delete(id);
	}
}
