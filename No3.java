package ween_2;
/**
 * 剑指offer: 二维数组中的查找(数组是从左到右,从上到下递增)
 * 方法:右上角或左下角突破口
 * 测试用例:功能测试(查找的数字是最大数或最小数或最大数和最小数之间;查找的数字大于最大或小于最小或在这之间却不存在)
 * 特殊输入测试(数组为空)
 * @author dingding
 * Date:2017-6-21 10:40
 * Declaration: All Rights Reserved!
 */
public class No3 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//查找
	private static boolean find(int[][] arr,int rows,int columns,int number){
		boolean found = false;
		if (arr == null) {
			return found;
		}
		if (number<arr[0][0] || number >arr[rows-1][columns-1]) {
			return found;
		}
		
		//右上角
		if (arr != null && rows>0 && columns>0) {
			int row = 0;
			int column = columns-1;
			while (row<rows && column>=0){
				if (arr[row][column]==number) {
					found = true;
					break;
				}else if (arr[row][column]>number) {
					column--;
				}else {
					row++;
				}
			}
		}
		return found;
	}
	
	/*====================测试用例==================*/
	private static void test(int number){
		int[][] arr = {{1,2,8,9},
					   {2,4,9,12},
				       {4,7,10,13},
					   {6,8,11,15}};
		int rows = arr.length;
		int columns = arr[0].length;
		boolean flag = find(arr, rows, columns, number);
		if (flag) {
			System.out.println("Found!");
		}else {
			System.out.println("Not Found!");
		}
	}
	private static void test1() {
		test(15);
	}

	private static void test2() {
		test(1);
		
	}
	
	private static void test3() {
		test(7);
		
	}

	private static void test4() {
		test(16);
		
	}

	private static void test5() {
		test(0);
		
	}

	private static void test6() {
		test(5);
		
	}
}
