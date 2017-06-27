package ween_2;

/**难度系数:***
 * 剑指offer: 数字在排序数组中出现的次数
 * 方法:二分查找
 * 测试用例:功能测试(不存在,存在1次,多次,最大值,最小值)
 * 特殊输入测试(数组为空,数组中只有一个数字)
 * @author dingding
 * Date:2017-6-27 20:00
 * Declaration: All Rights Reserved!
 */
public class No38 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}
	
	//返回第一个k的下标
	private static int getFirstK(int[] array,int length,int k,int start,int end){
		if (start>end) {
			return -1;
		}
		int middleIndex = (start+end)/2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			if ((middleIndex > 0 && array[middleIndex-1]!=k) || middleIndex==0) {
				return middleIndex;
			}else {
				end = middleIndex-1;
			}
		}else if (middleData>k) {
			end = middleIndex - 1;
		}else {
			start = middleIndex + 1;
		}
		
		return getFirstK(array, length, k, start, end);
	}
	
	//返回最后一个k的下标
	private static int getLastK(int[] array,int length,int k,int start,int end){
		if (start>end) {
			return -1;
		}
		int middleIndex = (start+end)/2;
		int middleData = array[middleIndex];
		if (middleData==k) {
			if ((middleIndex<length-1 && array[middleIndex+1]!=k) || middleIndex==length-1) {
				return middleIndex;
			}else {
				start = middleIndex+1;
			}
		}else if(middleData<k){
			start = middleIndex + 1;
		}else {
			end = middleIndex - 1;
		}
		
		return getLastK(array, length, k, start, end);
	}

	//计算出现的次数
	private static int getNumberOfK(int[] array,int length,int k){
		int number = 0;
		if (array == null || length<1) {
			return -1;
		}
		if (array != null && length>0) {
			int first = getFirstK(array, length, k, 0, length-1);
			int last = getLastK(array, length, k, 0, length-1);
			
			if (first>-1 && last > -1) {
				number = last - first +1;
			}
		}
		
		return number;
	}
	/*==================测试用例================*/
	private static void test(int[] array,int length,int k){
		int result = getNumberOfK(array, length, k);
		if (result != -1) {
			System.out.println(k+"出现的次数为: "+ result);
		}else{
			System.out.println("不是有效输入!");
		}
		
		System.out.println("====================");
	}
	private static void test1() {
		int[] array = {1,2,3,4,5,5,6};
		int k=7;
		test(array, array.length, k);
	}

	private static void test2() {
		int[] array = {1,2,3,4,5,5,6};
		int k=3;
		test(array, array.length, k);
	}

	private static void test3() {
		int[] array = {1,2,3,4,5,5,6};
		int k=5;
		test(array, array.length, k);
	}

	private static void test4() {
		int[] array = {1,2,3,4,5,5,6};
		int k=6;
		test(array, array.length, k);
	}

	private static void test5() {
		int[] array = {1,2,3,4,5,5,6};
		int k=1;
		test(array, array.length, k);		
	}

	private static void test6() {
		int[] array = {1};
		int k=1;
		test(array, array.length, k);		
	}

	private static void test7() {
		int[] array = {};
		int k=6;
		test(array, array.length, k);
	}

}
