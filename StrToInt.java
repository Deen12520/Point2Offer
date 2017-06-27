package ween_2;
/**
 * ��ָoffer: �ַ���ת��Ϊ����.
 * ����:���Ƕ����������
 * ��������:���ܲ���(������ַ�����ʾ����,������0)
 * �߽�ֵ����(����������,��С�ĸ�����)
 * �����������(��ָ��,�ַ���Ϊ��,�ַ����к��з������ַ�)
 * @author dingding
 * Date:2017-6-19 20:00
 * Declaration: All Rights Reserved!
 */
public class StrToInt {
    private static boolean isValid = true;  //�ж������ַ����Ƿ���Ч�ı�־
	public static void main(String[] args) {
		test(null);
	    test("");
	    test("123");
	    test("+123");
	    test("-123");
	    test("1a33");
	    test("+0");
	    test("-0");
	    //��Ч�����������, 0x7FFFFFFF
	    test("+2147483647");    
	    test("-2147483647");
	    test("+2147483648");
	    //��Ч����С������, 0x80000000
	    test("-2147483648");    
	    test("+2147483649");
	    test("-2147483649");
	    test("+");
	    test("-");
	    test("-a");
	    //test("423443  ");  //����������ܴ���
	    test("423 443");
	}
	
	//�ַ�ת��Ϊ����
	private static int changeStrToInt(String string){
		isValid = true;  //�ж��Ƿ�����Ч����
		if (string == null || string.length()==0) {
			isValid = false;
			return 0;
		}
		
		int start = 0;    //�ӿ�ʼ�ҵ�һ�����ǿո����
		boolean positive = true;
		
		//�ҵ���һ���ǿ��ַ�
		if (string.charAt(start)==' ') {
			while (string.charAt(start)==' '){
				start++;
				if (start >=string.length()) {
					isValid = false;
					return 0;
				}
			}
		}
		
		//���д��봦����ǰ�����ǿ��ַ�,�����˺����ĵ���.
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
			result = result*10 + (string.charAt(start)-'0');  //����ת��Ϊ����
			
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

	/*==================��������====================*/
	private static void test(String string){
		int result = changeStrToInt(string);
		if (result == 0 && isValid==false) {
			System.out.println("The input "+string+" is invalid.");
		}else{
			System.out.println("Number for "+string+" is:"+result);
		}
	}
}
