package com;
/**
 * ��ָoffer: ��������м�ڵ�
 * ����:1.ʹ������ָ��;
 * ��������:���ܲ���(������ż�����������ڵ�)
 * �����������(����ֻ��һ���ڵ�,����Ϊ��)
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
	
	//���м�ڵ�
	private static ListNode FindMidderNode(ListNode pHead){
		ListNode pAhead = pHead;
		ListNode pBehind = null;
		if (pHead==null) {   //������
			return null;
		}
		if (pHead.getNext()==null) {   //���ڵ�
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
	
	//�������
	private static void printList(ListNode pHead){
		if (pHead==null) {
			System.out.println("������!");
		}
		while (pHead!=null){
			System.out.print(pHead.getValue());
			pHead = pHead.getNext();
		}
		System.out.println();
	}
	
	/*======================��������====================*/
	private static void test(ListNode pHead){
		System.out.println("�������: ");
		printList(pHead);
		System.out.println("����м�ڵ�: ");
		ListNode pMidderNode = FindMidderNode(pHead);
		if (pMidderNode==null) {
			System.out.println(" ������!");
		}else {
			System.out.println(pMidderNode.getValue());
		}
		
	}
	
	//�����ж���ڵ�(����orż��)
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
		
	//����ڵ�,ż��
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
	
	//���ڵ�
	private static void test3() {
		ListNode first = new ListNode(1);
		test(first);
		System.out.println("========================");
	}
	
	//������
	private static void test4(){
		test(null);
	}
	
	
	

}
