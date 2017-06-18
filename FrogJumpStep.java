package com;

import java.util.Scanner;

/**
 * 剑指offer: 青蛙跳台阶,一次可跳1级台阶,也可以跳2级台阶,跳上n级台阶总共有多少种解法
 * 方法:和fibonacci问题类似
 * 测试用例:功能测试(输入3,5,7)
 * 边界值测试(0,1,2)
 * 性能测试(输入较大的数字:40,50,100等)
 * @author dingding
 * Date:2017-6-15 16:00
 * Declaration: All Rights Reserved!
 */
public class FrogJumpStep {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	
	//计算
	private static long frogJump(int n){
		int[] result={0,1,2};
		if (n<3) {
			return result[n];
		}
		long jumpNMinusOne=2;
		long jumpNMinusTwo=1;
		long jumpN = 0;
		for (int i=3;i<=n;++i){
			jumpN = jumpNMinusOne+jumpNMinusTwo;
			jumpNMinusTwo = jumpNMinusOne;
			jumpNMinusOne = jumpN;
		}
		return jumpN;
	}
	
	/*================测试用例=====================*/
	//输入5
	private static void test1() {
		long result = frogJump(5);
		System.out.println("结果为: "+result);
		System.out.println("======================");
	}
	//输入0
	private static void test2() {
		long result = frogJump(0);
		System.out.println("结果为: "+result);
		System.out.println("======================");
	}
	//输入1
	private static void test3() {
		long result = frogJump(1);
		System.out.println("结果为: "+result);
		System.out.println("======================");
	}
	//输入2
	private static void test4() {
		long result = frogJump(2);
		System.out.println("结果为: "+result);
		System.out.println("======================");
	}
	//输入40
	private static void test5() {
		long result = frogJump(40);
		System.out.println("结果为: "+result);
		System.out.println("======================");
	}
}
