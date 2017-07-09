package week_4;

import java.util.LinkedList;
import java.util.Queue;

/**难度系数:***
 * 剑指offer: 从上到下打印二叉树
 * 方法:BFS
 * 测试用例:功能测试(正常树/树为空/单节点/只有左子树或右子树)
 * @author dingding
 * Date:2017-7-4 9:12
 * Declaration: All Rights Reserved!
 */
public class No23 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	//广度优先搜索
	private static void printFromTopToBottom(BinaryTreeNode root){
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();  //用队列来存储,linkedlist 保持其有序
		if (root == null) {
			System.out.println("Invalid input.");
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()){   //判断队列为空用isempty()
			BinaryTreeNode node = (BinaryTreeNode)queue.remove();
			System.out.print(" "+node.value);
			if (node.left!=null){
				queue.add(node.left);
			}
			if (node.right != null){
				queue.add(node.right);
			}
		}
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
		
		printFromTopToBottom(root);
		System.out.println();
	}

	private static void test2() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		
		printFromTopToBottom(root);
		System.out.println();		
	}

	private static void test3() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.left.left = new BinaryTreeNode(5);
		
		printFromTopToBottom(root);
		System.out.println();		
	}

	private static void test4() {
		printFromTopToBottom(null);
		System.out.println();			
	}

}
