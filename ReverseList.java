package com;
/**
 * ��ָoffer: ����ת
 * ���ַ������:1.����;2.�ݹ�.
 * ������������(�����ж���ڵ�,һ���ڵ������Ϊ��)
 * @author dingding
 * Date:2017-6-14 9:55
 * Declaration: All Rights Reserved!
 */

public class ReverseList {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
	
	private static class ListNode{
		int value;
		ListNode next;
	}
	
	//�����ķ�ʽ���з�ת,���ط�ת���ͷ���(pReversedHead)
	private static ListNode reverseListIteratively(ListNode pHead){
		ListNode pReversedHead = null;
		ListNode pNode = pHead;
		ListNode pPrev = null;
		
		while(pNode!=null){
			ListNode pNext = pNode.next;
			if (pNext==null) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		return pReversedHead;
	}
	
	//�ݹ鷽�����з�ת,������һ���ݹ�Ľڵ�
	private static ListNode reverseListRecursively(ListNode pHead){
		if (pHead==null) {
			//System.out.println("����Ϊ��!");
			return null;
		}else {
			while (pHead!=null && pHead.next==null){
				return pHead;
			}
			ListNode pNode = reverseListRecursively(pHead.next);
			pHead.next.next=pHead;
			pHead.next=null;
			
			return pNode;
		}
	}
	
	private static void printList(ListNode pHead){
		if (pHead==null) {
			System.out.println("����Ϊ��!");
		}else {
			while(pHead!=null){
				System.out.print(pHead.value+" ");
				pHead = pHead.next;
			}
		}
		
		System.out.println();
	}
	
	/*================���Դ���================================ */
	private static void test(ListNode first){
		System.out.println("��ʼ�б�:");
		printList(first);
		
		System.out.println("����������ת���:");
		ListNode pTail = reverseListIteratively(first);
		printList(pTail);
		
		System.out.println("�ݹ鷽����ת���:");
		ListNode pNode = reverseListRecursively(pTail);
		printList(pNode);
	}
	
	//����������ж���ڵ�
	private static void test1(){
		ListNode first = new ListNode();
		ListNode second = new ListNode();
		ListNode third = new ListNode();
		ListNode fourth = new ListNode();
		ListNode fifth = new ListNode();
		
		first.value = 1;
		second.value = 2;
		third.value = 3;
		fourth.value = 4;
		fifth.value = 5;
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		test(first);
	}
	//���������ֻ��һ�����
	private static void test2(){
		ListNode first = new ListNode();
		first.value=1;
		test(first);
	}
	//���������
	private static void test3(){
		test(null);
	}
}


