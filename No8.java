package ween_2;
/**
 * 剑指offer: 旋转数组的最小数字
 * 方法:二分查找+顺序查找针对特殊情况
 * 测试用例:功能测试(34512,34513,12345,1,10111)
 * 特殊输入测试(数组为空)
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
	
	//处理
	private static int findMinNumberInArray(int[] arr,int length) throws NumberFormatException{
		if (arr == null || length<1) {
			throw new NumberFormatException("illegal number input."); 
		}
		
		int pBegin = 0;
		int pEnd = length-1;
		int pMid = pBegin;  //处理类似12345情形
		while (arr[pBegin]>=arr[pEnd]){
			if (pEnd-pBegin == 1) {
				return arr[pEnd];
			}
			
			//取中间位置
			pMid = (pBegin+pEnd)/2;
			
			//两端和中间的数都相等,只能顺序处理
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

	//顺序处理 10111类似情形,同时处理单字符
	private static int minInOrder(int[] arr, int pBegin, int pEnd) {
		int min = arr[pBegin];
		for (int i=pBegin+1;i<=pEnd;i++) {
			if (arr[i]<min) {
				min = arr[i];
			}
		}
		return min;
	}

	/*=====================测试用例==================*/
	private static void test(int[] arr){
		if (arr == null) {
			System.out.println("数组为空!");
			return;
		}
		int length = arr.length;
		int result = findMinNumberInArray(arr, length);
		System.out.println("结果为: "+result);
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
