package com;

import java.util.Scanner;

/**
 * ��ָoffer: 쳲���������
 * ����:���ŵݹ�,
 * ��������:���ܲ���(����3,5,7)
 * �߽�ֵ����(0,1,2)
 * ���ܲ���(����ϴ������:40,50,100��)
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
	
	//ԭʼ�ķ���
	private static long fibonacci_formal(int n){
		if (n==0) {
			return 0;
		}else if (n==1||n==2) {
			return 1;
		}else {
			return fibonacci_formal(n-1)+fibonacci_formal(n-2);
		}
	}
	
	//����
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
			fibNMinusTwo=fibNMinusOne;        //�ȸ�С�ĸ�ֵ
			fibNMinusOne=fibN;
		}
		return fibN;
	}
	
	/*====================��������==========================*/
	private static void test(){
		System.out.println("����N: ");
		Scanner fin = new Scanner(System.in);
		int N = fin.nextInt();
		System.out.println();
		long result = fibonacci_n(N);
		System.out.println("���Ϊ: "+result);
		System.out.println("=========================");
	}
	
	//����5
	private static void test1() {
		test();
	}
	
	//����0
	private static void test2() {
		test();
	}

	//����1
	private static void test3() {
		test();
	}
	//����40
	private static void test4() {
		test();
	}
	//����ԭʼ����
	private static void test5(){
		System.out.println("����ԭʼ����(�ݹ��ʱ): ");
		long result = fibonacci_formal(20);
		System.out.println("���Ϊ: "+result);
	}
	
}
