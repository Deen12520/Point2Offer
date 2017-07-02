package week_3;
/**难度系数:****
 * 剑指offer: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 方法:递归
 * 测试用例:功能测试(树的五种情况)
 * @author dingding
 * Date:2017-7-1 19:00
 * Declaration: All Rights Reserved!
 */
public class No6 {

	public static void main(String[] args) {
		test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();
	}
	
	//构造二叉树
	private static BinaryTreeNode construct(int[] preorder,int[] inorder){
		if (preorder == null || inorder == null || preorder.length!=inorder.length || inorder.length <1) {
			return null;
		}
		return constructCore(preorder, 0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	//核心代码
	private static BinaryTreeNode constructCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart>preEnd) {
			return null;
		}
		int value = preorder[preStart];
		int index = inStart;
		//在中序遍历的数组中找根节点的位置
		while (index <=inEnd && inorder[index]!=value){
			index++;
		}
		
		if (index >inEnd) {
			throw new RuntimeException("Invalid input.");
		}
		
		//创建当前的根节点,并且为节点赋值
		BinaryTreeNode node = new BinaryTreeNode(value);
		
		node.left = constructCore(preorder, preStart+1, preStart+index-inStart, inorder, inStart, index-1);
		node.right = constructCore(preorder, preStart+index-inStart+1, preEnd, inorder, index+1, inEnd);
		
		return node;
	}

	//重建后二叉树以前序遍历的方式输出
	private static void printTree(BinaryTreeNode root){
		if (root!=null) {
			System.out.print(root.value+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	/*====================测试用例=================*/
	private static void test1() {
		int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);		
	}

	private static void test2() {
		int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);		
	}

	private static void test3() {
		int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);		
	}

	private static void test4() {
		int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);		
	}

	private static void test5() {
		int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);		
	}

	private static void test6() {
		construct(null, null);		
	}

	private static void test7() {
		int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = construct(preorder, inorder);
        printTree(root);		
	}

}

//定义一个树
class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
    public BinaryTreeNode(int value) {
    	this.value = value;
    	this.left = null;
    	this.right = null;
    }
}