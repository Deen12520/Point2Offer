package ween_2;

import java.util.LinkedHashMap;

/**
 * 剑指offer: 在字符串中找出第一个只出现一次的字符.
 * 方法:1.比较,O(n^2);2.hash表(推荐)-linkedHashMap
 * 测试用例:功能测试(存在只出现一次的字符;不存在;所有字符都只出现一次)
 * 特殊输入测试(字符串为空)
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
		//遍历
		for (char key:hashChar.keySet()){
			if (hashChar.get(key)==1) {
				return key;
			}
		}
		return null;
	}
	/*================测试用例======================*/
	//存在只出现一次
	private static void test1() {
		System.out.println(findFirstNumAppearOnce("abaccdeff"));
		System.out.println("=====================");
	}
	//不存在
	private static void test2() {
		System.out.println(findFirstNumAppearOnce("aaccddff"));
		System.out.println("=====================");
	}
	//每个字符都只出现一次
	private static void test3() {
		System.out.println(findFirstNumAppearOnce("abcdefgh"));
		System.out.println("=====================");
	}
	//字符串为空
	private static void test4() {
		System.out.println(findFirstNumAppearOnce(""));
	}

}
