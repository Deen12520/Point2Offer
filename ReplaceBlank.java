package com;
/**
 * ��ָoffer: �滻�ַ����е�ÿ���ո�Ϊ02%
 * ����:1.replaceAll;2.�ƶ��ַ���;3.ʹ������ָ��;
 * ��������:���ܲ���(�ַ����пո�,�ַ���û�пո�(�ո�λ�ö��ֿ���))
 * �����������(�ַ���Ϊ��,�ַ����ж�������Ŀո�,1���ո�)
 * @author dingding
 * Date:2017-6-16 18:00
 * Declaration: All Rights Reserved!
 */
public class ReplaceBlank {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	//����1:�滻,ʹ�����ú���
	private static String replace_1(String str){
		str = str.replaceAll(" ", "%20");
		return str;
	}
	
	//����2: ʹ������ָ��
	private static char[] replace_2(char[] string){
		if (string==null) {
			return null;
		}
		
		int originLength = 0;  //�ַ���ʵ�ʳ���
		int numberOfBlank = 0; //�ַ����пո����Ŀ
		for (int i=0;i<string.length;i++){
			originLength++;
			if (string[i]==' ') {  //" "��ʾ�ַ���
				numberOfBlank++;
			}
		}
		
		int newLength = originLength+numberOfBlank*2;
		int indexOfOriginal = originLength-1;
		int indexOfNew = newLength-1;
		char[] newStr = new char[newLength];
		//ѭ����������(�ܹؼ�)
		while (indexOfOriginal>=0){
			if (string[indexOfOriginal] ==' ') {
				newStr[indexOfNew--]='0';
				newStr[indexOfNew--]='2';
				newStr[indexOfNew--]='%';
			}else {
				newStr[indexOfNew--]=string[indexOfOriginal];
			}
			indexOfOriginal--;
		}
		return newStr;
	}
	
	/*===================��������=================*/
	private static void test(String str){
		System.out.println("�滻ǰ : ");
		System.out.println(str);
//		System.out.println(str.length());
		System.out.println("����1�滻��  : ");
		String rString1 = replace_1(str);
		System.out.println(rString1);
		System.out.println("����2�滻��  : ");
		char[] cStr=replace_2(str.toCharArray());
		System.out.println(cStr);
		System.out.println("=====================");
	}
	
	//�пո�,������
	private static void test1() {
		String str = " I am a hero.";
		test(str);
	}
	
	//�������ո�
	private static void test2() {
		String str = "I  am a hero. ";
		test(str);
	}
	//���ַ���
	private static void test3() {
		String str = "";
		test(str);
	}
	//û�пո�
	private static void test4() {
		String str = "dddddd";
		test(str);
	}
	//ȫ�ǿո�
	private static void test5() {
		String str = "    ";
		test(str);
	}
}
