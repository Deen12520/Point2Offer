package week_4;

/**难度系数:***
 * 剑指offer: 在O(1)时间删除链表节点
 * 方法: O(1)时间,不遍历前序结点,复制覆盖
 * 测试用例:功能测试(链表有多个结点/1个结点/为空/删除头结点/中间结点/尾结点)
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
	
	//O(n)时间,顺序遍历
	private static ListNode deleteNode_N(ListNode head,ListNode toBeDeleted){
		if (head == null || toBeDeleted == null) {
			System.out.println("链表为空.");
			return null;
		}
		//只有一个结点,将head置为空
		if (head.next == null) {
			return null;
		}
		
		ListNode pCur = head;  //当前指针
		while (pCur != null){
			if (head == toBeDeleted) {
				return head.next;
			}
			if (pCur.next == toBeDeleted) {
				//判断是否是最后一个结点
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
	
	//O(1)时间,不遍历前序结点,复制覆盖
	private static ListNode deleteNode_1(ListNode head,ListNode toBeDeleted){
		if (head == null || toBeDeleted == null) {
			System.out.println("Invalid input.");
			return null;
		}
		
		//要删除不是尾结点
		if (toBeDeleted.next != null) {
			ListNode pNext =toBeDeleted.next;
			toBeDeleted.data = pNext.data;
			toBeDeleted.next = pNext.next;    //pNext结点并没释放
		}else if (head == toBeDeleted) {   //链表只有一个节点,删除头结点(也是尾结点)
			head = null;
		}else {   //链表中有多个节点,删除尾结点
 			ListNode pNode = head;
 			while (pNode.next != toBeDeleted){
 				pNode = pNode.next;
 			}
 			pNode.next = null;
		}
		return head;
	}
	
	//打印链表
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
	
	/*===================测试用例================*/
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
	//链表有多个节点
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
//构造链表
class ListNode{
	int data;
	ListNode next;
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}
