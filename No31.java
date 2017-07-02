package week_3;
/**�Ѷ�ϵ��:***
 * ��ָoffer: ���������������
 * ����:���õ�ǰ�ۼ�����������ֵor��̬�滮(δʵ��)
 * ��������:���ܲ���(ȫ������,ȫ��,�����и�,Ϊ��)
 * @author dingding
 * Date:2017-6-28 10:45
 * Declaration: All Rights Reserved!
 */
public class No31 {
	private static boolean isvalid = true;  //�Ƿ���Ч
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	private static int findMaxSumOfSubArray(int[] data,int length){
		if (data == null || length<1) {
			isvalid = false;
			return 0;
		}
		isvalid = true;  //�Ա���һ�ε���
		int addToNSum = 0;
		int nMaxSum = 0x80000000; //��С��
		for (int i=0;i<length;i++){
			if (addToNSum<=0) {    //��һ��������
				addToNSum = data[i];
			}else{
				addToNSum +=data[i];
			}
			
			if (addToNSum > nMaxSum) {
				nMaxSum = addToNSum;
			}
		}
		return nMaxSum;
	}
	
	/*====================��������=================*/
	private static void test(int[] data,int length){
		int result = findMaxSumOfSubArray(data, length);
		if (!isvalid && result == 0) {
			System.out.println("invalid input.");
		}else {
			System.out.println("��������������Ϊ: "+result);
		}
	}
	private static void test1() {
		int[] data = {1,-2,3,10,-4,7,2,-5};
		test(data, data.length);
	}

	private static void test2() {
		int[] data = {1,2,3,4,5};
		test(data, data.length);		
	}
	private static void test3() {
		int[] data = {-1,-4,-3,-5};
		test(data, data.length);		
	}

	private static void test4() {
		int[] data = {};
		test(data, data.length);		
	}
}
