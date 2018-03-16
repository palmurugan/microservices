package com.hts.report.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.genesis.common.domain.Auditable;

@Entity
@Table(name = "PSR_DATASOURCE")
public class DataSource extends Auditable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DATASOURCE_Id", unique = true, nullable = false)
	private Long dataSourceId;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@Column(name = "CONNECTION_TYPE", nullable = false)
	private String connectionType;

	@Column(name = "CONNECTION_URL", nullable = false)
	private String connectionURL;

	public Long getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(Long dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getConnectionURL() {
		return connectionURL;
	}

	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}

	@Override
	public String toString() {
		return "DataSource [dataSourceId=" + dataSourceId + ", name=" + name + ", connectionType=" + connectionType
				+ ", connectionURL=" + connectionURL + "]";
	}
}
