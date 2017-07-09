package week_4;

import java.util.Stack;

/**难度系数:**
 * 剑指offer: 两个栈实现一个队列
 * 方法: 队尾插入,队头删除
 * 测试用例:功能测试(空的队列添加删除,非空的添加删除,连续删除置为空)
 * @author dingding
 * Date:2017-7-6 8:30
 * Declaration: All Rights Reserved!
 */
public class No7 {
	
	public static void main(String[] args){
		test1();
	}
	//定义一个队列
	public static class CQueue<T>{
		private  Stack<T> stack1= new Stack<>();
		private  Stack<T> stack2= new Stack<>();
		
		public CQueue(){
			
		}
		//solution,队头添加
		private void appendTail(T number){
			stack1.add(number);
		}
		
		//队尾删除
		private  T deleteHead(){
			//栈2为空,把栈1值取出放入2
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
	
	

	/*=======================测试用例==================*/
	private static void test1(){
		CQueue<Integer> cQueue = new CQueue<>();
		for (int i=0;i<5;i++){
			cQueue.appendTail(i);
		}
		Integer head = cQueue.deleteHead();
		System.out.println("删除队头为: "+ head);
		cQueue.appendTail(5);
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
		System.out.print(" "+cQueue.deleteHead());
	}
}
