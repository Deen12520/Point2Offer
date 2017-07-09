package week_4;

import java.util.Stack;

/**难度系数:***
 * 剑指offer: 栈的压入,弹出序列
 * 方法: 辅助栈,拿弹出序列与压入栈比较
 * 测试用例:功能测试(数组含多个数字或1个数字,是弹出序列和不是弹出序列)
 * @author dingding
 * Date:2017-7-6 9:30
 * Declaration: All Rights Reserved!
 */
public class No22 {

	public static void main(String[] args) {
		test1();
	}

	//solution
	private static boolean isPopOrder(int[] pushOrder,int[] popOrder,int length){
		boolean flag = true;
		if (pushOrder != null && popOrder != null && length>0) {
			int pushIndex = 0;
			int popIndex = 0;
			
			Stack<Integer> stack = new Stack<>();
			while (popIndex <popOrder.length){
				while (pushIndex <pushOrder.length && (stack.isEmpty() || stack.peek() != popOrder[popIndex]) ){
					stack.push(pushOrder[pushIndex]);
					pushIndex++;
				}
				if (stack.peek() == popOrder[popIndex]) {
					stack.pop();
					popIndex++;
				}else {
					flag = false;
					return flag;
				}
			}
		}else{
			flag = false;
		}
			
		return flag;
	}
	
	/*===============测试用例==========*/
	private static void test1() {
		int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};

        System.out.println("true: " + isPopOrder(push, pop1,5));
        System.out.println("true: " + isPopOrder(push, pop2,5));
        System.out.println("false: " + isPopOrder(push, pop3,5));
        System.out.println("false: " + isPopOrder(push, pop4,5));

        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5,5));

        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6,5));

        System.out.println("false: " + isPopOrder(null, null,0));		
	}

}
