package com;

import java.util.Scanner;

/**
 * ��ָoffer: �ҵ�������K���ڵ�
 * ����:1.ʹ������ָ��;2.����(�˴�����,��Ϊ���������)
 * ������������(�����ж���ڵ�,һ���ڵ�,����Ϊ��,K��������ڵ���,K�ڽ�β���߿�ͷ,KΪ����)
 * @author dingding
 * Date:2017-6-14 17:00
 * Declaration: All Rights Reserved!
 */

public class KthNodeFromEnd {
	public static void main(String[] args) {
		test1();
		test2();
	}
	//���ҵ�����K���ڵ�
	private static ListNode FindKthToTail(ListNode pHead,int k){
		ListNode pAhead = pHead;
		ListNode pBehind = null;
		
		if (pHead==null||k==0) //���������kΪ0
			return null;
	
		for(int i=0;i<k-1;i++){
			if (pAhead.getNext()!=null) {    //����K����������
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

	//�����ӡ
	private static void printList(ListNode pHead) {
		if (pHead==null) {
			System.out.println("������!");
		}else {
			while (pHead!=null){
				System.out.print(pHead.getValue()+" ");
				pHead = pHead.getNext();
			}
			System.out.println();
		}
	}
	
	/*=====================��������===============*/
	private static void test(ListNode pHead,int k) {
		System.out.println("��ʼ���� :");
		printList(pHead);
		System.out.println("���������K���ڵ�  :");
		ListNode kthToTail = FindKthToTail(pHead, k);
		if (kthToTail==null) {
			System.out.println("K����������,����Ϊ������.");
		}else {
			System.out.println(kthToTail.getValue());
		}
		System.out.println("==============================");
	}
	
	//�����ж���ڵ�
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
		
		System.out.print("����K: ");
		Scanner fin = new Scanner(System.in);
		int K = fin.nextInt();
		test(first, K);
	}
	
	//����Ϊ��
	private static void test2() {
		System.out.print("����K: ");
		Scanner fin = new Scanner(System.in);
		int K = fin.nextInt();
		test(null, K);
	}


}
