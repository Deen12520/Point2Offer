package com;

import java.util.Scanner;

/**
 * ��ָoffer: ������̨��,һ�ο���1��̨��,Ҳ������2��̨��,����n��̨���ܹ��ж����ֽⷨ
 * ����:��fibonacci��������
 * ��������:���ܲ���(����3,5,7)
 * �߽�ֵ����(0,1,2)
 * ���ܲ���(����ϴ������:40,50,100��)
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
	
	//����
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
	
	/*================��������=====================*/
	//����5
	private static void test1() {
		long result = frogJump(5);
		System.out.println("���Ϊ: "+result);
		System.out.println("======================");
	}
	//����0
	private static void test2() {
		long result = frogJump(0);
		System.out.println("���Ϊ: "+result);
		System.out.println("======================");
	}
	//����1
	private static void test3() {
		long result = frogJump(1);
		System.out.println("���Ϊ: "+result);
		System.out.println("======================");
	}
	//����2
	private static void test4() {
		long result = frogJump(2);
		System.out.println("���Ϊ: "+result);
		System.out.println("======================");
	}
	//����40
	private static void test5() {
		long result = frogJump(40);
		System.out.println("���Ϊ: "+result);
		System.out.println("======================");
	}
}
