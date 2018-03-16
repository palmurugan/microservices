package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.genesis.party.domain.Organization;

//@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {

}
