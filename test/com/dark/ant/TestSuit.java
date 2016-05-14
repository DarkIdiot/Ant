package com.dark.ant;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author idiot
 * @version 1.0
 * @date 2015年12月29日 下午3:59:06
 */
//RunWith表示这个类是一个suite的类
@RunWith(Suite.class)
//说明这个类中包含哪些测试组建 
@SuiteClasses({ TestCalculate4Hamcrest.class, TestCalculate4Junit4.class,
		TestHelloWorld.class})
public class TestSuit {
	 /* 
     *  测试原则： 
     *  1、建议创建一个专门的source folder--->test来编写测试类代码 
     *  2、测试类的包应该保持和需要测试的类一致 
     *  3、测试单元中的每个测试方法都必须可以独立执行，没有次序，不能有任何互相依赖 
     */  
}
