package week_4;
/**�Ѷ�ϵ��:***
 * ��ָoffer: �������ų���С����
 * ����: ����תΪ�ַ���,Ȼ������ַ����Ƚϴ�С,��������
 * ��������:
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

	//solution,����תΪ�ַ���,Ȼ������ַ����Ƚϴ�С,��������
	private static void genMinNumber(int[] numbers){
		if (numbers == null || numbers.length<=0) {
			return;
		}
		
		String[] strNumbers = new String[numbers.length];   //�ַ�������
		for (int i=0;i<numbers.length;++i){
			strNumbers[i] = String.valueOf(numbers[i]);
		}
		
		//�ַ��������������,����ð�ݷ�
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
		int numberOf0 = 0; //��¼0�ĸ���
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
	
	//�Ƚ����ַ���������
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

	/*==================��������===============*/
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
