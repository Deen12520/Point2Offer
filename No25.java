package week_5;

import java.util.ArrayList;

/**�Ѷ�ϵ��:***
 * ��ָoffer: �������к�Ϊĳһ��ֵ��·��
 * ����: ��Ϥ�����������ĸ���,���������н��С�ڸ��ڵ�,���������н�㶼���ڸ��ڵ�,�����������Ƕ���������,��ֵ�������
 * ��������: �ݹ�
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
		ArrayList<Integer> paths = new ArrayList<>(); //�洢·��
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
		
		//�������Ҷ�ӽ��
		if (root.left != null) {
			findPath(root.left, expectedSum, paths, currentSum);
		}
		if (root.right != null) {
			findPath(root.right, expectedSum, paths, currentSum);
		}
		
		//����ǰ����Ҷ�ӽ��,�Ƴ���ǰ�ڵ�
		paths.remove(paths.size()-1);
	}
	/*====================��������================*/
	private static void test1() {
		BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(12);
        
        // ������·���ϵĽ���Ϊ22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);
        System.out.println();
        
        // û��·���ϵĽ���Ϊ15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);
        System.out.println();

        // ��һ��·���ϵĽ���Ϊ19
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

        // ��һ��·������Ľ���Ϊ15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);
        System.out.println();

        // û��·������Ľ���Ϊ16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);
        System.out.println();
		
	}

	private static void test3() {
		 // ����û�н��
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
