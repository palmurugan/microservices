package com.hts.report.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hts.report.domain.Resource;

@Repository
public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long> {

	public List<Resource> findByStatus(String status);
}
