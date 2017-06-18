package com;
/**
 * 剑指offer: 链表反转
 * 两种方法求解:1.遍历;2.递归.
 * 测试用例三种(链表有多个节点,一个节点核链表为空)
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
	
	//遍历的方式进行反转,返回反转后的头结点(pReversedHead)
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
	
	//递归方法进行反转,返回下一个递归的节点
	private static ListNode reverseListRecursively(ListNode pHead){
		if (pHead==null) {
			//System.out.println("链表为空!");
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
			System.out.println("链表为空!");
		}else {
			while(pHead!=null){
				System.out.print(pHead.value+" ");
				pHead = pHead.next;
			}
		}
		
		System.out.println();
	}
	
	/*================测试代码================================ */
	private static void test(ListNode first){
		System.out.println("初始列表:");
		printList(first);
		
		System.out.println("遍历方法反转结果:");
		ListNode pTail = reverseListIteratively(first);
		printList(pTail);
		
		System.out.println("递归方法反转结果:");
		ListNode pNode = reverseListRecursively(pTail);
		printList(pNode);
	}
	
	//输入的链表有多个节点
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
	//输入的链表只有一个结点
	private static void test2(){
		ListNode first = new ListNode();
		first.value=1;
		test(first);
	}
	//输入空链表
	private static void test3(){
		test(null);
	}
}


