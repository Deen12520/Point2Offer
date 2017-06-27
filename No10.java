package ween_2;
/**难度系数:**
 * 剑指offer: 二进制中1的个数
 * 方法:位运算
 * 测试用例:功能测试(正数{121,1,0x7FFFFFFF},负数(0x80000000,0xffffffff))
 * 特殊输入测试(0)
 * @author dingding
 * Date:2017-6-22 12:30
 * Declaration: All Rights Reserved!
 */
public class No10 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//solution,不能右移数字
//	private static int numberOf1(int n){
//		int count = 0;
//		int flag = 1;
//		while (flag!=0){
//			if ((n & flag)!=0) {
//				count++;
//			}
//			flag = flag<<1;    //箭头指向:左移乘2,右移除以2
//		}
//		return count;
//	}
	//最优解法,有多少个1就循环几次
	private static int numberOf1(int n){
		int count = 0;
		while (n!=0){
			++count;
			n = (n-1)&n;
		}
		return count;
	}
	/*====================测试用例======================*/
	private static void test1() {
		int result = numberOf1(9);
		System.out.println("结果为: "+result);
		System.out.println("========================");
	}

	private static void test2() {
		int result = numberOf1(1);
		System.out.println("结果为: "+result);
		System.out.println("========================");
	}

	private static void test3() {
		int result = numberOf1(0x7FFFFFFF);
		System.out.println("结果为: "+result);
		System.out.println("========================");		
	}

	private static void test4() {
		int result = numberOf1(0x80000000);
		System.out.println("结果为: "+result);
		System.out.println("========================");			
	}

	private static void test5() {
		int result = numberOf1(0xFFFFFFFF);
		System.out.println("结果为: "+result);
		System.out.println("========================");				
	}

	private static void test6() {
		int result = numberOf1(0);
		System.out.println("结果为: "+result);
		System.out.println("========================");		
	}
}
