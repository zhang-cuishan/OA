package com.shizongger.oa.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shizongger.oa.base.DaoSupportImpl;
import com.shizongger.oa.domain.Forum;
import com.shizongger.oa.service.ForumService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {

	Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public void add(Forum forum) {
		super.add(forum);
		forum.setPosition(forum.getId().intValue());
	}

	@Override
	public List<Forum> selectAll() {
		return getSession()
				.createQuery("FROM Forum f ORDER BY f.position")
				.list();
	}

	/**
	 * 上移当前板块forum的位置position值
	 */
	@Override
	public void moveUp(Long id) {
		//获取当前板块
		Forum forum = selectById(id);
		//上一个forum
		Forum prexForum = (Forum)getSession()
							.createQuery("FROM Forum f WHERE f.position < ? ORDER BY f.position DESC")
							.setParameter(0, forum.getPosition())
							.setFirstResult(0)
							.setMaxResults(1)
							.uniqueResult();
		//最上面的不能再往上移动
		if(prexForum == null) {
			return;
		}
		
		//交换当前和上一个的position
		int position = forum.getPosition();
		forum.setPosition(prexForum.getPosition());
		prexForum.setPosition(position);
		
		//更新两个对象到数据库中
		getSession().save(forum);
		getSession().save(prexForum);
	}

	/**
	 * 向下移动当前板块
	 */
	@Override
	public void moveDown(Long id) {
		//获取当前板块
		Forum forum = selectById(id);
		
		//下一个forum
		Forum nextForum = (Forum)getSession()
							.createQuery("FROM Forum f WHERE f.position > ? ORDER BY f.position ASC")
							.setParameter(0, forum.getPosition())
							.setFirstResult(0)
							.setMaxResults(1)
							.uniqueResult();	
		
		//最下面的不能再往下移
		if(nextForum == null) {
			return;
		}
		
		//交换当前forum和下一个forum的position
		int position = nextForum.getPosition();
		nextForum.setPosition(forum.getPosition());
		forum.setPosition(position);
		
		//更新两个对象到数据库中去
		getSession().save(nextForum);
		getSession().save(forum);
	}
}
