package com.dark.ant;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author idiot
 * @version 1.0
 * @date 2015��12��29�� ����3:59:06
 */
//RunWith��ʾ�������һ��suite����
@RunWith(Suite.class)
//˵��������а�����Щ�����齨 
@SuiteClasses({ TestCalculate4Hamcrest.class, TestCalculate4Junit4.class,
		TestHelloWorld.class})
public class TestSuit {
	 /* 
     *  ����ԭ�� 
     *  1�����鴴��һ��ר�ŵ�source folder--->test����д��������� 
     *  2��������İ�Ӧ�ñ��ֺ���Ҫ���Ե���һ�� 
     *  3�����Ե�Ԫ�е�ÿ�����Է�����������Զ���ִ�У�û�д��򣬲������κλ������� 
     */  
}
