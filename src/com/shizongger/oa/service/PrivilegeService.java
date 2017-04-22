package com.shizongger.oa.service;

import java.util.List;

import com.shizongger.oa.domain.Privilege;

/**
 * 权限serivce
 * @author shizongger
 * date:2017/04/14
 */
public interface PrivilegeService {

	/**
	 * 权限的新增
	 * @throws Exception
	 */
	public void add(Privilege privilege);
	
	/**
	 * 权限编辑
	 */
	public void update(Privilege privilege);

	/**
	 * 删除权限
	 * @throws Exception
	 */
	public void delete(Long id);
	
	/**
	 * 查找所以权限
	 * @return
	 * @throws Exception
	 */
	public List<Privilege> selectAll();
	
	/**
	 * 查找一级菜单
	 * @return 一级菜单列表
	 */
	public List<Privilege> findTopList();
	
	/**
	 * 根据权限的ids数组查找所有的权限
	 * @param ids 权限数组
	 * @return
	 */
	public List<Privilege> getByIds(Long[] ids);
	
	/**
	 * 根据id查找权限
	 * @param id
	 * @return
	 */
	public Privilege selectById(Long id);
}