package com.genesis.party.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.genesis.party.domain.PartyType;

/**
 * 
 * @author palmurugan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyTypeServiceTest {

	@Autowired
	private IPartyTypeService partyTypeService;

	private Long partyTypeId;

	@Test
	public void testCreate() {
		PartyType partyType = partyTypeService.saveOrUpdate(getTestData());
		Assert.assertEquals("test-partyType", partyType.getName());

		this.partyTypeId = partyType.getPartyTypeId();
	}

	@Test
	public void testUpdate() {
		Optional<PartyType> partyTypeOptional = partyTypeService.get(this.partyTypeId);
		PartyType partyTypeUpdated = partyTypeOptional.get();
		partyTypeUpdated.setName("test-partyType-updated");

		PartyType partyType = partyTypeService.saveOrUpdate(partyTypeUpdated);
		Assert.assertEquals("test-partyType-updated", partyType.getName());
	}

	@Test
	public void testRemove() {
		partyTypeService.remove(this.partyTypeId);
	}

	private PartyType getTestData() {
		return new PartyType("test-partyType");
	}

}
