package com.genesis.party.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.genesis.party.domain.Organization;

@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {

}
