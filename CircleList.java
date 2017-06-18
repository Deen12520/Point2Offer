package com;

/**
 * ��ָoffer: �ж�һ�����������Ƿ��γ��˻��νṹ
 * ����:1.ʹ������ָ��;
 * ��������:���ܲ���(�����ж���ڵ�:���ɻ��κͲ����ɻ���)
 * �����������(����ֻ��һ���ڵ�,����Ϊ��,�϶������ɻ���)
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
	
	/*================��������==========================*/
	private static void test(ListNode pHead){
		System.out.println("�Ƿ��ǻ����б�? ");
		Boolean flag = isCircle(pHead);
		if (flag) {
			System.out.println("Yes!");
		}else {
			System.out.println("No!");
		}	
	}
	
	//����ڵ�,����,�ɻ�
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

	//����ڵ�,ż��,�ɻ�
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
	
	//����ڵ�,����,���ɻ�
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
	//����ڵ�,ż��,���ɻ�
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
	//�����ڵ�
	private static void test5(){
		ListNode first = new ListNode(1);
		test(first);
		System.out.println("==============================");
	}
	//������
	private static void test6(){
		test(null);
	}

}
