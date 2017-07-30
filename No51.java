package week_6;
/**难度系数:***
 * 剑指offer: 数组中第一个重复的数字
 * 方法: 只需交换2次就能到自己的位置,时间复杂度为 O(n)
 * 测试用例:一对重复,多对重复,无重复,数组为空
 * @author dingding
 * Date:2017-7-19 8:40
 * Declaration: All Rights Reserved!
 */
public class No51 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	//solution
	private static boolean findFirstDuplicatedNumber(int[] numbers){
		if (numbers == null || numbers.length<=0) {
			return false;
		}
		for (int i=0;i<numbers.length;++i) {
			if (numbers[i] <0 || numbers[i] >=numbers.length) { 
				return false;
			}
		}
		
		for (int j=0;j<numbers.length;++j) {
			while (numbers[j] != j){
				if (numbers[j]==numbers[numbers[j]]) {
					System.out.println(numbers[j]);
					return true;
				}
				int temp = numbers[j];
				numbers[j] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
 	}

	/*=================测试用例==============*/
	private static void test1() {
		int[] numbers = {2,0,1,2,3,4};
		if (!findFirstDuplicatedNumber(numbers)) {
			System.out.println("Not found.");
		}
	}

	private static void test2() {
		int[] numbers = {2,0,1,2,3,4,6,3};
		if (!findFirstDuplicatedNumber(numbers)) {
			System.out.println("Not found.");
		}		
	}

	private static void test3() {
		int[] numbers = {2,0,1,5,3,4};
		if (!findFirstDuplicatedNumber(numbers)) {
			System.out.println("Not found.");
		}		
	}

	private static void test4() {
		int[] numbers = {};
		if (!findFirstDuplicatedNumber(numbers)) {
			System.out.println("Not found.");
		}		
	}

}
