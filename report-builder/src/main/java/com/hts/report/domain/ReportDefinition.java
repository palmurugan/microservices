package com.hts.report.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.genesis.common.domain.Auditable;

@Entity
@Table(name = "PSR_DEFINITION")
public class ReportDefinition extends Auditable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEFINITION_Id", unique=true, nullable=false)
	private Long definitionId;

	@JoinColumn(name = "RESOURCE_Id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Resource resource;
	
	@Column(name = "NAME", unique = true, nullable = false)
	private String name;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "IS_INTERNAL", nullable = false)
	private boolean internal;

    @OneToMany(mappedBy = "reportDefinition", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<ReportColumn> reportColumns = new HashSet<>();

    @OneToOne(mappedBy = "reportDefinition", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ReportFilter reportFilter;

    public void addReportColumns(Set<ReportColumn> reportColumns) {
        for (ReportColumn reportColumn : reportColumns) {
            reportColumn.setReportDefinition(this);
        }
    }

    public void addReportFilter(ReportFilter reportFilter) {
        reportFilter.setReportDefinition(this);
    }

	public Long getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(Long definitionId) {
		this.definitionId = definitionId;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

    public Set<ReportColumn> getReportColumns() {
        return reportColumns;
    }

    public void setReportColumns(Set<ReportColumn> reportColumns) {
        this.reportColumns = reportColumns;
    }

    public ReportFilter getReportFilter() {
        return reportFilter;
    }

    public void setReportFilter(ReportFilter reportFilter) {
        this.reportFilter = reportFilter;
    }
}
