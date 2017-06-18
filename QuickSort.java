package com;

import java.util.Random;
/**
 * 剑指offer: 快排,使用最后一个数作为比较对象(如使用其他的数,只需和最后一个数调换位置)
 * 测试用例:功能测试(一组打乱顺序的数,内含多个相同数或都不相同)
 * @author dingding
 * Date:2017-6-16 11:00
 * Declaration: All Rights Reserved!
 */

public class QuickSort {

	public static void main(String[] args) {
		test1();
	}
	
	//分片
	private static int partition(int[] a,int p,int r){
		int x=a[r];
		int i=p-1;
		for (int j=p;j<r;++j){   //j遍历到r-1,不是最后一个元素
			if (a[j]<=x) {
				i++;
				exchange(a,j,i);
			}
		}
		exchange(a,i+1, r);
		return i+1;
	}
	
	//对换位置
	private static int[] exchange(int[] a,int i, int j) {
		int temp;
		temp =a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return a;
	}

	//快速排序
	private static void qSort(int[] a,int l,int r){
		int p;
		if (l<r) {
			p = partition(a, l, r);
			qSort(a, l, p-1);
			qSort(a, p+1, r);
		}
	}
	
	/*================测试用例===============*/
	//一个随机数组
	private static void test1() {
		System.out.println("输入一个无序数组: ");
		Random random = new Random();
		int[] num=new int[8];
		for (int i=0;i<8;i++){
			num[i] = random.nextInt(10)+1;
			System.out.print(num[i]+" ");
		}
		System.out.println();
		qSort(num, 0, num.length-1);
		System.out.println("排序后: ");
		for (int x:num){
			System.out.print(x+" ");
		}
	}
}
