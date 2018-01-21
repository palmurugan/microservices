package com.hts.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hts.report.domain.ReportFilter;

@Repository
public interface ReportFilterRepository extends PagingAndSortingRepository<ReportFilter, Long> {

}
