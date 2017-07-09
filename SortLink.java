package week_4;

/**
 * ������ð������
 * @author dingding
 * Date :2017-7-3 12:25
 */
public class SortLink {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	//solution,ð������,ֱ�ӽ�������ֵ,�ؼ�����ѭ������
	private static Node Sort(Node head){
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		
		Node tail = null;
		Node cur = null;
		cur = head;
		while(cur != tail){
			while (cur.next != tail){
				if (cur.value>cur.next.value) {
					int temp = cur.value;
					cur.value = cur.next.value;
					cur.next.value = temp;
				}
				cur = cur.next;
			}
			tail = cur;  //���������һ����
			cur = head;  //�ڶ���headΪ4
		} 
		
		return head;
	}
	
	//��ӡ����
	private static void printLink(Node head){
		if (head == null) {
			System.out.println("Invalid input.");
			return;
		}
		while (head != null){
			System.out.print(head.value+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	/*======================��������===============*/
	private static void test1() {
		Node first = new Node(5);
		Node second = new Node(4);
		Node third = new Node(3);
		Node fourth = new Node(2);
		Node fifth = new Node(1);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		Node head = Sort(first);
		printLink(head);
				
	}

	private static void test2() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(2);
		Node fifth = new Node(6);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		Node head = Sort(first);
		printLink(head);		
	}

	private static void test3() {
		Node first = new Node(1);
		
		Node head = Sort(first);
		printLink(head);				
	}

	private static void test4() {
		Node head = Sort(null);
		printLink(null);				
	}

}

//����һ������
class Node{
	int value;
	Node next;
	public Node(int value){
		this.value = value;
		this.next = null;
	}
}