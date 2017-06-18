package com;

import java.util.Random;
/**
 * ��ָoffer: ����,ʹ�����һ������Ϊ�Ƚ϶���(��ʹ����������,ֻ������һ��������λ��)
 * ��������:���ܲ���(һ�����˳�����,�ں������ͬ���򶼲���ͬ)
 * @author dingding
 * Date:2017-6-16 11:00
 * Declaration: All Rights Reserved!
 */

public class QuickSort {

	public static void main(String[] args) {
		test1();
	}
	
	//��Ƭ
	private static int partition(int[] a,int p,int r){
		int x=a[r];
		int i=p-1;
		for (int j=p;j<r;++j){   //j������r-1,�������һ��Ԫ��
			if (a[j]<=x) {
				i++;
				exchange(a,j,i);
			}
		}
		exchange(a,i+1, r);
		return i+1;
	}
	
	//�Ի�λ��
	private static int[] exchange(int[] a,int i, int j) {
		int temp;
		temp =a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return a;
	}

	//��������
	private static void qSort(int[] a,int l,int r){
		int p;
		if (l<r) {
			p = partition(a, l, r);
			qSort(a, l, p-1);
			qSort(a, p+1, r);
		}
	}
	
	/*================��������===============*/
	//һ���������
	private static void test1() {
		System.out.println("����һ����������: ");
		Random random = new Random();
		int[] num=new int[8];
		for (int i=0;i<8;i++){
			num[i] = random.nextInt(10)+1;
			System.out.print(num[i]+" ");
		}
		System.out.println();
		qSort(num, 0, num.length-1);
		System.out.println("�����: ");
		for (int x:num){
			System.out.print(x+" ");
		}
	}
}
