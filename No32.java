package week_3;

/**难度系数:*****
 * 剑指offer: 从1到n整数中1出现的次数
 * 方法: 数字规律
 * 测试用例:功能测试(0,1(边界值),5,99,10000(大数))
 * @author dingding
 * Date:2017-6-28 13:25
 * Declaration: All Rights Reserved!
 */
public class No32 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//solution
	private static int findAllOf1From1ToN(int n){
		if (n<=0) {
			return 0;
		}
		String value = n+"";  //整数转为字符串
		int[] numbers = new int[value.length()];
		for (int i=0;i<numbers.length;i++){
			numbers[i] = value.charAt(i)-'0';  //字符转数字
		}
		return numberOf1(numbers,0);
	}
	
	//统计1出现次数,递归
	private static int numberOf1(int[] numbers, int curIndex) {
		if (numbers == null || curIndex>=numbers.length||curIndex<0) {
			return 0;
		}
		int first = numbers[curIndex];  // 待处理的第一个数字
		int length = numbers.length - curIndex;  //所在位数
		if (length == 1 && first == 0) {
			return 0;
		}
		if (length == 1 && first>0) {
			return 1;
		}
		int numFirstDigit = 0;
		if (first>1) {
			numFirstDigit = powerBase10(length-1);
		}else if (first==1) {
			numFirstDigit = atoi(numbers,curIndex+1)+1;
		}
		
		int numOtherDigits = first * (length-1) * powerBase10(length-2);
		int numRecursive = numberOf1(numbers, curIndex+1);
		
		return numFirstDigit+numOtherDigits+numRecursive;
	}

	//数字数组转换为数值
	private static int atoi(int[] numbers, int i) {
		int result = 0;
		for (int j=i;j<numbers.length;j++){
			result = (result*10+numbers[j]);
		}
		return result;
	}

	//求10的n次方
	private static int powerBase10(int n) {
		int result = 1;
		for (int i=0;i<n;i++){
			result *=10;
		}
		return result;
	}

	/*=====================测试用例======================*/
	private static void test1() {
		 System.out.println(findAllOf1From1ToN(1)); // 1		
	}

	private static void test2() {
		System.out.println(findAllOf1From1ToN(0)); // 0		
	}

	private static void test3() {
		System.out.println(findAllOf1From1ToN(10)); // 2			
	}

	private static void test4() {
		System.out.println(findAllOf1From1ToN(12)); 		
	}
	private static void test5() {
		System.out.println(findAllOf1From1ToN(10000)); 	
	}

	private static void test6() {
		System.out.println(findAllOf1From1ToN(21345)); 			
	}
}
