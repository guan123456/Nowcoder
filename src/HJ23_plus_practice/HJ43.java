package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ43 {


	//定义在外面，全局要用
	static int[][] matrix;
	static int rows;
	static int columns;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			//标记方式
			//1.使用一个辅助的boolean矩阵，每访问就标记true，到最后回来如果走不通则清空，不然就输出
			//2.使用一个LinkedHash存储访问过的结点信息
			//数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
			//这样可以投机取巧，直接找到通道就算成功了
			
			rows = scanner.nextInt();
			columns = scanner.nextInt();
			matrix = new int[rows][columns];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			//这方法牛b!!!
			//但是有向上或者向左的就不行了
			setBlock(0, 0);//将走不通的路封死
			goStraight(0, 0);//打印唯一的道路
		}
	}
	public static void setBlock(int x, int y) {
		if(x == rows - 1 && y == columns - 1) {
			return;
		}
		//向下
		if(x + 1 < rows) {
			if(matrix[x + 1][y] != 1) {
				setBlock(x + 1, y);
			}
		}
		//向右
		if(y + 1 < columns) {
			if(matrix[x][y + 1] != 1) {
				setBlock(x, y + 1);
			}
		}
		//向下到底了，不能向下，并且也不能向右
		if(x + 1 == rows && matrix[x][y + 1] == 1) {
			matrix[x][y] = 1;
		}
		//向下没到底，但向下被阻塞，并且向右没到底，但向右被阻塞
		if(x + 1 != rows && y + 1 != columns) {
			if(matrix[x+1][y] == 1 && matrix[x][y+1] == 1) {
				matrix[x][y] = 1;
			}
		}
	}
	public static void goStraight(int x, int y) {
		if(x == rows - 1 && y == columns - 1) {
			System.out.println("(" + x + "," + y + ")");
		}
		//向下
		if(x + 1 < rows) {
			if(matrix[x+1][y] != 1) {
				System.out.println("(" + x + "," + y + ")");
				goStraight(x+1, y);
			}
		}
		//向右
		if(y + 1 < columns) {
			if(matrix[x][y+1] != 1) {
				System.out.println("(" + x + "," + y + ")");
				goStraight(x, y+1);
			}
		}
	}
}
