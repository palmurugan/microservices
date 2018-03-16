package com.hts.report.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hts.report.dto.ColumnData;
import com.hts.report.service.IReportColumnService;
import com.hts.report.service.IReportFilterService;

@RestController
@RequestMapping("/v1/datas")
public class ReportDataREST {

    private IReportColumnService reportColumnService;

    private IReportFilterService reportFilterService;

    @Inject
    public ReportDataREST(IReportColumnService reportColumnService, IReportFilterService reportFilterService) {
        this.reportColumnService = reportColumnService;
        this.reportFilterService = reportFilterService;
    }

    @RequestMapping(value = "/columns/{resourceId}", method = RequestMethod.GET)
    public ResponseEntity<List<ColumnData>> getAvailableColums(@PathVariable Long resourceId) {
        return new ResponseEntity<>(reportColumnService.getAvailableColumns(resourceId), HttpStatus.OK);
    }

    @RequestMapping(value = "/fiters/config/{resourceId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFilterConfiguration(@PathVariable Long resourceId) {
        return new ResponseEntity<>(reportFilterService.getReportFilterConfiguration(resourceId), HttpStatus.OK);
    }
}
