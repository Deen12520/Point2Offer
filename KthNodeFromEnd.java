package com;

import java.util.Scanner;

/**
 * 剑指offer: 找到倒数第K个节点
 * 方法:1.使用两个指针;2.遍历(此处忽略,因为需遍历两次)
 * 测试用例三种(链表有多个节点,一个节点,链表为空,K大于链表节点数,K在结尾或者开头,K为负数)
 * @author dingding
 * Date:2017-6-14 17:00
 * Declaration: All Rights Reserved!
 */

public class KthNodeFromEnd {
	public static void main(String[] args) {
		test1();
		test2();
	}
	//查找倒数第K个节点
	private static ListNode FindKthToTail(ListNode pHead,int k){
		ListNode pAhead = pHead;
		ListNode pBehind = null;
		
		if (pHead==null||k==0) //处理输入的k为0
			return null;
	
		for(int i=0;i<k-1;i++){
			if (pAhead.getNext()!=null) {    //处理K大于链表长度
				pAhead = pAhead.getNext();
			}else{
				return null;
			}
			
		}
		pBehind = pHead;
		while (pAhead.getNext()!=null){
			pBehind = pBehind.getNext();
			pAhead = pAhead.getNext();
		}
		return pBehind;
	}

	//链表打印
	private static void printList(ListNode pHead) {
		if (pHead==null) {
			System.out.println("空链表!");
		}else {
			while (pHead!=null){
				System.out.print(pHead.getValue()+" ");
				pHead = pHead.getNext();
			}
			System.out.println();
		}
	}
	
	/*=====================测试用例===============*/
	private static void test(ListNode pHead,int k) {
		System.out.println("初始链表 :");
		printList(pHead);
		System.out.println("输出倒数第K个节点  :");
		ListNode kthToTail = FindKthToTail(pHead, k);
		if (kthToTail==null) {
			System.out.println("K大于链表长度,或者为空链表.");
		}else {
			System.out.println(kthToTail.getValue());
		}
		System.out.println("==============================");
	}
	
	//链表有多个节点
	private static void test1() {
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
		
		System.out.print("输入K: ");
		Scanner fin = new Scanner(System.in);
		int K = fin.nextInt();
		test(first, K);
	}
	
	//链表为空
	private static void test2() {
		System.out.print("输入K: ");
		Scanner fin = new Scanner(System.in);
		int K = fin.nextInt();
		test(null, K);
	}


}
