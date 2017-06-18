package com;

/**
 * ��ָoffer: �ϲ��������������
 * ����:1.ʹ������ָ��,�ݹ�ʵ��;
 * ��������:���ܲ���(���������ж���ڵ�,�ڵ��ֵ������Ȼ��ߴ���ֵ��ȵĶ���ڵ�)
 * �����������(һ������������Ϊ��,һ������ֻ��һ���ڵ�)
 * @author dingding
 * Date:2017-6-15 10:00
 * Declaration: All Rights Reserved!
 */
public class MergeSortedList {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	
	//�����������������
	private static ListNode merge(ListNode pHead1,ListNode pHead2){
		if (pHead1==null) {
			return pHead2;
		}
		if (pHead2==null) {
			return pHead1;
		}
		ListNode pMergeHead = null;
		if (pHead1.getValue()<pHead2.getValue()) {
			pMergeHead = pHead1;
			pMergeHead.setNext(merge(pHead1.getNext(), pHead2));    //�ݹ�(ѭ�����滻)
		}else {
			pMergeHead = pHead2;
			pMergeHead.setNext(merge(pHead1, pHead2.getNext()));
		}
		return pMergeHead;
	}

	/*==================��������======================*/
	private static void test(ListNode pHead1,ListNode pHead2){
		System.out.println("����ϲ��������: ");
		ListNode pMergeHead = merge(pHead1, pHead2);
		if (pMergeHead==null) {
			System.out.println("����1��2��Ϊ������!");
		}else{
			while (pMergeHead!=null){
				System.out.print(pMergeHead.getValue()+" ");
				pMergeHead = pMergeHead.getNext();
			}
			System.out.println();
		}
	}
	
	//���ж����ͬ�ڵ�
	private static void test1() {
		ListNode first1 = new ListNode(1);
		ListNode second1 = new ListNode(3);
		ListNode third1 = new ListNode(5);
		ListNode fourth1 = new ListNode(7);
		ListNode fifth1 = new ListNode(9);
		
		first1.setNext(second1);
		second1.setNext(third1);
		third1.setNext(fourth1);
		fourth1.setNext(fifth1);
		
		ListNode first2 = new ListNode(2);
		ListNode second2 = new ListNode(4);
		ListNode third2 = new ListNode(5);
		ListNode fourth2 = new ListNode(8);
		ListNode fifth2 = new ListNode(10);
		
		first2.setNext(second2);
		second2.setNext(third2);
		third2.setNext(fourth2);
		fourth2.setNext(fifth2);
		
		test(first1, first2);
		System.out.println("==================================");
	}
	
	//��һ������Ϊ��
	private static void test2() {
		ListNode first1 = new ListNode(1);
		ListNode second1 = new ListNode(3);
		ListNode third1 = new ListNode(4);
		ListNode fourth1 = new ListNode(7);
		ListNode fifth1 = new ListNode(9);
		
		first1.setNext(second1);
		second1.setNext(third1);
		third1.setNext(fourth1);
		fourth1.setNext(fifth1);
		
		test(first1, null);
		System.out.println("==================================");
	}
	
	//��������Ϊ��
	private static void test3(){
		test(null, null);
	}

}
