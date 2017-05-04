package com.shizongger.oa.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
		log.debug("---list()---");
		return "list";
	}

	
	/**
	 * @return 新增页面
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		log.debug("---addUI()---");
		return "saveUI";
	}
	
	/**
	 * @return 新增操作
	 * @throws Exception
	 */
	public String add() throws Exception {
		log.debug("---add()---");
		return "toList";
	}
	
	/**
	 * @return 删除操作
	 * @throws Exception
	 */
	public String delete() throws Exception {
		log.debug("---delete()---");
		return "toList";
	}
	
	/**
	 * @return 修改页面
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		log.debug("---editUI()---");
		return "saveUI";
	}
	
	/**
	 * @return 修改
	 * @throws Exception
	 */
	public String edit() throws Exception {
		log.debug("---edit()---");
		return "toList";
	}
	
	/**
	 * @return 上移
	 * @throws Exception
	 */
	public String moveUp() throws Exception {
		log.debug("---moveUp()---");
		return "toList";
	}
	
	/**
	 * @return 下移
	 * @throws Exception
	 */
	public String moveDown() throws Exception {
		log.debug("---moveDown()---");
		return "toList";
	}
}
