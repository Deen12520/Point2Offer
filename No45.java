package week_4;
/**难度系数:***
 * 剑指offer: 圆圈中最后剩下的数字
 * 方法: f(n,m) = [f(n-1,m)+m]%n; n>1
 * 测试用例:功能测试(0个数字,多个数字,1000个数字,m>n)
 * @author dingding
 * Date:2017-7-6 10:20
 * Declaration: All Rights Reserved!
 */
public class No45 {

	public static void main(String[] args) {
		test1();
	}

	//solution
	private static int lastNumInCircle(int n,int m){
		if (n<1 || m<1) {
			return -1;
		}
		int last = 0;
		for (int i=2;i<=n;i++){
			last = (last + m) % i;
		}
		return last;
	}
	/*=================测试用例============*/
	private static void test1() {
		int result = lastNumInCircle(5, 3);
		System.out.println(result);
	}

}
