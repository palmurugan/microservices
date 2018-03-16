package com.genesis.party.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.genesis.party.domain.PartyType;

public interface IPartyTypeService {

    PartyType saveOrUpdatePartyType(PartyType partyType);

    Page<PartyType> getAllPartyTypeList(Pageable pageable);

    Optional<PartyType> getPartyType(Long partyTypeId);

    void deletePartyType(Long partyTypeId);

}
