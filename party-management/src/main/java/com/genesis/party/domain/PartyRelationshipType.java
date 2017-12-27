package com.genesis.party.domain;

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
 * @author PalMurugan
 *
 */

@Entity
@Table(name = "party_relationship_type")
public class PartyRelationshipType extends Auditable<String> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "party_relationship_type_id", unique = true, nullable = false)
    private Long partyRelationshipTypeId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Long getPartyRelationshipTypeId() {
        return partyRelationshipTypeId;
    }

    public void setPartyRelationshipTypeId(Long partyRelationshipTypeId) {
        this.partyRelationshipTypeId = partyRelationshipTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PartyRelationshipType [partyRelationshipTypeId=" + partyRelationshipTypeId + ", name=" + name + "]";
    }
}
