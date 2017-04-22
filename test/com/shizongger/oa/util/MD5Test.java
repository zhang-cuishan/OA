package com.shizongger.oa.util;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

public class MD5Test {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String str1 = DigestUtils.md5Hex("1234");
		String str2 = DigestUtils.shaHex("1234");
		
		log.info("MD5摘要是:" + DigestUtils.md5(str1));
	}

}
