package com;
/**
 * 剑指offer: 替换字符串中的每个空格为02%
 * 方法:1.replaceAll;2.移动字符串;3.使用两个指针;
 * 测试用例:功能测试(字符串有空格,字符串没有空格(空格位置多种可能))
 * 特殊输入测试(字符串为空,字符串有多个连续的空格,1个空格)
 * @author dingding
 * Date:2017-6-16 18:00
 * Declaration: All Rights Reserved!
 */
public class ReplaceBlank {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	//方法1:替换,使用内置函数
	private static String replace_1(String str){
		str = str.replaceAll(" ", "%20");
		return str;
	}
	
	//方法2: 使用两个指针
	private static char[] replace_2(char[] string){
		if (string==null) {
			return null;
		}
		
		int originLength = 0;  //字符串实际长度
		int numberOfBlank = 0; //字符串中空格的数目
		for (int i=0;i<string.length;i++){
			originLength++;
			if (string[i]==' ') {  //" "表示字符串
				numberOfBlank++;
			}
		}
		
		int newLength = originLength+numberOfBlank*2;
		int indexOfOriginal = originLength-1;
		int indexOfNew = newLength-1;
		char[] newStr = new char[newLength];
		//循环结束条件(很关键)
		while (indexOfOriginal>=0){
			if (string[indexOfOriginal] ==' ') {
				newStr[indexOfNew--]='0';
				newStr[indexOfNew--]='2';
				newStr[indexOfNew--]='%';
			}else {
				newStr[indexOfNew--]=string[indexOfOriginal];
			}
			indexOfOriginal--;
		}
		return newStr;
	}
	
	/*===================测试用例=================*/
	private static void test(String str){
		System.out.println("替换前 : ");
		System.out.println(str);
//		System.out.println(str.length());
		System.out.println("方法1替换后  : ");
		String rString1 = replace_1(str);
		System.out.println(rString1);
		System.out.println("方法2替换后  : ");
		char[] cStr=replace_2(str.toCharArray());
		System.out.println(cStr);
		System.out.println("=====================");
	}
	
	//有空格,不连续
	private static void test1() {
		String str = " I am a hero.";
		test(str);
	}
	
	//有连续空格
	private static void test2() {
		String str = "I  am a hero. ";
		test(str);
	}
	//空字符串
	private static void test3() {
		String str = "";
		test(str);
	}
	//没有空格
	private static void test4() {
		String str = "dddddd";
		test(str);
	}
	//全是空格
	private static void test5() {
		String str = "    ";
		test(str);
	}
}
