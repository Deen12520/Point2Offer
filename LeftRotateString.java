package ween_2;

/**
 * 剑指offer: 左旋转字符串:前面若干字符移到尾部
 * 方法:和前面反转的方法类似,分成两部分,先局部翻转再整体翻转(旋转可转化为翻转)
 * 测试用例:功能测试(有多个单词,1个单词)
 * 特殊输入测试(空指针,字符串为空,字符串只有空格)
 * @author dingding
 * Date:2017-6-21 9:00
 * Declaration: All Rights Reserved!
 */
public class LeftRotateString {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	//翻转
	private static void reverse(char[] str,int start,int end){
		if (str==null || str.length<1 || start<0 || start>end ||end>str.length) {
			return;
		}
		while (start<end){
			char tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			
			start++;
			end--;
		}
	}
	
	//左旋转
	private static char[] leftRotate(char[] str,int n){
		if (str==null || n<0 || n>str.length) {
			return str;
		}
		reverse(str, 0, n-1);
		reverse(str, n, str.length-1);;
		reverse(str, 0, str.length-1);
		
		return str;
	}
	
	/*====================测试用例===================*/
	private static void test1() {
		System.out.println(new String(leftRotate("abcdefg".toCharArray(), 2)));
	}

	private static void test2() {
		System.out.println(new String(leftRotate("abcdefg".toCharArray(), 1)));
	}

}
