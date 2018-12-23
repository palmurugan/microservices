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
@Table(name = "PERMISSIONS")
public class Permissions extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;	
    
    @Column(name="RELATIONSHIP_TYPE_ID")
    private Long relationshipTypeId;
     
	
	@Column(name = "PERMISSION_SET_ID")
	private Long permissionSetId;	
     
	
	@Column(name = "PERMISSION")
	private String permission;	
     
	
	@Column(name = "SCOPE")
	private String scope;	
    
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPermissionsetid() {
		return permissionSetId;
	}
	
	public void setPermissionsetid(Long permissionSetId) {
		this.permissionSetId = permissionSetId;
	}
	public String getPermission() {
		return permission;
	}
	
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}
    
}
