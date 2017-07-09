package week_4;

import java.util.Stack;

/**�Ѷ�ϵ��:****
 * ��ָoffer: ��֮����˳���ӡ������
 * ����:
 * ��������:���ܲ���(������/��Ϊ��/���ڵ�/ֻ����������������)
 * @author dingding
 * Date:2017-7-4 9:50
 * Declaration: All Rights Reserved!
 */
public class No61 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	//solution
	private static void printTreeAsReversedS(BinaryTreeNode root){
		if (root == null) {
			System.out.println("Invalid input.");
			return;
		}
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();  //�洢������,�ҵ���;
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();   //�洢ż����,����;
		
		int current = 0;  //�жϵ�ǰ�������л���ż����,0��ż��,1������
		BinaryTreeNode node = null;
		
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()){
			if (current == 0 && !stack1.isEmpty()) {
			    node = stack1.pop();
			}else if (current == 1 && !stack2.isEmpty()){
				node = stack2.pop();
			}
				
			System.out.print(" "+node.value);
			
			if (current == 0) {
				if (node.left != null) {
					stack2.push(node.left);
				}
				if (node.right != null) {
					stack2.push(node.right);
				}
			}else {
				if (node.right != null) {
					stack1.push(node.right);
				}
				if (node.left != null) {
					stack1.push(node.left);
				}
			}
			
			if (stack1.isEmpty()) {
				current = 1 - current;
			}
			if (stack2.isEmpty()) {
				current = 1 - current;
			}
			
		}
	}
	/*====================��������=================*/
	private static void test1() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.right = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(7);
		root.right.left = new BinaryTreeNode(9);
		root.right.right = new BinaryTreeNode(11);

		
		printTreeAsReversedS(root);
		System.out.println();
	}

	private static void test2() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.left.left = new BinaryTreeNode(5);
		root.left.left.left = new BinaryTreeNode(13);
		
		printTreeAsReversedS(root);
		System.out.println();
	}

	private static void test3() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		printTreeAsReversedS(root);
		System.out.println();		
	}

	private static void test4() {
		printTreeAsReversedS(null);
		System.out.println();	
	}

}
