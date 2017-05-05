package com.shizongger.oa.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shizongger.oa.base.BaseAction;
import com.shizongger.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @return 板块列表
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Forum> forumList = forumService.selectAll();
		ActionContext.getContext().put("forumList", forumList);

		return "list";
	}

	
	/**
	 * @return 新增页面
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		return "saveUI";
	}
	
	/**
	 * @return 新增操作
	 * @throws Exception
	 */
	public String add() throws Exception {
		forumService.add(model);
		return "toList";
	}
	
	/**
	 * @return 删除操作
	 * @throws Exception
	 */
	public String delete() throws Exception {
		forumService.delete(model.getId());
		return "toList";
	}
	
	/**
	 * @return 修改页面
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		Forum forum  = forumService.selectById(model.getId());
		ActionContext.getContext().put("forum", forum);
		
		return "saveUI";
	}
	
	/**
	 * @return 修改
	 * @throws Exception
	 */
	public String edit() throws Exception {
		Forum forum = forumService.selectById(model.getId());
		if(forum != null) {
			forum.setDescription(model.getDescription());
			forum.setName(model.getName());
			forumService.update(forum);
		}
		
		return "toList";
	}
	
	/**
	 * @return 上移
	 * @throws Exception
	 */
	public String moveUp() throws Exception {
		forumService.moveUp(model.getId());
		return "toList";
	}
	
	/**
	 * @return 下移
	 * @throws Exception
	 */
	public String moveDown() throws Exception {
		forumService.moveDown(model.getId());
		return "toList";
	}
}
