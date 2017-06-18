package com;
/**
 * 剑指offer: 求链表的中间节点
 * 方法:1.使用两个指针;
 * 测试用例:功能测试(链表有偶数或奇数个节点)
 * 特殊输入测试(链表只有一个节点,链表为空)
 * @author dingding
 * Date:2017-6-15 10:00
 * Declaration: All Rights Reserved!
 */
public class MidderNodeOfList {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}
	
	//找中间节点
	private static ListNode FindMidderNode(ListNode pHead){
		ListNode pAhead = pHead;
		ListNode pBehind = null;
		if (pHead==null) {   //空链表
			return null;
		}
		if (pHead.getNext()==null) {   //单节点
			return pHead;
		}
		pBehind = pHead;
		while (pAhead.getNext()!=null){
			pBehind = pBehind.getNext();
			pAhead = pAhead.getNext().getNext();
			if (pAhead==null) {
				break;
			}
		}
		return pBehind;
	}
	
	//输出链表
	private static void printList(ListNode pHead){
		if (pHead==null) {
			System.out.println("空链表!");
		}
		while (pHead!=null){
			System.out.print(pHead.getValue());
			pHead = pHead.getNext();
		}
		System.out.println();
	}
	
	/*======================测试用例====================*/
	private static void test(ListNode pHead){
		System.out.println("输出链表: ");
		printList(pHead);
		System.out.println("输出中间节点: ");
		ListNode pMidderNode = FindMidderNode(pHead);
		if (pMidderNode==null) {
			System.out.println(" 空链表!");
		}else {
			System.out.println(pMidderNode.getValue());
		}
		
	}
	
	//链表有多个节点(奇数or偶数)
	private static void test1() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		fourth.setNext(fifth);
		
		test(first);
		System.out.println("========================");
	}
		
	//多个节点,偶数
	private static void test2() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		
		test(first);
		System.out.println("========================");
	}
	
	//单节点
	private static void test3() {
		ListNode first = new ListNode(1);
		test(first);
		System.out.println("========================");
	}
	
	//空链表
	private static void test4(){
		test(null);
	}
	
	
	

}
