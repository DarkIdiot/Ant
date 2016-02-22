package com.dark.ant;

/**
 * @author idiot
 * @version 1.0
 * @date 2015年12月29日 下午3:31:33
 */
import org.junit.Before;
import org.junit.Test;

import com.dark.ant.test.Calculate;

// 静态导入
import static org.junit.Assert.*;

/**
 * 使用Cobertura统计JUnit测试覆盖率
 * @see ----------------------------------------------------------------------------------------------------------
 * @see 生成测试覆盖率报告有三种方式(Maven--Ant--命令行)
 * @see Cobertura下载地址为http://sourceforge.net/projects/cobertura/files/
 * @see Cobertura结合Maven使用起来是极为方便的,详见http://blog.csdn.net/jadyer/article/details/7658734
 * @see Cobertura结合Ant生成报告也是非常方便的,详见本文下方给出的build.xml
 * @see 最麻烦的就是用命令行(不推荐)
 * @see ----------------------------------------------------------------------------------------------------------
 * @see 通过命令行生成报告
 * @see 0)先交待下工程的目录结构,src下存放应用代码,test下存放测试代码,bin下存放应用代码和测试代码的class文件
 * @see 1)解压cobertura-1.9.4.1-bin.zip到本地硬盘,并将D:\Develop\cobertura-1.9.4.1加入环境变量path
 * @see 2)将要测试的应用代码、编译之后的class文件和所需jar拷到一个单独的目录中
 * @see   拷贝完毕后的目录结构为D:\report\lib,D:\report\src,D:\report\bin(含所有的class文件)
 * @see 3)在命令提示行中使用命令为要生成测试覆盖率报告的代码生成一个ser文件
 * @see   这一步主要的目的是为需要生成报告的class文件加入Cobertura标记,用来告诉Cobertura哪些文件需要生成测试覆盖率报告
 * @see   D:\report\bin>cobertura-instrument --destination instrumented com/jadyer/service
 * @see 4)基于ser文件运行测试
 * @see   这一步主要的目的是跑一便JUnit测试,并将测试结果加入到第三步所标记的相对应的class文件内,以便于下一步生成覆盖率报告
 * @see   D:\report\bin>java -cp ../lib/junit-4.10.jar;../lib/cobertura.jar;instrumented;.;-Dnet.source
 * @see   forge.cobertura.datafile=cobertura.ser org.junit.runner.JUnitCore com.jadyer.service.CalculatorServiceTest
 * @see 5)根据ser文件生成测试覆盖率报告
 * @see   这一步主要的目的是生成报告,同时关联第三步所标记的class文件的源码
 * @see   D:\report\bin>cobertura-report --format html --datafile cobertura.ser --destination reports ../src
 * @see 这里面有两点需要注意一下
 * @see 1)如果测试代码的包名与应用代码的包名相同(事实上这很正常),那么通过以上5步所生成的报告中,会有一点无伤大雅的小问题
 * @see   那就是报告中即含有应用代码的测试覆盖率报告(它会按照实际覆盖率显示),也含有测试代码的测试覆盖率报告(它会显示100%)
 * @see   产生这一结果主要在于上面的第三步操作,由于包名相同故它会将测试代码的class也纳入报告标记的范围内
 * @see   我曾试过为它加入--excludeClasses参数,发现竟没有效果,可能我哪里没写对,不深究了,反正以后也没打算用命令行
 * @see   不过用本文提供的Ant脚本就不会出现这个问题了(Ant脚本中的<exclude name="/>是起作用的)
 * @see 2)若文件编码为UTF-8,则生成的报告中可能会乱码,此时只需为cobertura-report.bat增加-Dfile.encoding=UTF-8参数即可
 * @see   即为D:\Develop\cobertura-1.9.4.1\cobertura-report.bat文件里面的java命令加上此参数即可
 * @see ----------------------------------------------------------------------------------------------------------
 */
public class TestCalculate4Junit4 {
	private Calculate cal;
	
	// 执行任意一个方法之前都会执行setUp方法
	@Before
	public void setUp(){
		cal = new Calculate();
	}
	
	// 加了@Test表示该方法是一个单元测试
 	@Test
	public void testAdd(){
		/*
		 * 以下是一个简单的断言的编写
		 * 第一个参数是如果出错给出的提示信息
		 * 第二个表示期望值，通常是用户指定的内容
		 * 第三个表示代码返回的实际值
		 */
	//	Assert.assertEquals("加法有问题", 34, cal.add(12,22));
 		/*
 		 * 由于包进行了静态导入之后
 		 * Assert中的所有静态方法就不用再添加类名了
 		 * 这样可以有效地兼容junit3
 		 */
 		assertEquals("加法有问题", 34, cal.add(12,22));
	}
 	@Test
 	public void testMinus(){
 		int res = cal.minus(12, 2);
 //		Assert.assertEquals("减法有问题", 10, res);
 		assertEquals("减法有问题", 10, res);
 	}
 	// 表示这个测试类应该抛出ArithmeticException,如果不抛出就报错
 	@Test(expected=ArithmeticException.class)
 	public void testDivide(){
 		int res = cal.divide(12, 0);
 		assertEquals("除法有问题", 6, res);
 	}
 	
 	// 时间单位为ms
 	@Test(timeout=214)
 	public void testTime() throws InterruptedException{
 	 	Thread.sleep(209);
 		int rel = cal.divide(12, 2);
 	}
 	
 	@Test
 	public void testMulti(){
 		int res = cal.multi(12, 2);
 		assertEquals("乘法有问题",24,res);
 	}
 	//hamcrest 1.3
}
