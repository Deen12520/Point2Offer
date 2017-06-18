package com;

import java.util.Scanner;

/**
 * 剑指offer: 斐波那契数列
 * 方法:最优递归,
 * 测试用例:功能测试(输入3,5,7)
 * 边界值测试(0,1,2)
 * 性能测试(输入较大的数字:40,50,100等)
 * @author dingding
 * Date:2017-6-15 16:00
 * Declaration: All Rights Reserved!
 */
public class Fibonacci {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	
	//原始的方法
	private static long fibonacci_formal(int n){
		if (n==0) {
			return 0;
		}else if (n==1||n==2) {
			return 1;
		}else {
			return fibonacci_formal(n-1)+fibonacci_formal(n-2);
		}
	}
	
	//计算
	private static long fibonacci_n(int n){
		int[] result = {0,1};
		if (n<2) {
			return result[n];
		}
		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		for (long i=2;i<=n;++i){
			fibN = fibNMinusOne+fibNMinusTwo;
			fibNMinusTwo=fibNMinusOne;        //先给小的赋值
			fibNMinusOne=fibN;
		}
		return fibN;
	}
	
	/*====================测试用例==========================*/
	private static void test(){
		System.out.println("输入N: ");
		Scanner fin = new Scanner(System.in);
		int N = fin.nextInt();
		System.out.println();
		long result = fibonacci_n(N);
		System.out.println("结果为: "+result);
		System.out.println("=========================");
	}
	
	//输入5
	private static void test1() {
		test();
	}
	
	//输入0
	private static void test2() {
		test();
	}

	//输入1
	private static void test3() {
		test();
	}
	//输入40
	private static void test4() {
		test();
	}
	//测试原始方法
	private static void test5(){
		System.out.println("测试原始方法(递归耗时): ");
		long result = fibonacci_formal(20);
		System.out.println("结果为: "+result);
	}
	
}
