package ween_2;
/**
 * 剑指offer: 翻转单词顺序
 * 方法:两次翻转,第一次翻转整个句子,第二次翻转单词
 * 测试用例:功能测试(有多个单词,1个单词)
 * 特殊输入测试(空指针,字符串为空,字符串只有空格)
 * @author dingding
 * Date:2017-6-20 20:00
 * Declaration: All Rights Reserved!
 */
public class ReverseWord {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	
	//翻转函数
	private static void reverse(char[] str,int start,int end){
		if (str==null || start<0 || end >str.length ||end <start || str.length<1) {
			return;   //if外面的其他语句都不会执行
		}
		while (start<end){
			char tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			
			start++;
			end--;
		}
	}
	
	//翻转句子
	private static char[] reverseSentence(char[] str){
		if (str == null || str.length<1) {
			return str;
		}
		
		reverse(str, 0, str.length-1);
		
		int start = 0;
		int end = 0;
		while (start <str.length ) {
			if (str[start] == ' ') {
				start++;
				end++;
			}else if (end == str.length ||str[end] == ' ' ) {  //或的左右顺序有关
				reverse(str, start, end-1);
				end++;
				start = end;
			}else {
				end++;
			}
		}
		return str;
	}

	/*====================测试用例=================*/
	private static void test1() {
		System.out.println(new String(reverseSentence("I am a student.".toCharArray())));
	}

	private static void test2() {
		System.out.println(new String(reverseSentence("Wonderful".toCharArray())));
	}

	private static void test3() {
		System.out.println(new String(reverseSentence("".toCharArray())));
	}

	private static void test4() {
		 System.out.println(new String(reverseSentence("    ".toCharArray())));
	}

	private static void test5() {
		if (reverseSentence(null)==null) {
			System.out.println("空指针!");
		}
	}

}
