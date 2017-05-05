package com.shizongger.oa.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shizongger.oa.base.BaseJunitTest;
import com.shizongger.oa.service.ForumService;

public class ForumServiceImplTest extends BaseJunitTest{

	@Autowired
	private ForumService forumService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMoveUp() {
		forumService.moveUp(8L);
	}

	@Test
	public void testMoveDown() {
		forumService.moveDown(8L);
	}

}
