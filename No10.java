package ween_2;
/**�Ѷ�ϵ��:**
 * ��ָoffer: ��������1�ĸ���
 * ����:λ����
 * ��������:���ܲ���(����{121,1,0x7FFFFFFF},����(0x80000000,0xffffffff))
 * �����������(0)
 * @author dingding
 * Date:2017-6-22 12:30
 * Declaration: All Rights Reserved!
 */
public class No10 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//solution,������������
//	private static int numberOf1(int n){
//		int count = 0;
//		int flag = 1;
//		while (flag!=0){
//			if ((n & flag)!=0) {
//				count++;
//			}
//			flag = flag<<1;    //��ͷָ��:���Ƴ�2,���Ƴ���2
//		}
//		return count;
//	}
	//���Žⷨ,�ж��ٸ�1��ѭ������
	private static int numberOf1(int n){
		int count = 0;
		while (n!=0){
			++count;
			n = (n-1)&n;
		}
		return count;
	}
	/*====================��������======================*/
	private static void test1() {
		int result = numberOf1(9);
		System.out.println("���Ϊ: "+result);
		System.out.println("========================");
	}

	private static void test2() {
		int result = numberOf1(1);
		System.out.println("���Ϊ: "+result);
		System.out.println("========================");
	}

	private static void test3() {
		int result = numberOf1(0x7FFFFFFF);
		System.out.println("���Ϊ: "+result);
		System.out.println("========================");		
	}

	private static void test4() {
		int result = numberOf1(0x80000000);
		System.out.println("���Ϊ: "+result);
		System.out.println("========================");			
	}

	private static void test5() {
		int result = numberOf1(0xFFFFFFFF);
		System.out.println("���Ϊ: "+result);
		System.out.println("========================");				
	}

	private static void test6() {
		int result = numberOf1(0);
		System.out.println("���Ϊ: "+result);
		System.out.println("========================");		
	}
}
