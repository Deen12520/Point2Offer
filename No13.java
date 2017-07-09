package week_4;

/**�Ѷ�ϵ��:***
 * ��ָoffer: ��O(1)ʱ��ɾ������ڵ�
 * ����: O(1)ʱ��,������ǰ����,���Ƹ���
 * ��������:���ܲ���(�����ж�����/1�����/Ϊ��/ɾ��ͷ���/�м���/β���)
 * @author dingding
 * Date:2017-7-5 17:10
 * Declaration: All Rights Reserved!
 */
public class No13 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	
	//O(n)ʱ��,˳�����
	private static ListNode deleteNode_N(ListNode head,ListNode toBeDeleted){
		if (head == null || toBeDeleted == null) {
			System.out.println("����Ϊ��.");
			return null;
		}
		//ֻ��һ�����,��head��Ϊ��
		if (head.next == null) {
			return null;
		}
		
		ListNode pCur = head;  //��ǰָ��
		while (pCur != null){
			if (head == toBeDeleted) {
				return head.next;
			}
			if (pCur.next == toBeDeleted) {
				//�ж��Ƿ������һ�����
				if (pCur.next.next == null) {
					pCur.next = null;
					return head;
				}else {
					ListNode temp = pCur.next.next;
					pCur.next.next = null;
					pCur.next = temp;
					return head;
				}
			}
			pCur = pCur.next;
		}
		return head;
	}
	
	//O(1)ʱ��,������ǰ����,���Ƹ���
	private static ListNode deleteNode_1(ListNode head,ListNode toBeDeleted){
		if (head == null || toBeDeleted == null) {
			System.out.println("Invalid input.");
			return null;
		}
		
		//Ҫɾ������β���
		if (toBeDeleted.next != null) {
			ListNode pNext =toBeDeleted.next;
			toBeDeleted.data = pNext.data;
			toBeDeleted.next = pNext.next;    //pNext��㲢û�ͷ�
		}else if (head == toBeDeleted) {   //����ֻ��һ���ڵ�,ɾ��ͷ���(Ҳ��β���)
			head = null;
		}else {   //�������ж���ڵ�,ɾ��β���
 			ListNode pNode = head;
 			while (pNode.next != toBeDeleted){
 				pNode = pNode.next;
 			}
 			pNode.next = null;
		}
		return head;
	}
	
	//��ӡ����
	private static void printList(ListNode head){
		if (head == null) {
			return;
		}
		while (head != null){
			System.out.print(" " +head.data);
			head = head.next;
		}
		System.out.println();
	}
	
	/*===================��������================*/
	private static void test(ListNode head,ListNode node){
		System.out.println("The original list is: ");
		printList(head);
//		System.out.println("The O(n) solution result is: ");
//		deleteNode_N(head, node);
//		printList(head);
		System.out.println("The O(1) solution result is: ");
		head = deleteNode_1(head, node);
		printList(head);
		
	}
	//�����ж���ڵ�
	private static void test1() {
		ListNode first = new ListNode(5);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(2);
		
		first.next = second;
		second.next = third;
		third.next =fourth;
		
		test(first, first);
	}

	private static void test2() {
		ListNode first = new ListNode(5);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(2);
		
		first.next = second;
		second.next = third;
		third.next =fourth;
		
		test(first, second);		
	}

	private static void test3() {
		ListNode first = new ListNode(5);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(2);
		
		first.next = second;
		second.next = third;
		third.next =fourth;
		
		test(first, fourth);		
	}

	private static void test4() {
		ListNode first = new ListNode(5);
	
		test(first, first);
	}

	private static void test5() {
		test(null, null);		
	}

}
//��������
class ListNode{
	int data;
	ListNode next;
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}
