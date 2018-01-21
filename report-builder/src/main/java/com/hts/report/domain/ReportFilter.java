package com.hts.report.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.genesis.common.domain.Auditable;

@Entity
@Table(name = "PSR_FILTER")
public class ReportFilter extends Auditable<String> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FILTER_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "DEFINITION_ID", nullable = false)
    @JsonBackReference
    private ReportDefinition reportDefinition;

    @Column(name = "FILTER_QUERY", nullable = true)
    private String filterQuery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportDefinition getReportDefinition() {
        return reportDefinition;
    }

    public void setReportDefinition(ReportDefinition reportDefinition) {
        this.reportDefinition = reportDefinition;
    }

    public String getFilterQuery() {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }
}
