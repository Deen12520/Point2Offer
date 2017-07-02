package week_3;
/**难度系数:***
 * 剑指offer: 连续子数组的最大和
 * 方法:利用当前累加子数组和最大值or动态规划(未实践)
 * 测试用例:功能测试(全正数组,全负,有正有负,为空)
 * @author dingding
 * Date:2017-6-28 10:45
 * Declaration: All Rights Reserved!
 */
public class No31 {
	private static boolean isvalid = true;  //是否有效
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	private static int findMaxSumOfSubArray(int[] data,int length){
		if (data == null || length<1) {
			isvalid = false;
			return 0;
		}
		isvalid = true;  //以便下一次调用
		int addToNSum = 0;
		int nMaxSum = 0x80000000; //最小数
		for (int i=0;i<length;i++){
			if (addToNSum<=0) {    //这一步很巧妙
				addToNSum = data[i];
			}else{
				addToNSum +=data[i];
			}
			
			if (addToNSum > nMaxSum) {
				nMaxSum = addToNSum;
			}
		}
		return nMaxSum;
	}
	
	/*====================测试用例=================*/
	private static void test(int[] data,int length){
		int result = findMaxSumOfSubArray(data, length);
		if (!isvalid && result == 0) {
			System.out.println("invalid input.");
		}else {
			System.out.println("连续最大子数组和为: "+result);
		}
	}
	private static void test1() {
		int[] data = {1,-2,3,10,-4,7,2,-5};
		test(data, data.length);
	}

	private static void test2() {
		int[] data = {1,2,3,4,5};
		test(data, data.length);		
	}
	private static void test3() {
		int[] data = {-1,-4,-3,-5};
		test(data, data.length);		
	}

	private static void test4() {
		int[] data = {};
		test(data, data.length);		
	}
}
