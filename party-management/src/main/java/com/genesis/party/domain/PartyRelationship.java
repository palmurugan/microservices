package com.genesis.party.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.genesis.common.domain.Auditable;

/**
 * 
 * @author PalMurugan C
 *
 */
@Entity
@Table(name = "party_relationship")
public class PartyRelationship extends Auditable<String> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "party_relationship_id", unique = true, nullable = false)
    private Long partyRelationshipTypeId;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "party_id1")
    private Party party1;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "party_id2")
    private Party party2;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "party_relationship_type_id")
    private PartyRelationshipType partyRelationshipType;

    public Long getPartyRelationshipTypeId() {
        return partyRelationshipTypeId;
    }

    public void setPartyRelationshipTypeId(Long partyRelationshipTypeId) {
        this.partyRelationshipTypeId = partyRelationshipTypeId;
    }

    public Party getParty1() {
        return party1;
    }

    public void setParty1(Party party1) {
        this.party1 = party1;
    }

    public Party getParty2() {
        return party2;
    }

    public void setParty2(Party party2) {
        this.party2 = party2;
    }

    public PartyRelationshipType getPartyRelationshipType() {
        return partyRelationshipType;
    }

    public void setPartyRelationshipType(PartyRelationshipType partyRelationshipType) {
        this.partyRelationshipType = partyRelationshipType;
    }

}
