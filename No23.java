package week_4;

import java.util.LinkedList;
import java.util.Queue;

/**�Ѷ�ϵ��:***
 * ��ָoffer: ���ϵ��´�ӡ������
 * ����:BFS
 * ��������:���ܲ���(������/��Ϊ��/���ڵ�/ֻ����������������)
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

	//�����������
	private static void printFromTopToBottom(BinaryTreeNode root){
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();  //�ö������洢,linkedlist ����������
		if (root == null) {
			System.out.println("Invalid input.");
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()){   //�ж϶���Ϊ����isempty()
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
	/*=========================��������=================*/
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
