package week_4;

/**难度系数:***
 * 剑指offer: 树的子结构
 * 方法:递归,第一次判断找到根节点一样的节点,第二步比较左右子树结构是否相同,递归终止条件到达
 * A或B的叶节点
 * 测试用例:功能测试(是子结构/不是子结构/其中一棵树为空/单节点)
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
	//solution,第一步,找到根节点值相同的节点
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

	//比较左右子树的结构是否相同
	private static boolean doesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
		if (pRoot2 == null) {
			return true;
		}
		
		if (pRoot1 == null) {
			return false;
		}
		
		//内部递归结束条件之一
		if (pRoot1.value != pRoot2.value) {
			return false;
		}
		
		return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
	}
	/*==================测试用例================*/
	//正常子树,B是A的子结构
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
	
	//B不是A的子结构
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

	//A/B只有一个节点
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

	//B为空
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

//定义一个二叉树
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
