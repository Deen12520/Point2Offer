package week_4;

/**�Ѷ�ϵ��:***
 * ��ָoffer: �����ӽṹ
 * ����:�ݹ�,��һ���ж��ҵ����ڵ�һ���Ľڵ�,�ڶ����Ƚ����������ṹ�Ƿ���ͬ,�ݹ���ֹ��������
 * A��B��Ҷ�ڵ�
 * ��������:���ܲ���(���ӽṹ/�����ӽṹ/����һ����Ϊ��/���ڵ�)
 * @author dingding
 * Date:2017-7-3 9:35
 * Declaration: All Rights Reserved!
 */
public class No18 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	//solution,��һ��,�ҵ����ڵ�ֵ��ͬ�Ľڵ�
	private static boolean hasSubtree(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2){
		boolean result = false;
		
		if (pRoot1 != null && pRoot2 != null) {
			if (pRoot1.value == pRoot2.value) {
				result = doesTree1HaveTree2(pRoot1,pRoot2);
			}
			if (!result) {
				result = hasSubtree(pRoot1.left, pRoot2);
			}
			if (!result) {
				result = hasSubtree(pRoot1.right, pRoot2);
			}
		}
		return result;
	}

	//�Ƚ����������Ľṹ�Ƿ���ͬ
	private static boolean doesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
		if (pRoot2 == null) {
			return true;
		}
		
		if (pRoot1 == null) {
			return false;
		}
		
		//�ڲ��ݹ��������֮һ
		if (pRoot1.value != pRoot2.value) {
			return false;
		}
		
		return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
	}
	/*==================��������================*/
	//��������,B��A���ӽṹ
	private static void test1() {
		BinaryTreeNode root1 = new BinaryTreeNode(8);
		root1.left = new BinaryTreeNode(8);
		root1.right = new BinaryTreeNode(7);
		root1.left.left = new BinaryTreeNode(9);
		root1.left.right = new BinaryTreeNode(2);
		root1.left.right.left = new BinaryTreeNode(4);
		root1.left.right.right = new BinaryTreeNode(7);
		
		BinaryTreeNode root2 = new BinaryTreeNode(8);
		root2.left = new BinaryTreeNode(9);
		root2.right = new BinaryTreeNode(2);
		
		boolean result = hasSubtree(root1, root2);
		if (result) {
			System.out.println("Yes.");
		}else {
			System.out.println("No.");
		}
	}
	
	//B����A���ӽṹ
	private static void test2() {
		BinaryTreeNode root1 = new BinaryTreeNode(8);
		root1.left = new BinaryTreeNode(8);
		root1.right = new BinaryTreeNode(7);
		root1.left.left = new BinaryTreeNode(9);
		root1.left.right = new BinaryTreeNode(2);
		root1.left.right.left = new BinaryTreeNode(4);
		root1.left.right.right = new BinaryTreeNode(7);
		
		BinaryTreeNode root2 = new BinaryTreeNode(8);
		root2.left = new BinaryTreeNode(9);
		root2.right = new BinaryTreeNode(3);
		
		boolean result = hasSubtree(root1, root2);
		if (result) {
			System.out.println("Yes.");
		}else {
			System.out.println("No.");
		}
	}

	//A/Bֻ��һ���ڵ�
	private static void test3() {
		BinaryTreeNode root1 = new BinaryTreeNode(8);
		root1.left = new BinaryTreeNode(7);
		BinaryTreeNode root2 = new BinaryTreeNode(8);
		
		boolean result = hasSubtree(root1, root2);
		if (result) {
			System.out.println("Yes.");
		}else {
			System.out.println("No.");
		}
	}

	//BΪ��
	private static void test4() {
		BinaryTreeNode root1 = new BinaryTreeNode(8);
		
		boolean result = hasSubtree(root1, null);
		if (result) {
			System.out.println("Yes.");
		}else {
			System.out.println("No.");
		}		
	}
}

//����һ��������
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
