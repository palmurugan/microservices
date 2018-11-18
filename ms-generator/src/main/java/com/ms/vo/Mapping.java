package com.ms.vo;

import java.io.Serializable;

/**
 * 
 * @author palmurugan
 *
 */
public class Mapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;

	private String attributeName;

	private String placeHolder;

	private String joinColumn;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getJoinColumn() {
		return joinColumn;
	}

	public void setJoinColumn(String joinColumn) {
		this.joinColumn = joinColumn;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

}
