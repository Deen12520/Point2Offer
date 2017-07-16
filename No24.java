package week_5;

/**难度系数:***
 * 剑指offer: 二叉搜索树的后序遍历序列
 * 方法: 熟悉二叉搜索树的概念,左子树所有结点小于根节点,右子树所有结点都大于根节点,左右子树仍是二叉搜索树,键值都不相等
 * 测试用例:
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
        // 输入的数组不能为空，并且有数据
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        // 有数据，就调用辅助方法
        return verifyArrayIsBST(sequence, 0, sequence.length - 1);
    }
	
	private static boolean verifyArrayIsBST(int[] sequence,int start,int end){
		if (start >= end) {
			return true;
		}
		
		// 从左向右找第一个不大于根结点（sequence[end]）的元素的位置
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }
        
		//搜索右子树的结点大于根节点
		int right = index;
	    while (right < end - 1 && sequence[right] > sequence[end]) {
	    	right++;
        }
		
	    if (right != end - 1) {
            return false;
        }
	    
		//递归,判断左右子树是不是BST
	    return verifyArrayIsBST(sequence, start, index - 1) && verifyArrayIsBST(sequence, index, end - 1);
	}

	/*=======================测试用例===============*/
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

