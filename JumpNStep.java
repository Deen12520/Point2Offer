package com;
/**
 * 剑指offer: 青蛙跳台阶,一次可跳1级台阶,也可以跳2级台阶,也可以跳n级台阶,跳上n级台阶总共有多少种解法
 * 方法:数学归纳法求 f(n)=2^(n-1)
 * 测试用例:功能测试(输入3,5,7)
 * 边界值测试(0,1,2)
 * 性能测试(输入较大的数字:40,50,100等)
 * @author dingding
 * Date:2017-6-15 16:00
 * Declaration: All Rights Reserved!
 */
public class JumpNStep {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	//计算
	private static long JumpToNStep(int n){
		if (n==0) {
			return 0;
		}else {
			long result = 1;
			for (int i=1;i<n;++i){
				result *=2;
			}
			return result;
		}
	}
	
	/*====================测试用例================*/
	//输入0
	private static void test1() {
		long result = JumpToNStep(0);
		System.out.println("结果为: "+result);
		System.out.println("=======================");
	}
	
	//输入1
	private static void test2() {
		long result = JumpToNStep(1);
		System.out.println("结果为: "+result);
		System.out.println("=======================");
		
	}
	
	//输入2
	private static void test3() {
		long result = JumpToNStep(2);
		System.out.println("结果为: "+result);
		System.out.println("=======================");
	}
	
	//输入5
	private static void test4() {
		long result = JumpToNStep(5);
		System.out.println("结果为: "+result);
		System.out.println("=======================");
		
	}
}
