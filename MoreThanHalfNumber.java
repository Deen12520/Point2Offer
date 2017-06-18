package com;
/**
 * 剑指offer: 数组中出现次数超过一半的数字
 * 方法:1.排序,中位数(改变了数组);2.数字排列规律(过半,不管怎么消,都会剩下1)
 * 测试用例:功能测试(数组中存在,不存在这样的数字)
 * 特殊输入测试(数组只有一个数字,数组为空)
 * @author dingding
 * Date:2017-6-16 14:00
 * Declaration: All Rights Reserved!
 */
public class MoreThanHalfNumber {
	static boolean inputInvalid = false;
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	//方法2:统计规律(更简单)
	private static int findMoreThanHalfNum_2(int[] arr,int length){
		if (checkInvalidArray(arr, length)) {
			return 0;	//TODO:处理过半为0
		}
		int result = arr[0];
		int times = 1;
		for (int i=0;i<length;i++){
			if (times == 0) {
				result = arr[i];
				times=1;
			}else if (arr[i]==result) {
				times++;
			}else{
				times--;
			}
		}
		
		if (!checkMoreThanHalf(arr, length, result)) {
			result = 0;
		}
		return result;
	}
	
	//方法1:快排
	private static int findMoreThanHalfNum_1(int[] arr,int length){
		if (checkInvalidArray(arr,length)) {
			return 0;
		}
		
		int middle = length>>1;   //取中间的数
		int start = 0;
		int end = length-1;
		int index = partition(arr,length,start,end);
		while (index!=middle){
			if (index>middle) {
				end = index-1;
				index = partition(arr, length, start, end);
			}else {
				start = index+1;
				index = partition(arr, length, start, end);
			}
		}
		int result = arr[middle];  
//		System.out.println(index+"==?"+middle);
		if (!checkMoreThanHalf(arr,length,result)) {
			return 0;
		}
		
		return result;
	}
	
	//获取数组分片位置
	private static int partition(int[] arr, int length, int start, int end) {
		int i = start-1;
		int x = arr[end];
		for (int j=start;j<end;j++){
			if (arr[j]<=x) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,end);
		return i+1;
	}

	//交换位置
	private static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}

	//检查是否过半
	private static boolean checkMoreThanHalf(int[] arr, int length, int result) {
		int times = 0;
		for (int i=0;i<length;i++){
			if (arr[i]==result) {
				times++;
			}
		}
		boolean isMoreThanHalf = true;
		if (times*2 <= length) {
			isMoreThanHalf = false;
			inputInvalid = true;
		}
		return isMoreThanHalf;
	}

	//判断输入的数组是否有效
	private static boolean checkInvalidArray(int[] arr, int length) {
		if (arr == null||length<=0) {
			inputInvalid = true;
		}
		return inputInvalid;
	}

	/*======================测试用例================*/
	////方法1结果
	private static void test1() {
		System.out.println("方法1:  ");
		int[] numbers = {1};
		int result = findMoreThanHalfNum_1(numbers,numbers.length);
		if (result==0) {
			System.out.println("Not Found!");
		}else {
			System.out.println(result);
		}
		
	}
	//方法2结果
	private static void test2(){
		System.out.println("方法1:  ");
		int[] numbers = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		int result = findMoreThanHalfNum_2(numbers,numbers.length);
		if (result==0) {
			System.out.println("Not Found!");
		}else {
			System.out.println(result);
		}
	}
}
