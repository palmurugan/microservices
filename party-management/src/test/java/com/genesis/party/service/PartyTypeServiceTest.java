package com.genesis.party.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.genesis.party.dao.PartyTypeRepository;
import com.genesis.party.service.impl.PartyTypeService;
import com.genesis.party.util.MockConstants;

/**
 * 
 * @author palmurugan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyTypeServiceTest {

	@InjectMocks
	private PartyTypeService partyTypeService;

	@Mock
	PartyTypeRepository repository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFieldValueExists() {
		when(repository.existsByName(MockConstants.TESTDATA)).thenReturn(Boolean.TRUE);
		Boolean exists = partyTypeService.fieldValueExists(MockConstants.TESTDATA, "email");
		Assert.assertEquals(Boolean.TRUE, exists);
	}

}
