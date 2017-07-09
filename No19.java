package week_4;
/**�Ѷ�ϵ��:***
 * ��ָoffer: ���ľ���
 * ����:ǰ�����,������������
 * ��������:���ܲ���(������/��Ϊ��/���ڵ�/ֻ����������������)
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
	//solution,ǰ�����
	private static void MirrorRecursively(BinaryTreeNode root){
		//�ݹ��������
		if (root == null) {
			return;
		}
		//��Ҷ�ӽڵ�
		if (root.left == null && root.right == null) {
			return;
		}
		
		//������������
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

	//���������ӡ������
	private static void printTree(BinaryTreeNode root){
		if (root!=null){
			printTree(root.left);
			System.out.print(root.value + " ");
			printTree(root.right);
		}
	}
	/*==================��������================*/
	//��ͨ������
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

	//ֻ��������
	private static void test2() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.left.left = new BinaryTreeNode(5);
		
		MirrorRecursively(root);
		printTree(root);
		System.out.println();
	}

	//ֻ��һ���ڵ�
	private static void test3() {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		
		MirrorRecursively(root);
		printTree(root);
		System.out.println();
	}

	//����
	private static void test4() {
		MirrorRecursively(null);
		printTree(null);
	}

}
