package com;

import java.util.Stack;

/**
 * 剑指offer: 从尾到头输出列表
 * 两种考虑:1.不改变链表结构(栈,递归);2.改变链表结构(遍历/递归,见链表反转,这里不考虑)
 * 测试用例三种(链表有多个节点,一个节点核链表为空)
 * @author dingding
 * Date:2017-6-14 15:06
 * Declaration: All Rights Reserved!
 */

public class PrintReversedList {

	public static void main(String[] args) {
		test3();
		test2();
		test1();
	}
	
	//方法1: 使用栈
	private static void printByStack(ListNode pHead){
		Stack<Integer> list = new Stack<Integer>();
		if (pHead==null) {
			System.out.println("空链表");
		}else{
			while (pHead!=null){
				list.push((Integer)pHead.getValue());
				pHead = pHead.getNext();
			}
			
			while (!list.isEmpty()){
				Integer a = list.pop();
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
	
	//方法2:使用递归
	private static void printByRecursive(ListNode pHead){
		if (pHead!=null) {
			if (pHead.getNext()!=null){
				printByRecursive(pHead.getNext());
			}
			System.out.print(pHead.getValue()+" ");   //若放在46行,结果会出错
		}else{
			System.out.println("空链表!");
		}
	}
	
	//打印链表
	private static void printList(ListNode first) {
		if (first==null) {
			System.out.println("空链表!");
		}else{
			while (first!=null){
				System.out.print(first.getValue()+" ");
				first = first.getNext();
			}
			System.out.println();
		}
	}
	
	//===========测试用例===============
	private static void test(ListNode first){
		System.out.println("初始链表:");
		printList(first);
		System.out.println("使用栈从尾到头打印链表:");
		printByStack(first);
		System.out.println("递归从尾到头打印链表:");
		printByRecursive(first);
		System.out.println();
	}
	
	//链表有多个节点
	private static void test3() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		
		test(first);
		System.out.println("=============================");
	}
	
	//链表只有一个节点
	private static void test2() {
		ListNode first = new ListNode(1);
		test(first);
		System.out.println("=============================");
	}

	//链表为空
	private static void test1() {
		test(null);
	}

}

