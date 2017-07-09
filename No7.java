package week_4;

import java.util.Stack;

/**�Ѷ�ϵ��:**
 * ��ָoffer: ����ջʵ��һ������
 * ����: ��β����,��ͷɾ��
 * ��������:���ܲ���(�յĶ������ɾ��,�ǿյ����ɾ��,����ɾ����Ϊ��)
 * @author dingding
 * Date:2017-7-6 8:30
 * Declaration: All Rights Reserved!
 */
public class No7 {
	
	public static void main(String[] args){
		test1();
	}
	//����һ������
	public static class CQueue<T>{
		private  Stack<T> stack1= new Stack<>();
		private  Stack<T> stack2= new Stack<>();
		
		public CQueue(){
			
		}
		//solution,��ͷ���
		private void appendTail(T number){
			stack1.add(number);
		}
		
		//��βɾ��
		private  T deleteHead(){
			//ջ2Ϊ��,��ջ1ֵȡ������2
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()){
					stack2.add(stack1.pop());
				}
			}
			if (stack2.isEmpty()) {
				throw new RuntimeException("No more element.");
			}
			
			return stack2.pop();
		}
	}
	
	

	/*=======================��������==================*/
	private static void test1(){
		CQueue<Integer> cQueue = new CQueue<>();
		for (int i=0;i<5;i++){
			cQueue.appendTail(i);
		}
		Integer head = cQueue.deleteHead();
		System.out.println("ɾ����ͷΪ: "+ head);
		cQueue.appendTail(5);
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
	}
}
