package ween_2;
/**
 * 剑指offer: 字符串转换为整数.
 * 方法:考虑多种特殊输出
 * 测试用例:功能测试(输入的字符串表示正数,负数和0)
 * 边界值测试(最大的正整数,最小的负整数)
 * 特殊输入测试(空指针,字符串为空,字符串中含有非数字字符)
 * @author dingding
 * Date:2017-6-19 20:00
 * Declaration: All Rights Reserved!
 */
public class StrToInt {
    private static boolean isValid = true;  //判断输入字符串是否有效的标志
	public static void main(String[] args) {
		test(null);
	    test("");
	    test("123");
	    test("+123");
	    test("-123");
	    test("1a33");
	    test("+0");
	    test("-0");
	    //有效的最大正整数, 0x7FFFFFFF
	    test("+2147483647");    
	    test("-2147483647");
	    test("+2147483648");
	    //有效的最小负整数, 0x80000000
	    test("-2147483648");    
	    test("+2147483649");
	    test("-2147483649");
	    test("+");
	    test("-");
	    test("-a");
	    //test("423443  ");  //这种情况不能处理
	    test("423 443");
	}
	
	//字符转化为整数
	private static int changeStrToInt(String string){
		isValid = true;  //判断是否是有效输入
		if (string == null || string.length()==0) {
			isValid = false;
			return 0;
		}
		
		int start = 0;    //从开始找第一个不是空格的数
		boolean positive = true;
		
		//找到第一个非空字符
		if (string.charAt(start)==' ') {
			while (string.charAt(start)==' '){
				start++;
				if (start >=string.length()) {
					isValid = false;
					return 0;
				}
			}
		}
		
		//下列代码处理了前两个非空字符,减少了函数的调用.
		if (string.charAt(start)=='-') {
			positive = false;
			start++;
		}else if (string.charAt(start)=='+') {
			start++;
		}else if (string.charAt(start)>='0' && string.charAt(start)<='9') {
			return parseString(string,start,positive);
		}else{
			isValid = false;
			return 0;
		}
		
		if (start>=string.length()) {
			isValid = false;
			return 0;
		}
		
		if (string.charAt(start)>'9' || string.charAt(start)<'0') {
			isValid = false;
			return 0;
		}else{
			return parseString(string, start, positive);
		}
	}
	
	private static int  parseString(String string, int start, boolean positive) {
		long result = 0;
		while (start<string.length() && string.charAt(start)>='0' && string.charAt(start)<='9'){
			result = result*10 + (string.charAt(start)-'0');  //正常转化为整数
			
			if (positive) {
				if (result > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
			}else{
				if (-result < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
			start++;
		}
		
		if (positive) {
			if (start<string.length()) {
				isValid = false;
				return 0;
			}else{
				return (int)result;
			}
		}else {
			if (start<string.length()) {
				isValid = false;
				return 0;
			}else{
				return (int)-result;
			}
		}
	}

	/*==================测试用例====================*/
	private static void test(String string){
		int result = changeStrToInt(string);
		if (result == 0 && isValid==false) {
			System.out.println("The input "+string+" is invalid.");
		}else{
			System.out.println("Number for "+string+" is:"+result);
		}
	}
}
