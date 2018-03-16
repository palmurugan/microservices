package com.hts.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hts.report.domain.ReportDefinition;

@Repository
public interface ReportDefinitionRepository extends PagingAndSortingRepository<ReportDefinition, Long> {

}
