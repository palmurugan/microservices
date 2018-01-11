package com.hts.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hts.report.domain.DataSource;

@Repository
public interface DataSourceRepository extends PagingAndSortingRepository<DataSource, Long> {

}
