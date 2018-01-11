package com.hts.report.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.genesis.common.domain.Auditable;

@Entity
@Table(name = "PSR_RESOURCE")
public class Resource extends Auditable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESOURCE_Id", unique = true, nullable = false)
	private Long resourceId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DATASOURCE_Id")
	private DataSource datasource;

	@Column(name = "SOURCE_VIEW", unique = true, nullable = false)
	private String sourceView;

	@Column(name = "DISPLAY_NAME", unique = true, nullable = false)
	private String displayName;

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public String getSourceView() {
		return sourceView;
	}

	public void setSourceView(String sourceView) {
		this.sourceView = sourceView;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
