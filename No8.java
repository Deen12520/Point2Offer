package ween_2;
/**
 * ��ָoffer: ��ת�������С����
 * ����:���ֲ���+˳���������������
 * ��������:���ܲ���(34512,34513,12345,1,10111)
 * �����������(����Ϊ��)
 * @author dingding
 * Date:2017-6-21 12:40
 * Declaration: All Rights Reserved!
 */
public class No8 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}
	
	//����
	private static int findMinNumberInArray(int[] arr,int length) throws NumberFormatException{
		if (arr == null || length<1) {
			throw new NumberFormatException("illegal number input."); 
		}
		
		int pBegin = 0;
		int pEnd = length-1;
		int pMid = pBegin;  //��������12345����
		while (arr[pBegin]>=arr[pEnd]){
			if (pEnd-pBegin == 1) {
				return arr[pEnd];
			}
			
			//ȡ�м�λ��
			pMid = (pBegin+pEnd)/2;
			
			//���˺��м���������,ֻ��˳����
			if (arr[pMid]==arr[pBegin] && arr[pMid]==arr[pEnd]) {
				return minInOrder(arr,pBegin,pEnd);
			}
			
			if (arr[pMid]>=arr[pBegin]) {
				pBegin = pMid;
			}else if (arr[pEnd]>=arr[pMid]) {
				pEnd = pMid;
			}
		}
		return arr[pMid];
	}

	//˳���� 10111��������,ͬʱ�����ַ�
	private static int minInOrder(int[] arr, int pBegin, int pEnd) {
		int min = arr[pBegin];
		for (int i=pBegin+1;i<=pEnd;i++) {
			if (arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}

	/*=====================��������==================*/
	private static void test(int[] arr){
		if (arr == null) {
			System.out.println("����Ϊ��!");
			return;
		}
		int length = arr.length;
		int result = findMinNumberInArray(arr, length);
		System.out.println("���Ϊ: "+result);
		System.out.println("============================");
	}
	private static void test1() {
		int[] arr = {3,4,5,1,2};
		test(arr);
	}

	private static void test2() {
		int[] arr = {3,4,5,1,1,2};
		test(arr);
	}

	private static void test3() {
		int[] arr = {3,4,5,1,2,2};
		test(arr);
	}
	
	private static void test4() {
		int[] arr = {1, 0, 1, 1, 1};
		test(arr);
	}
	
	private static void test5() {
		int[] arr = {1,2,3,4,5};
		test(arr);
	}
	
	private static void test6() {
		int[] arr = {7};
		test(arr);
	}
	
	private static void test7() {
		test(null);
	}

	
}
