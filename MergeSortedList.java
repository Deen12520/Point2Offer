package com;

/**
 * 剑指offer: 合并两个排序的链表
 * 方法:1.使用两个指针,递归实现;
 * 测试用例:功能测试(两个链表都有多个节点,节点的值互不相等或者存在值相等的多个节点)
 * 特殊输入测试(一个或两个链表为空,一个链表只有一个节点)
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
	
	//处理两个排序的链表
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
			pMergeHead.setNext(merge(pHead1.getNext(), pHead2));    //递归(循环的替换)
		}else {
			pMergeHead = pHead2;
			pMergeHead.setNext(merge(pHead1, pHead2.getNext()));
		}
		return pMergeHead;
	}

	/*==================测试用例======================*/
	private static void test(ListNode pHead1,ListNode pHead2){
		System.out.println("输出合并后的链表: ");
		ListNode pMergeHead = merge(pHead1, pHead2);
		if (pMergeHead==null) {
			System.out.println("链表1和2都为空链表!");
		}else{
			while (pMergeHead!=null){
				System.out.print(pMergeHead.getValue()+" ");
				pMergeHead = pMergeHead.getNext();
			}
			System.out.println();
		}
	}
	
	//含有多个不同节点
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
	
	//有一个链表为空
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
	
	//两个链表都为空
	private static void test3(){
		test(null, null);
	}

}
