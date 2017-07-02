package week_3;
/**�Ѷ�ϵ��:***
 * ��ָoffer: ������ֻ����һ�ε�����
 * ����:�������,���������(�������֮��ĵ�һ��1)
 * ��������:���ܲ���(�����д��ڶ���ظ�����,������û���ظ�������)
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
		int number1 = 0;  //��һ������һ�ε�����
		int number2 = 0;
		for (int j=0;j<length;j++){
			if (isBit1(data[j],indexOf1)) {
				number1 ^=data[j];
			}else {
				number2 ^=data[j];
			}
		}
		System.out.println("��������Ϊ: "+number1+","+number2);
	}
	
	//���������е�nλҲΪ1������,indexof1 ���ص���1���±�,�ʲ��ü�1
	private static boolean isBit1(int num, int indexOf1) {
		boolean flag = false;
		num = num >>indexOf1;
		if ((num & 1) == 1) {
			flag = true;
		}
		return flag;
	}
	//�ҵ�������������һ��1
	private static int findFirstBitIs1(int resultExclusiveOR) {
		int indexBit = 0;
		while ((resultExclusiveOR & 1)==0){
			resultExclusiveOR = resultExclusiveOR >> 1;
			++ indexBit;
		}
		return indexBit;
	}
	/*=====================��������=================*/
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
