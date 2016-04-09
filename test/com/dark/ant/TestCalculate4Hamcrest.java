package com.dark.ant;

import org.junit.Test;
// ��̬����
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * @author idiot
 * @version 1.0
 * @date 2015��12��29�� ����3:31:33
 */
public class TestCalculate4Hamcrest {

	/**
	 * �ر�ע�⣬���ʹ��junit4.10�� �����hamcrest��jar���Ƶ�junit��jar��֮ǰ��
	 *  �����������allOf���׳��쳣
	 */
	@Test
	public void testHamcrest() {
		// �Ƚ�50�Ƿ��50���
		assertThat(50, equalTo(50));
		// 50�Ƿ����30����С��60
		assertThat("����", 50, allOf(greaterThan(30), lessThan(60)));
		// �ж��ַ����Ƿ���.txt��β
		assertThat("����", "abc.txt", endsWith(".txt"));
	}

}
/**
 * hamcrest������Ч����junit�Ĳ�����������һЩ��ͨ�����������в���.
 * 
 * Hamcrest ��һ�����ԵĿ�ܣ����ṩ��һ��ͨ�õ�ƥ��� Matcher�����ʹ����Щƥ��
 * ������Ĺ��򣬳���Ա���Ը��Ӿ�ȷ�ı���Լ��Ĳ���˼�룬ָ�������趨�Ĳ��������� ���磬��ʱ����Ĳ������ݷ�Χ̫��
 * ȷ�����������ɸ��̶���ȷ��ֵ����ʱ�ᵼ�²��� �ǳ���������Ϊ�������Ĳ�������ֻҪ�����б仯���Ϳ��ܵ��²���ʧ�ܣ����� assertEquals( x,
 * 10 ); ֻ���ж� x �Ƿ���� 10����� x ������ 10�� ����ʧ�ܣ��� ��ʱ��ָ���Ĳ������ݷ�Χ�ֲ���̫��ȷ����ʱ�п��ܻ����ĳЩ���ûᵼ�²���
 * ��ͨ�������ݣ���Ȼ��ͨ���������Ĳ��ԣ������ͻή�Ͳ��Եļ� ֵ�� Hamcrest �ĳ��֣�
 * ������Ա��д���������ṩ��һ�׹���ͷ�����ʹ������Ը��Ӿ�ȷ�ı�����Ա������ �Ĳ��Ե���Ϊ��
 * 
 * hamcrest���õ�ƥ����:
 * 
 * ���� anything - ����ƥ��,����㲻���Ĳ����µĶ�����ʲô�����õ� describedAs - ���һ�����Ƶ�ʧ�ܱ���װ���� is -
 * �Ľ��ɶ���װ���� - ���� ��Sugar�� �߼� allOf - �������ƥ������ƥ���ƥ��, short circuits
 * (���Ѷ���һ����,�����Ƕ�·,�о�����,��û�з���)(�� Java &&) anyOf - ����κ�ƥ����ƥ���ƥ��, short circuits (��
 * Java ||) not - �����װ��ƥ������ƥ����ʱƥ��,��֮��Ȼ ���� equalTo - ���Զ������ʹ��Object.equals����
 * hasToString - ����Object.toString���� instanceOf, isCompatibleType - ��������
 * notNullValue, nullValue - ����null sameInstance - ���Զ���ʵ�� Beans hasProperty -
 * ����JavaBeans���� ���� array - ����һ������Ԫ��test an array��s elements against an array of
 * matchers hasEntry, hasKey, hasValue - ����һ��Map����һ��ʵ��,������ֵ hasItem, hasItems -
 * ����һ�����ϰ���һ��Ԫ�� hasItemInArray - ����һ���������һ��Ԫ�� ���� closeTo - ���Ը���ֵ�ӽ�������ֵ
 * greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - ���Դ��� �ı�
 * equalToIgnoringCase - �����ַ�����Ⱥ��Դ�Сд equalToIgnoringWhiteSpace - �����ַ������Կհ�
 * containsString, endsWith, startsWith - �����ַ���ƥ��
 */
