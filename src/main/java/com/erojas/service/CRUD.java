package com.erojas.service;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

	Optional<T> findById(long id);

	public Long generateId();

	void save(T entity);

	void update(T entity);

	void deleteById(long id);

	List<T> findAll();

	void deleteAll();

	public boolean isUserExist(long id);
}
