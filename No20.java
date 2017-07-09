package week_4;
/**难度系数:***
 * 剑指offer: 顺时针打印矩阵
 * 方法: 找规律
 * 测试用例:数组只有一行,一列,一行一列,二行二列,多行多列,为空
 * @author dingding
 * Date:2017-7-8 14:10
 * Declaration: All Rights Reserved!
 */
public class No20 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	//solution
	private static void printMatrixClockwisely(int[][] numbers,int columns,int rows){
		if (numbers == null || columns<=0 || rows <=0) {
			return;
		}
		int start = 0;
		while (columns >start*2 && rows >start*2){
			printMatrixInCircle(numbers,columns,rows,start);
			++start;
		}
	}
	
	//顺时针打印
	private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
		int endX = columns - 1 -start;  //列
		int endY = rows - 1 -start;     //行
		
		//从左到右打印一行
		for(int i=start;i<=endX;++i){
			int number = numbers[start][i];
			System.out.print(" "+number);
		}
		
		//从上到下打印一列
		if (start<endY) {
			for (int i = start+1;i<=endY;++i){
				int number = numbers[i][endX];
				System.out.print(" "+number);
			}
		}
		
		//从右到左打印一行
		if (start<endX && start<endY) {
			for (int i=endX-1;i>=start;--i){
				int number = numbers[endY][i];
				System.out.print(" "+number);
			}
		}
		
		//从下到上打印一列
		if (start < endX && start < endY-1) {
			for (int i=endY-1;i>=start+1;--i){
				int number = numbers[i][start];
				System.out.print(" "+number);
			}
		}
	}

	private static void test1() {
		int numbers[][]= {{1,2,3}};
		printMatrixClockwisely(numbers, numbers[0].length, numbers.length);
		System.out.println();
		System.out.println("================test1===================");
	}

	private static void test2() {
		int numbers[][]= {{1},{2}};
		printMatrixClockwisely(numbers, numbers[0].length, numbers.length);	
		System.out.println();
		System.out.println("================test2===================");
	}

	private static void test3() {
		int numbers[][]= {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		printMatrixClockwisely(numbers, numbers[0].length, numbers.length);	
		System.out.println();
		System.out.println("================test3===================");
	}

	private static void test4() {
		int numbers[][]= {{1}};
		printMatrixClockwisely(numbers, numbers[0].length, numbers.length);	
		System.out.println();
		System.out.println("================test4===================");
	}

	private static void test5() {
		int numbers[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		printMatrixClockwisely(numbers, numbers[0].length, numbers.length);	
	}

}
