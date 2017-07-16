package week_5;

/**�Ѷ�ϵ��:****
 * ��ָoffer: ����
 * ����: 
 * ��������: 
 * @author dingding
 * Date:2017-7-15 21:40
 * Declaration: All Rights Reserved!
 */
public class No34 {

	public static void main(String[] args) {
		test();
	}

	//����1: ���淽��,��ÿ���������м���
	private static int getUglyNumber(int index) {
		if (index <=0 ) {
			return 0;
		}
		int number = 0;
		int uglyFoundCount = 0;
		while (uglyFoundCount <index) {
			++ number;
			if (isUgly(number)) {
				++uglyFoundCount;
			}
		}
		return number;
	}
	
	//�ж��Ƿ��ǳ���
	private static boolean isUgly(int number) {
		while (number % 2 == 0){
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return (number==1) ? true:false;
	}

	// ����2: ֻ�����ǳ���,���ɲ���,�������
	private static int getUglyNumber_Solution(int index){
		if (index <= 0) {
			return 0;
		}
		
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyNumber = 1;
		
		int pMultiply2Index = 0;
		int pMultiply3Index = 0;
		int pMultiply5Index = 0;
		
		while (nextUglyNumber < index ){
			int min = Min(uglyNumbers[pMultiply2Index]*2,uglyNumbers[pMultiply3Index]*3,uglyNumbers[pMultiply5Index]*5);
			uglyNumbers[nextUglyNumber] = min;
			
			while (uglyNumbers[pMultiply2Index]*2 <= uglyNumbers[nextUglyNumber]){
				++pMultiply2Index;
			}
			while (uglyNumbers[pMultiply3Index]*3 <= uglyNumbers[nextUglyNumber]){
				++pMultiply3Index;
			}
			while (uglyNumbers[pMultiply5Index]*5 <= uglyNumbers[nextUglyNumber]){
				++pMultiply5Index;
			}
			++nextUglyNumber;
		}
		
		int uglyNumber = uglyNumbers[nextUglyNumber-1];
		return uglyNumber;
	}
	
	
	private static int Min(int i, int j, int k) {
		int min = (i<j)?i:j;
		min = (min<k)?min:k;
		return min;
	}

	/*====================��������===============*/
	private static void test() {
		System.out.println("����1: ");
		int result1 = getUglyNumber(150);
		System.out.println(result1);
		
		System.out.println("����2: ");
		int result2 = getUglyNumber_Solution(1500);
		System.out.println(result2);
	}

}
