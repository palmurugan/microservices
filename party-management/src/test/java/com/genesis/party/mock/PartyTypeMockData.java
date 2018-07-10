package com.genesis.party.mock;

import static com.genesis.party.util.MockConstants.CREATEDBY;
import static com.genesis.party.util.MockConstants.TESTDATA;
import static com.genesis.party.util.MockConstants.UPDATEDBY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.genesis.party.domain.PartyType;;

public class PartyTypeMockData {

	public static PartyType getPartyType() {
		PartyType partyType = new PartyType(1L, TESTDATA);
		partyType.setCreatedBy(CREATEDBY);
		partyType.setUpdatedBy(UPDATEDBY);
		partyType.setCreatedDate(new Date());
		partyType.setUpdatedDate(new Date());
		return partyType;
	}

	public static Page<PartyType> getPagedPartyType() {
		List<PartyType> partyTypeList = new ArrayList<>();
		partyTypeList.add(getPartyType());
		return new PageImpl<>(partyTypeList, getPageable(), partyTypeList.size());
	}

	private static Pageable getPageable() {
		return PageRequest.of(1, 5);
	}
}
