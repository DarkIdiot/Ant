package com.dark.ant.test;

/**
 * @author idiot
 * @version 1.0
 */
public class HelloWorld {
	public static void main(String[] args) {
		for (String string : args) {
			System.out.println("arg = " + string);
		}
	}

	public String hello() {
		return "world";
	}

	public String world() {
		return "hello";
	}

	public void Exception() {
		throw new RuntimeException("junit test");
	}

	public Object returnNull() {
		return null;
	}

	public Object returnNotNull() {
		return "junit test";
	}

	public void time() {
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
