package com.dark.ant;

import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import com.dark.ant.test.HelloWorld;

/**
 * @author idiot
 * @version 1.0
 * @date 2015年12月29日 上午11:53:31
 */
public class TestHelloWorld {

	private HelloWorld hw;

	@Before
	public void setUp() {
		hw = new HelloWorld();
	}

	@Test
	public void TestHello() {
		String str = hw.hello();
		assertEquals("测试成功", "world", str);
	}

	@Test
	public void TestWorld() {
		String str = hw.world();
		assertEquals("测试成功", "hello", str);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testException() {
		hw.Exception();
	}

	@Test(timeout = 1009)
	public void testTime() {
		hw.time();
	}

	@Test
	public void testReturnNull() {
		assertNull(hw.returnNull());
	}

	@Test
	public void testReturnNotNull() {
		assertNotNull(hw.returnNotNull());
	}

	@After
	public void tearDown() {
		hw = null;
	}
}
