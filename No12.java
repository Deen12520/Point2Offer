package ween_2;
/**难度系数:****
 * 剑指offer: 打印1到最大的n位数
 * 方法:注意最大数是有多大?(字符串&递归)
 * 测试用例:功能测试(正数{121,1,0x7FFFFFFF})
 * 特殊输入测试(0,负数)
 * @author dingding
 * Date:2017-6-22 14:00
 * Declaration: All Rights Reserved!
 */
public class No12 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	//solution
	private static void print1ToMaxOfNDigits(int n){
		if (n<1) {
			return;
		}
		char[] number = new char[n];
		for (int i=0;i<10;i++){
			number[0] = (char) (i+'0');
			print1ToMaxOfNDigitsRecursively(number,n,0);
		}
	}
	//递归
	private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if (index == length-1) {
			printNumber(number);
			return;
		}
		for (int i=0;i<10;++i){
			number[index+1] = (char) (i+'0');
			print1ToMaxOfNDigitsRecursively(number, length, index+1);
		}
	}

	//打印字符串,去除前面的0
	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int length = number.length;
		for (int i=0;i<length;i++){
			if (isBeginning0 && number[i]!='0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.print("\t");
	}

	/*==============测试用例===============*/
	private static void test1() {
		print1ToMaxOfNDigits(1);
		System.out.println();
		System.out.println("=====================");
	}

	private static void test2() {
		print1ToMaxOfNDigits(0);
		System.out.println();
		System.out.println("=====================");
	}

	private static void test3() {
		print1ToMaxOfNDigits(-3);
		System.out.println();
		System.out.println("=====================");		
	}

	private static void test4() {
		print1ToMaxOfNDigits(2);
		System.out.println();
		System.out.println("=====================");		
	}
}
