package week_3;
/**难度系数:***
 * 剑指offer: 数组中只出现一次的数字
 * 方法:异或运算,给数组分组(根据异或之后的第一个1)
 * 测试用例:功能测试(数组中存在多对重复数字,数组中没有重复的数字)
 * @author dingding
 * Date:2017-6-28 9:00
 * Declaration: All Rights Reserved!
 */
public class No40 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	//solution
	private static void findNumsAppearOnce(int[] data,int length){
		if (data == null || length<1) {
			return;
		}
		int resultExclusiveOR = 0;
		for (int i=0;i<length;i++){
			resultExclusiveOR ^=data[i];
		}
		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		int number1 = 0;  //第一个出现一次的数字
		int number2 = 0;
		for (int j=0;j<length;j++){
			if (isBit1(data[j],indexOf1)) {
				number1 ^=data[j];
			}else {
				number2 ^=data[j];
			}
		}
		System.out.println("这两个数为: "+number1+","+number2);
	}
	
	//查找数组中第n位也为1的数字,indexof1 返回的是1的下标,故不用加1
	private static boolean isBit1(int num, int indexOf1) {
		boolean flag = false;
		num = num >>indexOf1;
		if ((num & 1) == 1) {
			flag = true;
		}
		return flag;
	}
	//找到异或结果中右起第一个1
	private static int findFirstBitIs1(int resultExclusiveOR) {
		int indexBit = 0;
		while ((resultExclusiveOR & 1)==0){
			resultExclusiveOR = resultExclusiveOR >> 1;
			++ indexBit;
		}
		return indexBit;
	}
	/*=====================测试用例=================*/
	private static void test1() {
		int[] data= {2, 4, 3, 6, 3, 2, 5, 5};
		findNumsAppearOnce(data, data.length);
	}

	private static void test2() {
		int[] data= {3, 4};
		findNumsAppearOnce(data, data.length);
	}
	
	private static void test3() {
		int[] data= {4, 6, 1, 1, 1, 1};
		findNumsAppearOnce(data, data.length);
	}

}
