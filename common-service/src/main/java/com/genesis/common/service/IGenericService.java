package com.genesis.common.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author palmurugan
 *
 * @param <E>
 * @param <K>
 */
public interface IGenericService<E, K> {

    public E saveOrUpdate(E entity);

	public void saveOrUpdateAll(List<E> entities);

    public Page<E> getAll(Pageable pageable);

    public Optional<E> get(K id);

    public void remove(K id);

	public void removeAll(List<E> entities);
}
