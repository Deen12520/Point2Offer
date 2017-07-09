package week_4;

import java.util.Stack;

/**难度系数:****
 * 剑指offer: 按之字形顺序打印二叉树
 * 方法:
 * 测试用例:功能测试(正常树/树为空/单节点/只有左子树或右子树)
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
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();  //存储奇数行,右到左;
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();   //存储偶数行,左到右;
		
		int current = 0;  //判断当前是奇数行还是偶数行,0是偶数,1是奇数
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
	/*====================测试用例=================*/
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
