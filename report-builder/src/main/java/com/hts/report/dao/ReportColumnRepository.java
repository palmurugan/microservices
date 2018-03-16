package com.hts.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hts.report.domain.ReportColumn;

@Repository
public interface ReportColumnRepository extends PagingAndSortingRepository<ReportColumn, Long> {

}
