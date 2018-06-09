package com.genesis.common.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.genesis.common.service.IGenericService;

/**
 * 
 * @author palmurugan
 *
 * @param <E>
 * @param <K>
 */
public class GenericServiceImpl<E, K> implements IGenericService<E, K> {

	private PagingAndSortingRepository<E, K> repository;

	public GenericServiceImpl(PagingAndSortingRepository<E, K> repository) {
		this.repository = repository;
	}

	@Override
	public E saveOrUpdate(E entity) {
		return repository.save(entity);
	}

	@Override
	public Page<E> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<E> get(K id) {
		return repository.findById(id);
	}

	@Override
	public void remove(K id) {
		repository.deleteById(id);
	}

	@Override
	public void saveOrUpdateAll(List<E> entities) {
		entities.forEach(entity -> {
			repository.save(entity);
		});
	}

	@Override
	public void removeAll(List<E> entities) {
		entities.forEach(entity -> {
			repository.delete(entity);
		});
	}
}
