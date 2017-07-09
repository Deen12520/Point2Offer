package week_4;

/**难度系数:***
 * 剑指offer: 二叉树的深度/延伸:判断是否是平衡二叉树
 * 方法:遍历
 * 测试用例:功能测试(正常树/树为空/单节点/只有左子树或右子树)
 * @author dingding
 * Date:2017-7-3 14:05
 * Declaration: All Rights Reserved!
 */
public class No39 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	//solution
	private static int treeDepth(BinaryTreeNode root){
		if (root == null) {
			return 0;
		}
		
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		return (left > right) ?(left+1):(right+1);
	}
	
	//判断是否是平衡二叉树
	private static boolean isBalanced(BinaryTreeNode root){
		int[] depth = new int[1];
		return isBalancedHandle(root, depth);
	}
	private static boolean isBalancedHandle(BinaryTreeNode root, int[] depth){
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		int[] left = new int[1];
        int[] right = new int[1];
		if (isBalancedHandle(root.left, left) && isBalancedHandle(root.right, right)) {
			int diff = left[0] - right[0];
			if (diff <= 1 && diff >= -1) {
				depth[0] = 1 +(left[0]>right[0] ? left[0]:right[0]);
				return true;
			}
		}
		return false;

	}
	
	/*=========================测试用例=================*/
	private static void test1() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.right = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(7);
		root.right.left = new BinaryTreeNode(9);
		root.right.right = new BinaryTreeNode(11);
		
		int result = treeDepth(root);
		System.out.println(result);
		System.out.println(isBalanced(root));
	}

	private static void test2() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		
		int result = treeDepth(root);
		System.out.println(result);
		System.out.println(isBalanced(root));
	}

	private static void test3() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.left.left = new BinaryTreeNode(5);
		
		int result = treeDepth(root);
		System.out.println(result);
		System.out.println(isBalanced(root));
	}

	private static void test4() {
		int result = treeDepth(null);
		System.out.println(result);
		System.out.println();			
	}
}
