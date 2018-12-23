package com.genesis.party.service;

import java.util.Optional;

import com.genesis.common.service.FieldValueExist;
import com.genesis.common.service.IGenericService;
import com.genesis.party.domain.PartyType;

public interface IPartyTypeService extends IGenericService<PartyType, Long>, FieldValueExist {

	public Optional<PartyType> findByName(String name);

}
