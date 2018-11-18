package com.ms.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author palmurugan
 * 
 *         This class will have all the metadata related properties
 */
public class MetaDataVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String author;

	private String applicationName;

	private List<EntityDetails> entityDetails;

	private String packageName;

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

	public List<EntityDetails> getEntityDetails() {
		return entityDetails;
	}

	public void setEntityDetails(List<EntityDetails> entityDetails) {
		this.entityDetails = entityDetails;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
