package com.shizongger.oa.service;

import java.util.List;

import com.shizongger.oa.domain.Forum;

public interface ForumService {
	
	public void add(Forum entity);

	public void delete(Long id);

	public void update(Forum entity);

	public Forum selectById(Long id);

	public List<Forum> getByIds(Long[] ids);

	public List<Forum> selectAll();

	public void moveUp(Long id);

	public void moveDown(Long id);
}
