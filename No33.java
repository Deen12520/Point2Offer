package week_4;
/**难度系数:***
 * 剑指offer: 把数组排成最小的数
 * 方法: 整数转为字符串,然后进行字符串比较大小,进行排序
 * 测试用例:
 * @author dingding
 * Date:2017-7-9 9:00
 * Declaration: All Rights Reserved!
 */
public class No33 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	//solution,整数转为字符串,然后进行字符串比较大小,进行排序
	private static void genMinNumber(int[] numbers){
		if (numbers == null || numbers.length<=0) {
			return;
		}
		
		String[] strNumbers = new String[numbers.length];   //字符串数组
		for (int i=0;i<numbers.length;++i){
			strNumbers[i] = String.valueOf(numbers[i]);
		}
		
		//字符串数组进行排序,采用冒泡法
		for (int j=0;j<strNumbers.length-1;++j){
			for (int k=0;k<strNumbers.length-j-1;++k){
				if (compare(strNumbers[k],strNumbers[k+1])) {
					String temp = strNumbers[k];
					strNumbers[k] = strNumbers[k+1];
					strNumbers[k+1] = temp;
				}
			}
		}
		
		String result = "";
		int numberOf0 = 0; //记录0的个数
		for (int i=0;i<strNumbers.length;++i){
			if (strNumbers[i].equals("0")) {
				numberOf0++;
				continue;
			}
			result +=strNumbers[i];
		}
		if (numberOf0 >= strNumbers.length) {
			result = "0";
		}else {
			for (int j=0;j<numberOf0;j++){
				result +="0";
			}
		}
		
		System.out.println(result);
	}
	
	//比较两字符串构成数
	private static boolean compare(String string1, String string2) {
		if (Integer.parseInt(string2) == 0) {
			return true;
		}
		String combineStr1 = string1+string2;
		String combineStr2 = string2 + string1;
		if (Integer.parseInt(combineStr1)>Integer.parseInt(combineStr2)) {  
			return true;
		}
		return false;
	}

	/*==================测试用例===============*/
	private static void test1() {
		int[] numbers = {3,32,321};
		genMinNumber(numbers);
	}

	private static void test2() {
		int[] numbers = {3,32,0,321};
		genMinNumber(numbers);		
	}
	
	private static void test3() {
		int[] numbers = {0,0,0};
		genMinNumber(numbers);		
	}

}
