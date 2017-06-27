package ween_2;

/**�Ѷ�ϵ��:***
 * ��ָoffer: ���������������г��ֵĴ���
 * ����:���ֲ���
 * ��������:���ܲ���(������,����1��,���,���ֵ,��Сֵ)
 * �����������(����Ϊ��,������ֻ��һ������)
 * @author dingding
 * Date:2017-6-27 20:00
 * Declaration: All Rights Reserved!
 */
public class No38 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}
	
	//���ص�һ��k���±�
	private static int getFirstK(int[] array,int length,int k,int start,int end){
		if (start>end) {
			return -1;
		}
		int middleIndex = (start+end)/2;
		int middleData = array[middleIndex];
		if (middleData == k) {
			if ((middleIndex > 0 && array[middleIndex-1]!=k) || middleIndex==0) {
				return middleIndex;
			}else {
				end = middleIndex-1;
			}
		}else if (middleData>k) {
			end = middleIndex - 1;
		}else {
			start = middleIndex + 1;
		}
		
		return getFirstK(array, length, k, start, end);
	}
	
	//�������һ��k���±�
	private static int getLastK(int[] array,int length,int k,int start,int end){
		if (start>end) {
			return -1;
		}
		int middleIndex = (start+end)/2;
		int middleData = array[middleIndex];
		if (middleData==k) {
			if ((middleIndex<length-1 && array[middleIndex+1]!=k) || middleIndex==length-1) {
				return middleIndex;
			}else {
				start = middleIndex+1;
			}
		}else if(middleData<k){
			start = middleIndex + 1;
		}else {
			end = middleIndex - 1;
		}
		
		return getLastK(array, length, k, start, end);
	}

	//������ֵĴ���
	private static int getNumberOfK(int[] array,int length,int k){
		int number = 0;
		if (array == null || length<1) {
			return -1;
		}
		if (array != null && length>0) {
			int first = getFirstK(array, length, k, 0, length-1);
			int last = getLastK(array, length, k, 0, length-1);
			
			if (first>-1 && last > -1) {
				number = last - first +1;
			}
		}
		
		return number;
	}
	/*==================��������================*/
	private static void test(int[] array,int length,int k){
		int result = getNumberOfK(array, length, k);
		if (result != -1) {
			System.out.println(k+"���ֵĴ���Ϊ: "+ result);
		}else{
			System.out.println("������Ч����!");
		}
		
		System.out.println("====================");
	}
	private static void test1() {
		int[] array = {1,2,3,4,5,5,6};
		int k=7;
		test(array, array.length, k);
	}

	private static void test2() {
		int[] array = {1,2,3,4,5,5,6};
		int k=3;
		test(array, array.length, k);
	}

	private static void test3() {
		int[] array = {1,2,3,4,5,5,6};
		int k=5;
		test(array, array.length, k);
	}

	private static void test4() {
		int[] array = {1,2,3,4,5,5,6};
		int k=6;
		test(array, array.length, k);
	}

	private static void test5() {
		int[] array = {1,2,3,4,5,5,6};
		int k=1;
		test(array, array.length, k);		
	}

	private static void test6() {
		int[] array = {1};
		int k=1;
		test(array, array.length, k);		
	}

	private static void test7() {
		int[] array = {};
		int k=6;
		test(array, array.length, k);
	}

}
