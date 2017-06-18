package com;
/**
 * ��ָoffer: �����г��ִ�������һ�������
 * ����:1.����,��λ��(�ı�������);2.�������й���(����,������ô��,����ʣ��1)
 * ��������:���ܲ���(�����д���,����������������)
 * �����������(����ֻ��һ������,����Ϊ��)
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
	
	//����2:ͳ�ƹ���(����)
	private static int findMoreThanHalfNum_2(int[] arr,int length){
		if (checkInvalidArray(arr, length)) {
			return 0;	//TODO:�������Ϊ0
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
	
	//����1:����
	private static int findMoreThanHalfNum_1(int[] arr,int length){
		if (checkInvalidArray(arr,length)) {
			return 0;
		}
		
		int middle = length>>1;   //ȡ�м����
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
	
	//��ȡ�����Ƭλ��
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

	//����λ��
	private static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
	}

	//����Ƿ����
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

	//�ж�����������Ƿ���Ч
	private static boolean checkInvalidArray(int[] arr, int length) {
		if (arr == null||length<=0) {
			inputInvalid = true;
		}
		return inputInvalid;
	}

	/*======================��������================*/
	////����1���
	private static void test1() {
		System.out.println("����1:  ");
		int[] numbers = {1};
		int result = findMoreThanHalfNum_1(numbers,numbers.length);
		if (result==0) {
			System.out.println("Not Found!");
		}else {
			System.out.println(result);
		}
		
	}
	//����2���
	private static void test2(){
		System.out.println("����1:  ");
		int[] numbers = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		int result = findMoreThanHalfNum_2(numbers,numbers.length);
		if (result==0) {
			System.out.println("Not Found!");
		}else {
			System.out.println(result);
		}
	}
}
