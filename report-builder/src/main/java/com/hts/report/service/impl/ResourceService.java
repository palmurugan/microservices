package com.hts.report.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hts.report.dao.ResourceRepository;
import com.hts.report.domain.Resource;
import com.hts.report.service.IResourceService;
import com.hts.report.util.ApplicationConstants;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class ResourceService implements IResourceService {

	private ResourceRepository resourceRepository;

	@Inject
	public ResourceService(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	@Override
	public Resource saveOrUpdate(Resource entity) {
		entity.setStatus(ApplicationConstants.ACTIVE);
		return resourceRepository.save(entity);
	}

	@Override
	public Page<Resource> getAll(Pageable pageable) {
		return resourceRepository.findAll(pageable);
	}

	@Override
	public Resource get(Long id) {
		return resourceRepository.findOne(id);
	}

	@Override
	public void remove(Long id) {
		resourceRepository.delete(id);
	}

	@Override
	public List<Resource> findByStatus(String status) {
		return resourceRepository.findByStatus(status);
	}

}
