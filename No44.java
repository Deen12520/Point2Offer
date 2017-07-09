package week_4;

/**�Ѷ�ϵ��:***
 * ��ָoffer: �˿��Ƶ�˳��
 * ����: ����,�����С���ĸ���,ע���ж���,�϶�����˳��
 * ��������:���ܲ���(��������˳��,������˳��,ȫ�������ĸ���,���ж���,����˳��,��������˳��,������)
 * @author dingding
 * Date:2017-7-7 20:10
 * Declaration: All Rights Reserved!
 */
public class No44 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}
	//solution
	private static boolean isContinuous(int[] numbers){
		if (numbers == null || numbers.length < 1) {
			return false;
		}
		//����
		hashSort(numbers);
		int numberOf0 = 0;
		int numberOfGap = 0;
		
		//ͳ��������0�ĸ���
		for (int i=0;i<numbers.length;i++){
			if (numbers[i] == 0) {
				numberOf0++;
			}
		}
		
		//ͳ�������м���ĸ���
		int small = numberOf0;
		for (int j=0;j<numbers.length;j++){
			if (j<4 && numbers[j]!=0 && numbers[j] == numbers[j+1]) {
				return false;
			}
			if (j<4 && numbers[j+1]-numbers[j] !=0 && numbers[j+1]-numbers[j] !=1 && numbers[j]!=0) {
				numberOfGap +=numbers[j+1] -numbers[j]-1;
			}
		}
		return (numberOfGap>numberOf0) ? false :true;
	}
	
	//���������ռ��������
	private static void hashSort(int[] numbers) {
		if (numbers == null || numbers.length < 1) {
			return;
		}
		int maxNumber = 13;
		int[] timesOfNumber = new int[maxNumber+1];
		
		for (int i=0;i<=maxNumber;++i)  //�����ƶ��г���
			timesOfNumber[i] = 0;
		for (int j=0;j<numbers.length;++j){ //��������
			int number = numbers[j];
			if (number<0 || number>13) {
				break;
			}
			++ timesOfNumber[number];
		}
		int index = 0;
		for (int i=0;i<=maxNumber;++i){
			for (int j=0;j<timesOfNumber[i];++j){
				numbers[index] = i;
				index ++;
			}
		}
	}
	/*=================��������====================*/
	private static void test1() {
		int[] a ={1,3,0,4,5};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}
	}

	private static void test2() {
		int[] a ={2,3,1,4,5};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}		
	}

	private static void test3() {
		int[] a ={0,0,7,0,0};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}		
	}

	private static void test4() {
		int[] a ={0,0,0,0,0};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}	
	}

	private static void test5() {
		int[] a ={0,1,3,0,6};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}			
	}

	private static void test6() {
		int[] a ={0,1,6,0,1};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}			
	}

	private static void test7() {
		int[] a ={};
		if(isContinuous(a)){
			System.out.println("YES!");
		}else {
			System.out.println("No!");
		}	
	}

}
