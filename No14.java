package ween_2;
/**
 * 剑指offer: 调整数组顺序使奇数位于偶数前面
 * 方法:两个指针
 * 测试用例:功能测试(123456,135246,1,246135,13)
 * 特殊输入测试(数组为空)
 * @author dingding
 * Date:2017-6-21 16:19
 * Declaration: All Rights Reserved!
 */
public class No14 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//solution
	private static void oddAheadOfEven(int[] arr){
		if (arr == null || arr.length<1) {
			return;
		}
		int pBegin = 0;
		int pEnd = arr.length-1;
		while (pBegin<pEnd){
			//向后移动pBedin,直到找到偶数
			while (pBegin<pEnd && (arr[pBegin]&1)!=0){   //(i&1)==0 代表i为偶数
				pBegin++;
			}
			
			//向前移动pEnd,直到找到奇数
			while (pBegin<pEnd && (arr[pEnd]&1)==0){
				pEnd--;
			}
			
			if (pBegin<pEnd) {
				int tmp = arr[pBegin];
				arr[pBegin] = arr[pEnd];
				arr[pEnd] = tmp;
			}
		}
	}
	
	//判断偶数
	boolean isOdd(int n){
		return (n & 1) == 0;   //true 为偶数
	}
	
	/*=======================测试用例=============*/
	private static void test1() {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4,5,6};
		oddAheadOfEven(arr);
		for(int number:arr){
			System.out.print(number+" ");
		}
		System.out.println();
		System.out.println("========================");
	}

	private static void test2() {
		int[] arr={1,3,5,2,4,6};
		oddAheadOfEven(arr);
		for(int number:arr){
			System.out.print(number+" ");
		}
		System.out.println();
		System.out.println("========================");
	}

	private static void test3() {
		int[] arr={2,4,6,1,3,5};
		oddAheadOfEven(arr);
		for(int number:arr){
			System.out.print(number+" ");
		}	
		System.out.println();
		System.out.println("========================");
	}

	private static void test4() {
		int[] arr={2};
		oddAheadOfEven(arr);
		for(int number:arr){
			System.out.print(number+" ");
		}	
		System.out.println();
		System.out.println("========================");
	}

	private static void test5() {
		int[] arr={1,3};
		oddAheadOfEven(arr);
		for(int number:arr){
			System.out.print(number+" ");
		}	
		System.out.println();
		System.out.println("========================");
	}

	private static void test6() {
		int[] arr={};
		oddAheadOfEven(arr);
		if (arr.length<1 || arr == null) {
			System.out.print("无效数组. ");
			return;
		}
		for(int number:arr){
			System.out.print(number+" ");
		}	
	}
}
