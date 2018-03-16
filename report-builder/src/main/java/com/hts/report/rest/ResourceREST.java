package com.hts.report.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hts.report.domain.Resource;
import com.hts.report.service.IResourceService;

/**
 * 
 * @author PalMurugan C
 *
 */
@RestController
@RequestMapping("/v1/resources")
public class ResourceREST {

	private IResourceService resourceService;

	@Inject
	public ResourceREST(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
		return new ResponseEntity<>(resourceService.saveOrUpdate(resource), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Resource>> getAllResources(Pageable pageable) {
		return new ResponseEntity<>(resourceService.getAll(pageable), HttpStatus.OK);
	}

    @RequestMapping(value = "/{resourceId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getResource(@PathVariable Long resourceId) {
        return new ResponseEntity<>(resourceService.get(resourceId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = "status")
	public ResponseEntity<List<Resource>> getResourceByStatus(@RequestParam String status) {
		return new ResponseEntity<>(resourceService.findByStatus(status), HttpStatus.OK);
	}

    @RequestMapping(value = "/{resourceId}", method = RequestMethod.PUT)
	public ResponseEntity<Resource> updateResource(@RequestBody Resource resource, @PathVariable Long resourceId) {
		resource.setResourceId(resourceId);
		return new ResponseEntity<>(resourceService.saveOrUpdate(resource), HttpStatus.OK);
	}

}
