package com.genesis.workflow.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.genesis.common.domain.Auditable;

@Entity
@Table(name = "process")
public class Process extends Auditable<String> {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "clientId", nullable = false)
	private long clientId;

	@Column(name = "name", nullable = false)
	@NotNull(message = "ProcessName is required")
	@NotBlank(message = "ProcessName is required")
	private String name;

	@Column(name = "processStatus", nullable = false)
	private String processStatus;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;
}
