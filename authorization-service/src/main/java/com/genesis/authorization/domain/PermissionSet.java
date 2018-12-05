package com.genesis.authorization.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.genesis.common.domain.Auditable;

/**
 * 
 * @author PalMurugan C
 *
 */
@Entity
@Table(name = "PERMISSIONSET")
public class PermissionSet extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;	
     
	
	@Column(name = "NAME")
	private String name;	
    
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
    
}
