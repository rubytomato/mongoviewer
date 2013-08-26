package com.example.mongoviewer.service;

import java.util.Date;
import java.util.List;

public interface IService<T> {

	public long count();

	public long count(T searchCondition);

	public T get(String id);

	public T find(T searchCondition);

	public List<T> search(int page, T searchCondition);

	public List<T> search(int page, T searchCondition, Date from, Date to);

	public int save(T model);

}
