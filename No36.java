package ween_2;

/**难度系数:****
 * 剑指offer: 数组中的逆序对
 * 方法:归并排序思想
 * 测试用例:功能测试(123456,135246,654321,52135,31,1)
 * 特殊输入测试(数组为空)
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

	//逆序对
	private static int inversePairs(int[] arr,int length){
		if (arr == null || arr.length<1) {
			return 0;
		}            
		
		int[] copy = new int[length];    //辅助数组
		for (int i=0;i<length;i++){
			copy[i]=arr[i];
		}
		
		int count = inversePairsCore(arr,copy,0,length-1);   //计算逆序对
		return count;
	}
	
	private static int inversePairsCore(int[] arr, int[] copy, int start, int end) {
		//递归结束条件
		if (start == end) {
			//copy[start] = arr[start];  //分解成单元素后的处理
			return 0;
		}
		int length = (end - start)/2;
		int left = inversePairsCore(copy, arr, start, start+length);  //会一直执行到完成 (排序,注意参数1和2是反的)
		int right = inversePairsCore(copy, arr,start+length+1, end);
		
		/*合并,排序,并统计逆序对*/
		//i初始化为前半段最后一个数字的坐标
		int i = start+length;
		//j初始化为后半段最后一个数字的坐标
		int j = end;
		int indexCopy = end;  //辅助数组的指针位置
		int count = 0;
		//可把i,j看出是两个指针
		while (i >= start && j>=start+length+1){
			if (arr[i]>arr[j]) {
				copy[indexCopy--]=arr[i--];
				count += j-start-length;
			}else {
				copy[indexCopy--]=arr[j--];
			}
		}
		
		//右半边用尽,取左半边元素
		for (;i>=start;i--){
			copy[indexCopy--]=arr[i];
		}
		//左半边用尽,取右半边元素
		for (;j>=start+length+1;j--){
			copy[indexCopy--]=arr[j];
		}
		
		return left+right+count;
	}

	/*==================测试用例==============*/
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
