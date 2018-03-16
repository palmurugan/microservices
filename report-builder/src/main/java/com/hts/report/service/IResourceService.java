package com.hts.report.service;

import java.util.List;

import com.genesis.common.service.IGenericService;
import com.hts.report.domain.Resource;

public interface IResourceService extends IGenericService<Resource, Long> {

	public List<Resource> findByStatus(String status);
}
