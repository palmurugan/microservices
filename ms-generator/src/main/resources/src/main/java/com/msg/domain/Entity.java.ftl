package ${packageName}.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.genesis.common.annotation.Unique;
import com.genesis.common.domain.Auditable;
import com.genesis.common.validator.ValidationGroup;
<#if entityDetails.mappings?has_content>
<#list entityDetails.mappings as mapping>
import ${packageName}.domain.${mapping.attributeName};
</#list>
</#if>

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
    </#list>
    
    <#if entityDetails.mappings?has_content>
    <#list entityDetails.mappings as mapping>
    @${mapping.type}(cascade=CascadeType.ALL)
    @JoinColumn(name="${mapping.joinColumn}")
    private Set<${mapping.attributeName}> ${mapping.placeHolder};	
    </#list>
    </#if>
    
    <#list entityDetails.attributes as attribute> 
	public ${attribute.dataType} get${attribute.name?capitalize}() {
		return ${attribute.name};
	}
	
	public void set${attribute.name?capitalize}(${attribute.dataType} ${attribute.name}) {
		this.${attribute.name} = ${attribute.name};
	}
    </#list>
    
    <#if entityDetails.mappings?has_content>
    <#list entityDetails.mappings as mapping>
    public Set<${mapping.attributeName}> get${mapping.placeHolder?capitalize}() {
		return ${mapping.placeHolder};
	}
	
	public void set${mapping.placeHolder?capitalize}(Set<${mapping.attributeName}> ${mapping.placeHolder}) {
		this.${mapping.placeHolder} = ${mapping.placeHolder};
	}
    </#list>
    </#if>
}
