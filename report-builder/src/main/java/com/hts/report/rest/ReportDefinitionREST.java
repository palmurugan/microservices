package com.hts.report.rest;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hts.report.domain.ReportDefinition;
import com.hts.report.service.IReportDefinitionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author PalMurugan C
 *
 */
@RestController
@RequestMapping(value = "/v1/definitions")
@Api(value = "Report Definition")
public class ReportDefinitionREST {

	private IReportDefinitionService reportDefinitionService;

	@Inject
	public ReportDefinitionREST(IReportDefinitionService reportDefinitionService) {
		this.reportDefinitionService = reportDefinitionService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Report Definition", response = ReportDefinition.class)
	public ResponseEntity<ReportDefinition> createReportDefinition(@RequestBody ReportDefinition reportDefinition) {
		return new ResponseEntity<>(reportDefinitionService.saveOrUpdate(reportDefinition),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get All Report Definition", response = ReportDefinition.class)
	public ResponseEntity<Page<ReportDefinition>> getAllReportDefinitions(Pageable pageable) {
		return new ResponseEntity<>(reportDefinitionService.getAll(pageable), HttpStatus.OK);
	}

	@RequestMapping(value = "/{definitionId}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Report Definition", response = ReportDefinition.class)
    public ResponseEntity<ReportDefinition> getReportDefinition(@PathVariable Long definitionId) {
        return new ResponseEntity<>(reportDefinitionService.get(definitionId), HttpStatus.OK);
	}

	@RequestMapping(value = "/{definitionId}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update Report Definition", response = ReportDefinition.class)
	public ResponseEntity<ReportDefinition> updateReportDefinition(@RequestBody ReportDefinition reportDefinition,
			@PathVariable Long definitionId) {
		reportDefinition.setDefinitionId(definitionId);
		return new ResponseEntity<>(reportDefinitionService.saveOrUpdate(reportDefinition),
				HttpStatus.OK);
	}

}
