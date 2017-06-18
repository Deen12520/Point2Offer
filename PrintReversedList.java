package com;

import java.util.Stack;

/**
 * ��ָoffer: ��β��ͷ����б�
 * ���ֿ���:1.���ı�����ṹ(ջ,�ݹ�);2.�ı�����ṹ(����/�ݹ�,������ת,���ﲻ����)
 * ������������(�����ж���ڵ�,һ���ڵ������Ϊ��)
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
	
	//����1: ʹ��ջ
	private static void printByStack(ListNode pHead){
		Stack<Integer> list = new Stack<Integer>();
		if (pHead==null) {
			System.out.println("������");
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
	
	//����2:ʹ�õݹ�
	private static void printByRecursive(ListNode pHead){
		if (pHead!=null) {
			if (pHead.getNext()!=null){
				printByRecursive(pHead.getNext());
			}
			System.out.print(pHead.getValue()+" ");   //������46��,��������
		}else{
			System.out.println("������!");
		}
	}
	
	//��ӡ����
	private static void printList(ListNode first) {
		if (first==null) {
			System.out.println("������!");
		}else{
			while (first!=null){
				System.out.print(first.getValue()+" ");
				first = first.getNext();
			}
			System.out.println();
		}
	}
	
	//===========��������===============
	private static void test(ListNode first){
		System.out.println("��ʼ����:");
		printList(first);
		System.out.println("ʹ��ջ��β��ͷ��ӡ����:");
		printByStack(first);
		System.out.println("�ݹ��β��ͷ��ӡ����:");
		printByRecursive(first);
		System.out.println();
	}
	
	//�����ж���ڵ�
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
	
	//����ֻ��һ���ڵ�
	private static void test2() {
		ListNode first = new ListNode(1);
		test(first);
		System.out.println("=============================");
	}

	//����Ϊ��
	private static void test1() {
		test(null);
	}

}

