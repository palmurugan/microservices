package com.genesis.party.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.genesis.common.annotation.Unique;
import com.genesis.common.domain.Auditable;
import com.genesis.common.validator.ValidationGroup;

/**
 * 
 * @author ${author}
 *
 */
@Entity
@Table(name = "${entityDetails.name}")
public class ${entityDetails.name} implements Serializable {

	private static final long serialVersionUID = 1L;

    <#list entityDetails.attributes as attribute> 
    <#if attribute.primaryKey>@Id</#if> 
	<#if attribute.primaryKey>@GeneratedValue(strategy = GenerationType.AUTO)</#if>
	@Column(name = "${attribute.name}")
	private ${attribute.dataType} ${attribute.name};
	
	public ${attribute.dataType} get${attribute.name?capitalize}() {
		return ${attribute.name};
	}
	
	public void set${attribute.name?capitalize}(${attribute.dataType} ${attribute.name}) {
		this.${attribute.name} = ${attribute.name};
	}
    </#list>
}
