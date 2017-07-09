package week_4;

/**�Ѷ�ϵ��:***
 * ��ָoffer: ��������ĵ�һ�������ڵ�
 * ����: ����ָ��
 * ��������:���ܲ���(�����ж�����/Ϊ��/��һ�������ڵ�Ϊͷ�ڵ�/�м�ڵ�/β���)
 * @author dingding
 * Date:2017-7-5 21:10
 * Declaration: All Rights Reserved!
 */
public class No37 {

	public static void main(String[] args) {
		test1();
	}

	//solution
	private static ListNode findFirstCommonNode(ListNode head1,ListNode head2){
		//��ȡ��������ĳ���
		int length1 = getListLength(head1);
		int length2 = getListLength(head2);
		int diff = length1 - length2;
		
		ListNode pListHeadLong = head1;
		ListNode pListHeadShort = head2;
		if (diff < 0) {
			pListHeadLong = head2;
			pListHeadShort = head1;
			diff = length2 - length1;
		}
		
		//�ڳ����������߼���,��ͬʱ�����������ϱ���
		for (int i=0;i<diff;i++){
			pListHeadLong = pListHeadLong.next;
		}
		
		while ((pListHeadLong != null) && (pListHeadShort != null) 
				&& (pListHeadLong.data != pListHeadShort.data)){   //Ҫ��ֵ���
			pListHeadLong = pListHeadLong.next;
			pListHeadShort = pListHeadShort.next;
		}
		
		//�õ���һ�������ڵ�
		ListNode pFirstCommonNode = pListHeadLong;
		return pFirstCommonNode;
		
	}
	
	private static int getListLength(ListNode head) {
		int length = 0;
		ListNode pNode = head;
		while (pNode != null){
			length++;
			pNode = pNode.next;
		}
		return length;
	}

	/*===================��������==================*/
	private static void test1() {
		ListNode first = new ListNode(5);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(2);
		ListNode fifth = new ListNode(1);
		
		first.next = second;
		second.next = third;
		third.next =fourth;		
		fourth.next = fifth;
		
		ListNode head = new ListNode(7);
		ListNode first1 = new ListNode(6);
		ListNode second1 = new ListNode(8);
		ListNode third1 = new ListNode(3);
		ListNode fourth1 = new ListNode(2);
		ListNode fifth1 = new ListNode(1);
		
		head.next = first1;
		first1.next = second1;
		second1.next = third1;
		third1.next =fourth1;		
		fourth1.next = fifth1;
		
		ListNode node = findFirstCommonNode(first, head);
		if (node != null) {
			System.out.println(node.data);
		}else{
			System.out.println("NULL");
		}
			
		
	}

}
