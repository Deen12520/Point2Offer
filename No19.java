package week_4;
/**难度系数:***
 * 剑指offer: 树的镜像
 * 方法:前序遍历,交换左右子树
 * 测试用例:功能测试(正常树/树为空/单节点/只有左子树或右子树)
 * @author dingding
 * Date:2017-7-3 10:35
 * Declaration: All Rights Reserved!
 */
public class No19 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	//solution,前序遍历
	private static void MirrorRecursively(BinaryTreeNode root){
		//递归结束条件
		if (root == null) {
			return;
		}
		//到叶子节点
		if (root.left == null && root.right == null) {
			return;
		}
		
		//交换左右子树
		BinaryTreeNode pTemp = root.left;
		root.left = root.right;
		root.right = pTemp;
		if (root.left!=null) {
			MirrorRecursively(root.left);
		}
		
		if (root.right!=null) {
			MirrorRecursively(root.right);
		}
	}

	//中序遍历打印二叉树
	private static void printTree(BinaryTreeNode root){
		if (root!=null){
			printTree(root.left);
			System.out.print(root.value + " ");
			printTree(root.right);
		}
	}
	/*==================测试用例================*/
	//普通二叉树
	private static void test1() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.right = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(7);
		root.right.left = new BinaryTreeNode(9);
		root.right.right = new BinaryTreeNode(11);
		
		MirrorRecursively(root);
		printTree(root);
		System.out.println();
	}

	//只有左子树
	private static void test2() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.left.left = new BinaryTreeNode(5);
		
		MirrorRecursively(root);
		printTree(root);
		System.out.println();
	}

	//只有一个节点
	private static void test3() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		
		MirrorRecursively(root);
		printTree(root);
		System.out.println();
	}

	//空树
	private static void test4() {
		MirrorRecursively(null);
		printTree(null);
	}

}
