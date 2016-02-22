package com.dark.ant;

/**
 * @author idiot
 * @version 1.0
 * @date 2015��12��29�� ����3:31:33
 */
import org.junit.Before;
import org.junit.Test;

import com.dark.ant.test.Calculate;

// ��̬����
import static org.junit.Assert.*;

/**
 * ʹ��Coberturaͳ��JUnit���Ը�����
 * @see ----------------------------------------------------------------------------------------------------------
 * @see ���ɲ��Ը����ʱ��������ַ�ʽ(Maven--Ant--������)
 * @see Cobertura���ص�ַΪhttp://sourceforge.net/projects/cobertura/files/
 * @see Cobertura���Mavenʹ�������Ǽ�Ϊ�����,���http://blog.csdn.net/jadyer/article/details/7658734
 * @see Cobertura���Ant���ɱ���Ҳ�Ƿǳ������,��������·�������build.xml
 * @see ���鷳�ľ�����������(���Ƽ�)
 * @see ----------------------------------------------------------------------------------------------------------
 * @see ͨ�����������ɱ���
 * @see 0)�Ƚ����¹��̵�Ŀ¼�ṹ,src�´��Ӧ�ô���,test�´�Ų��Դ���,bin�´��Ӧ�ô���Ͳ��Դ����class�ļ�
 * @see 1)��ѹcobertura-1.9.4.1-bin.zip������Ӳ��,����D:\Develop\cobertura-1.9.4.1���뻷������path
 * @see 2)��Ҫ���Ե�Ӧ�ô��롢����֮���class�ļ�������jar����һ��������Ŀ¼��
 * @see   ������Ϻ��Ŀ¼�ṹΪD:\report\lib,D:\report\src,D:\report\bin(�����е�class�ļ�)
 * @see 3)��������ʾ����ʹ������ΪҪ���ɲ��Ը����ʱ���Ĵ�������һ��ser�ļ�
 * @see   ��һ����Ҫ��Ŀ����Ϊ��Ҫ���ɱ����class�ļ�����Cobertura���,��������Cobertura��Щ�ļ���Ҫ���ɲ��Ը����ʱ���
 * @see   D:\report\bin>cobertura-instrument --destination instrumented com/jadyer/service
 * @see 4)����ser�ļ����в���
 * @see   ��һ����Ҫ��Ŀ������һ��JUnit����,�������Խ�����뵽����������ǵ����Ӧ��class�ļ���,�Ա�����һ�����ɸ����ʱ���
 * @see   D:\report\bin>java -cp ../lib/junit-4.10.jar;../lib/cobertura.jar;instrumented;.;-Dnet.source
 * @see   forge.cobertura.datafile=cobertura.ser org.junit.runner.JUnitCore com.jadyer.service.CalculatorServiceTest
 * @see 5)����ser�ļ����ɲ��Ը����ʱ���
 * @see   ��һ����Ҫ��Ŀ�������ɱ���,ͬʱ��������������ǵ�class�ļ���Դ��
 * @see   D:\report\bin>cobertura-report --format html --datafile cobertura.ser --destination reports ../src
 * @see ��������������Ҫע��һ��
 * @see 1)������Դ���İ�����Ӧ�ô���İ�����ͬ(��ʵ���������),��ôͨ������5�������ɵı�����,����һ�����˴��ŵ�С����
 * @see   �Ǿ��Ǳ����м�����Ӧ�ô���Ĳ��Ը����ʱ���(���ᰴ��ʵ�ʸ�������ʾ),Ҳ���в��Դ���Ĳ��Ը����ʱ���(������ʾ100%)
 * @see   ������һ�����Ҫ��������ĵ���������,���ڰ�����ͬ�����Ὣ���Դ����classҲ���뱨���ǵķ�Χ��
 * @see   �����Թ�Ϊ������--excludeClasses����,���־�û��Ч��,����������ûд��,�����,�����Ժ�Ҳû������������
 * @see   �����ñ����ṩ��Ant�ű��Ͳ���������������(Ant�ű��е�<exclude name="/>�������õ�)
 * @see 2)���ļ�����ΪUTF-8,�����ɵı����п��ܻ�����,��ʱֻ��Ϊcobertura-report.bat����-Dfile.encoding=UTF-8��������
 * @see   ��ΪD:\Develop\cobertura-1.9.4.1\cobertura-report.bat�ļ������java������ϴ˲�������
 * @see ----------------------------------------------------------------------------------------------------------
 */
public class TestCalculate4Junit4 {
	private Calculate cal;
	
	// ִ������һ������֮ǰ����ִ��setUp����
	@Before
	public void setUp(){
		cal = new Calculate();
	}
	
	// ����@Test��ʾ�÷�����һ����Ԫ����
 	@Test
	public void testAdd(){
		/*
		 * ������һ���򵥵Ķ��Եı�д
		 * ��һ����������������������ʾ��Ϣ
		 * �ڶ�����ʾ����ֵ��ͨ�����û�ָ��������
		 * ��������ʾ���뷵�ص�ʵ��ֵ
		 */
	//	Assert.assertEquals("�ӷ�������", 34, cal.add(12,22));
 		/*
 		 * ���ڰ������˾�̬����֮��
 		 * Assert�е����о�̬�����Ͳ��������������
 		 * ����������Ч�ؼ���junit3
 		 */
 		assertEquals("�ӷ�������", 34, cal.add(12,22));
	}
 	@Test
 	public void testMinus(){
 		int res = cal.minus(12, 2);
 //		Assert.assertEquals("����������", 10, res);
 		assertEquals("����������", 10, res);
 	}
 	// ��ʾ���������Ӧ���׳�ArithmeticException,������׳��ͱ���
 	@Test(expected=ArithmeticException.class)
 	public void testDivide(){
 		int res = cal.divide(12, 0);
 		assertEquals("����������", 6, res);
 	}
 	
 	// ʱ�䵥λΪms
 	@Test(timeout=214)
 	public void testTime() throws InterruptedException{
 	 	Thread.sleep(209);
 		int rel = cal.divide(12, 2);
 	}
 	
 	@Test
 	public void testMulti(){
 		int res = cal.multi(12, 2);
 		assertEquals("�˷�������",24,res);
 	}
 	//hamcrest 1.3
}
