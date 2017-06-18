package com;

/**
 * 剑指offer: 判断一个单项链表是否形成了环形结构
 * 方法:1.使用两个指针;
 * 测试用例:功能测试(链表有多个节点:构成环形和不构成环形)
 * 特殊输入测试(链表只有一个节点,链表为空,肯定不构成环形)
 * @author dingding
 * Date:2017-6-15 15:00
 * Declaration: All Rights Reserved!
 */
public class CircleList {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	private static boolean isCircle(ListNode pHead){
		ListNode pAhead = pHead;
		ListNode pBehind = null;
		if (pHead==null||pHead.getNext()==null) {
			return false;
		}else {
			pAhead = pAhead.getNext();
			pBehind = pHead;
			while (pAhead.getNext()!=null){
				pAhead=pAhead.getNext().getNext();
				pBehind=pBehind.getNext();
				if (pAhead==null) {
					break;
				}
				if (pAhead==pBehind||pAhead.getNext()==pBehind) {
					return true;
				}
			}
			return false;
		}
	}
	
	/*================测试用例==========================*/
	private static void test(ListNode pHead){
		System.out.println("是否是环形列表? ");
		Boolean flag = isCircle(pHead);
		if (flag) {
			System.out.println("Yes!");
		}else {
			System.out.println("No!");
		}	
	}
	
	//多个节点,奇数,成环
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
		fifth.setNext(first);
		
		test(first);
		System.out.println("==============================");
	}

	//多个节点,偶数,成环
	private static void test2() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		fourth.setNext(fifth);
		fifth.setNext(sixth);
		sixth.setNext(first);
		
		test(first);
		System.out.println("==============================");
	}
	
	//多个节点,奇数,不成环
	private static void test3() {
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
		System.out.println("==============================");
	}
	//多个节点,偶数,不成环
	private static void test4() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		fourth.setNext(fifth);
		fifth.setNext(sixth);
		
		test(first);
		System.out.println("==============================");
	}
	//单个节点
	private static void test5(){
		ListNode first = new ListNode(1);
		test(first);
		System.out.println("==============================");
	}
	//空链表
	private static void test6(){
		test(null);
	}

}
