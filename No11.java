package ween_2;

/**难度系数:***
 * 剑指offer: 数值的整数次方
 * 方法:考虑指数为负和底数为0
 * 测试用例:功能测试(指数为正,指数为负,指数为0)
 * 特殊输入测试(底数为0)
 * @author dingding
 * Date:2017-6-22 17:00
 * Declaration: All Rights Reserved!
 */
public class No11 {
	private static boolean invalidInput = false;
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	//计算
	private static double power(double base,int exponent){
		invalidInput = false;
		if (equal(base,0.0) && exponent<0) {
			invalidInput = true;
			return 0.0;
		}
		int absExponent = exponent;
		if (exponent<0) {
			absExponent = -exponent;
		}
		double result = powerWithAbsExponent(base,absExponent);
		if (exponent<0) {
			result = 1.0/result;
		}
		return result;
	}

	//计算次方(使用递归方法,效率更高)
	private static double powerWithAbsExponent(double base, int absExponent) {
		if (absExponent==0) {
			return 1;
		}
		if (absExponent==1) {
			return base;
		}
		
		double result = powerWithAbsExponent(base, absExponent>>1);
		result *=result;
		if ((absExponent&1) == 1) {
			result*=base;
		}
//		for (int i=1;i<=absExponent;i++){
//			result*=base;
//		}
		return result;
	}

	//判断是否等于0
	private static boolean equal(double a, double b) {
		if ((a-b>-0.0000001)&&(a-b<0.0000001)) {
			return true;
		}else {
			return false;			
		}
	}

	private static void test1() {
		double result = power(2, 4);
		System.out.println(result);
	}

	private static void test2() {
		double result = power(2, -3);
		System.out.println(result);
		
	}

	private static void test3() {
		double result = power(0, -1);
		System.out.println(result);
		
	}

	private static void test4() {
		double result = power(-2, 4);
		System.out.println(result);
	}

}
