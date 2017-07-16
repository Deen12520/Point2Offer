package week_5;

/**�Ѷ�ϵ��:***
 * ��ָoffer: �����������ĺ����������
 * ����: ��Ϥ�����������ĸ���,���������н��С�ڸ��ڵ�,���������н�㶼���ڸ��ڵ�,�����������Ƕ���������,��ֵ�������
 * ��������:
 * @author dingding
 * Date:2017-7-11 21:40
 * Declaration: All Rights Reserved!
 */
public class No24 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	
	//solution
	public static boolean verifyArrayIsBST(int[] sequence) {
        // ��������鲻��Ϊ�գ�����������
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        // �����ݣ��͵��ø�������
        return verifyArrayIsBST(sequence, 0, sequence.length - 1);
    }
	
	private static boolean verifyArrayIsBST(int[] sequence,int start,int end){
		if (start >= end) {
			return true;
		}
		
		// ���������ҵ�һ�������ڸ���㣨sequence[end]����Ԫ�ص�λ��
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }
        
		//�����������Ľ����ڸ��ڵ�
		int right = index;
	    while (right < end - 1 && sequence[right] > sequence[end]) {
	    	right++;
        }
		
	    if (right != end - 1) {
            return false;
        }
	    
		//�ݹ�,�ж����������ǲ���BST
	    return verifyArrayIsBST(sequence, start, index - 1) && verifyArrayIsBST(sequence, index, end - 1);
	}

	/*=======================��������===============*/
	private static void test1() {
		int[] sequence = {5,7,6,9,11,10,8};
		boolean result = verifyArrayIsBST(sequence);
		if (result) {
			System.out.println("YES!");
		}else {
			System.out.println("NO!");
		}
	}

	private static void test2() {
		int[] sequence = {7,4,6,5};
		boolean result = verifyArrayIsBST(sequence);
		if (result) {
			System.out.println("YES!");
		}else {
			System.out.println("NO!");
		}
	}

	private static void test3() {
		int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifyArrayIsBST(data2));
	}

}

