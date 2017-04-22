package com.shizongger.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shizongger
 * @param <T> 实际操作的daomain实体
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	private Log log = LogFactory.getLog(this.getClass());	

	/**
	 * sessionFactory工厂
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public DaoSupportImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
	}
	
	/**
	 * 增加
	 */
	@Override
	public void add(T entity) {
		log.info("add:" + entity.toString());
		getSession().save(entity);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Long id) {
		Object object = selectById(id);
		if(object != null) {
			getSession().delete(object);
		}
	}

	/**
	 * 修改
	 */
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public T selectById(Long id) {
		return (T) getSession().get(this.clazz, id);
	}
	
	/**
	 * 根据id数组查找对象集合
	 * @param ids id的列表
	 * @return
	 */
	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}
	
	/**
	 * 根据id数组查询
	 */
	@Override
	public List<T> selectAll() {
		List<T> list = getSession().createQuery("FROM " + this.clazz.getSimpleName()).list();

		return list;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
