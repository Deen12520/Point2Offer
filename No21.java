package week_5;

import java.util.Stack;

/**�Ѷ�ϵ��:***
 * ��ָoffer: ����min������ջ
 * ����: ��һ������ջ,����Сֵ
 * ��������:
 * @author dingding
 * Date:2017-7-11 21:40
 * Declaration: All Rights Reserved!
 */
public class No21 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	//������ջ
	public static class CStack{
		private Stack<Integer> stack_data = new Stack<>();
		private Stack<Integer> stack_min = new Stack<>();
		
		private void push(Integer number){
			stack_data.add(number);
			if (stack_min.isEmpty() || number<stack_min.peek()) {
				stack_min.add(number);
			}else {
				stack_min.add(stack_min.peek());
			}
		}
		
		private int pop(){
			if (stack_data.isEmpty() && stack_min.isEmpty()) {
				throw new RuntimeException("The stack is already empty");
			}
			stack_min.pop();
			return stack_data.pop();
		}
		
		private int min(){
			if (!stack_data.isEmpty() && !stack_min.isEmpty()) {
				return stack_min.peek();
			}else {
				throw new RuntimeException("No more element.");
			}
		}
		
	}
	/*===================��������=============*/
	//��ջ��ǰһ�������
	private static void test4() {
		CStack cStack = new CStack();
		cStack.push(3);
		cStack.push(4);
		int result = cStack.min();
		System.out.println(result);
		System.out.println();
		
	}
	//��ջ��ǰһ��С����
	private static void test3() {
		CStack cStack = new CStack();
		cStack.push(3);
		cStack.push(4);
		cStack.push(2);
		int result = cStack.min();
		System.out.println(result);
		System.out.println();		
	}
	
	//����ջ������С����
	private static void test2() {
		CStack cStack = new CStack();
		cStack.push(1);
		cStack.push(3);
		cStack.push(4);
		cStack.pop();
		int result = cStack.min();
		System.out.println(result);
		System.out.println();			
	}
	//����ջ����С����
	private static void test1() {
		CStack cStack = new CStack();
		cStack.push(3);
		cStack.push(4);
		cStack.push(2);
		cStack.push(1);
		cStack.pop();
		int result = cStack.min();
		System.out.println(result);
		System.out.println();		
	}

}
