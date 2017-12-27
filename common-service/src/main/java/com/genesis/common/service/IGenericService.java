package com.genesis.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenericService<E, K> {

    public E saveOrUpdate(E entity);

    public Page<E> getAll(Pageable pageable);

    public E get(K id);

    public void remove(K id);
}
