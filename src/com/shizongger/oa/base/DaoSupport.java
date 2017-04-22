package com.shizongger.oa.base;

import java.util.List;

/**
 * 泛型接口
 * @author shizongger
 * @param <T>
 */
public interface DaoSupport<T> {

	public void add(T entity);
	
	public void delete(Long id);
	
	public void update(T entity);
	
	public T selectById(Long id);
	
	public List<T> selectAll();
	
	public List<T> getByIds(Long[] ids);
}
