package week_5;

import java.util.ArrayList;

/**难度系数:***
 * 剑指offer: 二叉树中和为某一个值的路径
 * 方法: 熟悉二叉搜索树的概念,左子树所有结点小于根节点,右子树所有结点都大于根节点,左右子树仍是二叉搜索树,键值都不相等
 * 测试用例: 递归
 * @author dingding
 * Date:2017-7-11 21:40
 * Declaration: All Rights Reserved!
 */
public class No25 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	//solution
	private static void findPath(BinaryTreeNode root,int expectedSum){
		if (root == null) {
			return;
		}
		ArrayList<Integer> paths = new ArrayList<>(); //存储路径
		int currentSum = 0;
		findPath(root, expectedSum,paths,currentSum);
	}
	
	private static void findPath(BinaryTreeNode root,int expectedSum,
			ArrayList<Integer> paths,int currentSum){
		currentSum +=root.value;
		paths.add(root.value);
		
		boolean isLeaf = (root.left == null && root.right == null);
		if (currentSum == expectedSum && isLeaf) {
			System.out.println("A path is found: ");
			for (int path:paths){
				System.out.print(" "+path);
			}
			System.out.println();
		}
		
		//如果不是叶子结点
		if (root.left != null) {
			findPath(root.left, expectedSum, paths, currentSum);
		}
		if (root.right != null) {
			findPath(root.right, expectedSum, paths, currentSum);
		}
		
		//若当前已是叶子结点,移除当前节点
		paths.remove(paths.size()-1);
	}
	/*====================测试用例================*/
	private static void test1() {
		BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(12);
        
        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);
        System.out.println();
        
        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);
        System.out.println();

        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);
        System.out.println();
	}

	private static void test2() {
		BinaryTreeNode root3 = new BinaryTreeNode(1);
        root3.right = new BinaryTreeNode(2);
        root3.right.right = new BinaryTreeNode(3);
        root3.right.right.right = new BinaryTreeNode(4);
        root3.right.right.right.right = new BinaryTreeNode(5);

        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);
        System.out.println();

        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);
        System.out.println();
		
	}

	private static void test3() {
		 // 树中没有结点
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
	}

}

class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
