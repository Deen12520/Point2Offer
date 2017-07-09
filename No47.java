package week_4;
/**难度系数:***
 * 剑指offer: 不用加减乘除做加法
 * 方法: 位运算
 * 测试用例:功能测试
 * @author dingding
 * Date:2017-7-7 21:10
 * Declaration: All Rights Reserved!
 */
public class No47 {

	public static void main(String[] args) {
		test1();
		test2();
	}

	//solution
	private static int add(int num1,int num2){
		int sum,carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) <<1;
			
			num1 =sum;
			num2 = carry;
		} while (num2!=0);
		return num1;
	}
	
	/*==================测试用例================*/
	private static void test1() {
		int result = add(12, 14);
		System.out.println(result);
	}

	private static void test2() {
		int result = add(12, -14);
		System.out.println(result);
	}

}
