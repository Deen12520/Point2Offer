package com;
/**
 * ��ָoffer: ������̨��,һ�ο���1��̨��,Ҳ������2��̨��,Ҳ������n��̨��,����n��̨���ܹ��ж����ֽⷨ
 * ����:��ѧ���ɷ��� f(n)=2^(n-1)
 * ��������:���ܲ���(����3,5,7)
 * �߽�ֵ����(0,1,2)
 * ���ܲ���(����ϴ������:40,50,100��)
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

	//����
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
	
	/*====================��������================*/
	//����0
	private static void test1() {
		long result = JumpToNStep(0);
		System.out.println("���Ϊ: "+result);
		System.out.println("=======================");
	}
	
	//����1
	private static void test2() {
		long result = JumpToNStep(1);
		System.out.println("���Ϊ: "+result);
		System.out.println("=======================");
		
	}
	
	//����2
	private static void test3() {
		long result = JumpToNStep(2);
		System.out.println("���Ϊ: "+result);
		System.out.println("=======================");
	}
	
	//����5
	private static void test4() {
		long result = JumpToNStep(5);
		System.out.println("���Ϊ: "+result);
		System.out.println("=======================");
		
	}
}
