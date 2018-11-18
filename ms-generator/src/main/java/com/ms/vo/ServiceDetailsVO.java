package com.ms.vo;

import java.io.Serializable;

public class ServiceDetailsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String author;

	private String applicationName;

	private EntityDetails entityDetails;

	private String packageName;

	public ServiceDetailsVO(String author, String applicationName, EntityDetails entityDetails, String packageName) {
		super();
		this.author = author;
		this.applicationName = applicationName;
		this.entityDetails = entityDetails;
		this.packageName = packageName;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public EntityDetails getEntityDetails() {
		return entityDetails;
	}

	public void setEntityDetails(EntityDetails entityDetails) {
		this.entityDetails = entityDetails;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
