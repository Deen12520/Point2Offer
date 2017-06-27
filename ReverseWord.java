package ween_2;
/**
 * ��ָoffer: ��ת����˳��
 * ����:���η�ת,��һ�η�ת��������,�ڶ��η�ת����
 * ��������:���ܲ���(�ж������,1������)
 * �����������(��ָ��,�ַ���Ϊ��,�ַ���ֻ�пո�)
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
	
	//��ת����
	private static void reverse(char[] str,int start,int end){
		if (str==null || start<0 || end >str.length ||end <start || str.length<1) {
			return;   //if�����������䶼����ִ��
		}
		while (start<end){
			char tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			
			start++;
			end--;
		}
	}
	
	//��ת����
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
			}else if (end == str.length ||str[end] == ' ' ) {  //�������˳���й�
				reverse(str, start, end-1);
				end++;
				start = end;
			}else {
				end++;
			}
		}
		return str;
	}

	/*====================��������=================*/
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
			System.out.println("��ָ��!");
		}
	}

}
