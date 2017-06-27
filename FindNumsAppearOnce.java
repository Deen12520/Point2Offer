package ween_2;

import java.util.LinkedHashMap;

/**
 * ��ָoffer: ���ַ������ҳ���һ��ֻ����һ�ε��ַ�.
 * ����:1.�Ƚ�,O(n^2);2.hash��(�Ƽ�)-linkedHashMap
 * ��������:���ܲ���(����ֻ����һ�ε��ַ�;������;�����ַ���ֻ����һ��)
 * �����������(�ַ���Ϊ��)
 * @author dingding
 * Date:2017-6-19 9:00
 * Declaration: All Rights Reserved!
 */
public class FindNumsAppearOnce {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	private static Character findFirstNumAppearOnce (String string){
		if (string==null) {
			return null;
		}
		char[] sChar = string.toCharArray();
		LinkedHashMap<Character, Integer> hashChar = new LinkedHashMap<Character,Integer>();
		for (char item:sChar){
			if (hashChar.containsKey(item)) {
				hashChar.put(item, hashChar.get(item)+1);
			}else {
				hashChar.put(item,1);
			}
		}
		//����
		for (char key:hashChar.keySet()){
			if (hashChar.get(key)==1) {
				return key;
			}
		}
		return null;
	}
	/*================��������======================*/
	//����ֻ����һ��
	private static void test1() {
		System.out.println(findFirstNumAppearOnce("abaccdeff"));
		System.out.println("=====================");
	}
	//������
	private static void test2() {
		System.out.println(findFirstNumAppearOnce("aaccddff"));
		System.out.println("=====================");
	}
	//ÿ���ַ���ֻ����һ��
	private static void test3() {
		System.out.println(findFirstNumAppearOnce("abcdefgh"));
		System.out.println("=====================");
	}
	//�ַ���Ϊ��
	private static void test4() {
		System.out.println(findFirstNumAppearOnce(""));
	}

}
