package week_5;

/**难度系数:****
 * 剑指offer: 最小的K个数
 * 方法: 快排思想/最大堆
 * 测试用例: (有无重复数字,K=1,K=length/K<1或K>length)
 * @author dingding
 * Date:2017-7-15 20:40
 * Declaration: All Rights Reserved!
 */
public class No30 {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//方法1: 快排思想,改变了数组结构
	public static void getLeastKNumbers(int[] numbers,int length,int K){
		if (numbers == null || length<=0 || K>length || K<=0 ||length<=0) {
			return;
		}
		
		int start = 0;
		int end = length-1;
		int index = partition(numbers,length,start,end);  //得到第一次分片后的位置
		while (index != K-1){
			if (index > K-1) {
				end = index-1;
				index = partition(numbers, length, start, end);
			}else {
				start = index + 1;
				index = partition(numbers, length, start, end);
			}
		}
		
		//打印出最小的K个数
		for (int i=0;i<K;++i){
			System.out.print(" "+numbers[i]);
		}
	}

	//快排分片
	private static int partition(int[] numbers, int length, int start, int end) {
		int x = numbers[end];
		int p = start - 1;
		for (int j=start;j<end;++j) {
			if (numbers[j]<=x) {
				++p;
				swap(numbers,j,p);
			}
		}
		swap(numbers,p+1, end);
		return p+1;
	}

	//交换两个数
	private static int[] swap(int[] a,int i, int j) {
		int temp;
		temp =a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return a;
	}
	
	// 方法2:TODO: 最大堆

	/*=====================测试用例==============*/
	private static void test1() {
		int[] numbers = {4,5,1,6,2,7,3,8};
		int K = 3;
		getLeastKNumbers(numbers, numbers.length, K);
		System.out.println();
	}

	private static void test2() {
		int[] numbers = {1,5,1,6,2,7,3,4};
		int K = 6;
		getLeastKNumbers(numbers, numbers.length, K);
		System.out.println();
	}

	private static void test3() {
		int[] numbers = {1,5,1,6,2,7,3,4};
		int K = 1;
		getLeastKNumbers(numbers, numbers.length, K);
		System.out.println();
	}

	private static void test4() {
		int[] numbers = {1,5,1,6,2,7,3,4};
		int K = 8;
		getLeastKNumbers(numbers, numbers.length, K);
		System.out.println();		
	}

	private static void test5() {
		int[] numbers = {};
		int K = 1;
		getLeastKNumbers(numbers, numbers.length, K);
		System.out.println();		
	}

	private static void test6() {
		int[] numbers = {1,5,1,6,2,7,3,4};
		int K = 0;
		getLeastKNumbers(numbers, numbers.length, K);
		System.out.println();
	}
	
}
