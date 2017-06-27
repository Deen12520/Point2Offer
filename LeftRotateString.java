package ween_2;

/**
 * ��ָoffer: ����ת�ַ���:ǰ�������ַ��Ƶ�β��
 * ����:��ǰ�淴ת�ķ�������,�ֳ�������,�Ⱦֲ���ת�����巭ת(��ת��ת��Ϊ��ת)
 * ��������:���ܲ���(�ж������,1������)
 * �����������(��ָ��,�ַ���Ϊ��,�ַ���ֻ�пո�)
 * @author dingding
 * Date:2017-6-21 9:00
 * Declaration: All Rights Reserved!
 */
public class LeftRotateString {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	//��ת
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
	
	//����ת
	private static char[] leftRotate(char[] str,int n){
		if (str==null || n<0 || n>str.length) {
			return str;
		}
		reverse(str, 0, n-1);
		reverse(str, n, str.length-1);;
		reverse(str, 0, str.length-1);
		
		return str;
	}
	
	/*====================��������===================*/
	private static void test1() {
		System.out.println(new String(leftRotate("abcdefg".toCharArray(), 2)));
	}

	private static void test2() {
		System.out.println(new String(leftRotate("abcdefg".toCharArray(), 1)));
	}

}
