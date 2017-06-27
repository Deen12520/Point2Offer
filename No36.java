package ween_2;

/**�Ѷ�ϵ��:****
 * ��ָoffer: �����е������
 * ����:�鲢����˼��
 * ��������:���ܲ���(123456,135246,654321,52135,31,1)
 * �����������(����Ϊ��)
 * @author dingding
 * Date:2017-6-22 7:30
 * Declaration: All Rights Reserved!
 */
public class No36 {
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}

	//�����
	private static int inversePairs(int[] arr,int length){
		if (arr == null || arr.length<1) {
			return 0;
		}            
		
		int[] copy = new int[length];    //��������
		for (int i=0;i<length;i++){
			copy[i]=arr[i];
		}
		
		int count = inversePairsCore(arr,copy,0,length-1);   //���������
		return count;
	}
	
	private static int inversePairsCore(int[] arr, int[] copy, int start, int end) {
		//�ݹ��������
		if (start == end) {
			//copy[start] = arr[start];  //�ֽ�ɵ�Ԫ�غ�Ĵ���
			return 0;
		}
		int length = (end - start)/2;
		int left = inversePairsCore(copy, arr, start, start+length);  //��һֱִ�е���� (����,ע�����1��2�Ƿ���)
		int right = inversePairsCore(copy, arr,start+length+1, end);
		
		/*�ϲ�,����,��ͳ�������*/
		//i��ʼ��Ϊǰ������һ�����ֵ�����
		int i = start+length;
		//j��ʼ��Ϊ�������һ�����ֵ�����
		int j = end;
		int indexCopy = end;  //���������ָ��λ��
		int count = 0;
		//�ɰ�i,j����������ָ��
		while (i >= start && j>=start+length+1){
			if (arr[i]>arr[j]) {
				copy[indexCopy--]=arr[i--];
				count += j-start-length;
			}else {
				copy[indexCopy--]=arr[j--];
			}
		}
		
		//�Ұ���þ�,ȡ����Ԫ��
		for (;i>=start;i--){
			copy[indexCopy--]=arr[i];
		}
		//�����þ�,ȡ�Ұ��Ԫ��
		for (;j>=start+length+1;j--){
			copy[indexCopy--]=arr[j];
		}
		
		return left+right+count;
	}

	/*==================��������==============*/
	private static void test(int[] data,int length,int expected){
		if(inversePairs(data, length)== expected)
	        System.out.println("Passed.");
	    else
	    	System.out.println("Failed.");
	}
	private static void test1() {
		int[] data = {7,5,6,4};
	    int expected = 5;
		test(data, data.length, expected);
	}

	private static void test2() {
		int[] data = {6, 5, 4, 3, 2, 1};
	    int expected = 15;
	    test(data, data.length, expected);
	}

	private static void test3() {
		int[] data = {1, 2, 3, 4, 5, 6};
	    int expected = 0;
	    test(data, data.length, expected);
	}

	private static void test4() {
		int[] data = {1};
	    int expected = 0;	
	    test(data, data.length, expected);
	}

	private static void test5() {
		int[] data = {1, 2};
	    int expected = 0;	
	    test(data, data.length, expected);
	}

	private static void test6() {
		int[] data = {2, 1};
	    int expected = 1;	
	    test(data, data.length, expected);
	}

	private static void test7() {
		int[] data = {1, 2, 1, 2, 1};
	    int expected = 3;
	    test(data, data.length, expected);
	}

}
