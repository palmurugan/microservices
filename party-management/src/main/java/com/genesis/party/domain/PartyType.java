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
 * @author PalMurugan C
 *
 */
@Entity
@Table(name = "party_type")
public class PartyType extends Auditable<String> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2627086124301570090L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "party_type_id", unique = true, nullable = false)
    private Long partyTypeId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public PartyType(Long partyTypeId) {
        super();
        this.partyTypeId = partyTypeId;
    }

    public PartyType() {
        super();
    }

    public Long getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(Long partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
