package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ44 {

	//例如我们用line[2][3] = True
	//line[2][3]=True 表示数字 4 在第 2 行已经出现过
	//那么当我们在遍历到第 22行的空白格时，就不能填入数字 4
	//也就是line[i][x]代表数字x+1已经在第i行中出现过
	//存x的时候可以用line[i][x-1] = true
	private static boolean[][] line = new boolean[9][9];
	private static boolean[][] column = new boolean[9][9];
	private static boolean[][][] block = new boolean[3][3][9];
	private static boolean valid = false;
	//这里链表数组用的妙啊！！！
	private static List<int[]> zeros = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			//获取数独信息并存起来
			int[][] matrix = new int[9][9];
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
			//初始化
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(matrix[i][j] == 0) {
						//用数组来存储0的位置
						zeros.add(new int[] {i,j});
					}else {
						int digit = matrix[i][j] - 1;
						line[i][digit] = true;
						column[j][digit] = true;
						block[i/3][j/3][digit] = true;
					}
				}
			}
			solveSudoku(matrix,0);
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(matrix[i][j]);
					if(j != 8) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}

	public static void solveSudoku(int[][] matrix, int position) {
		if(position == zeros.size()) {
			valid = true;
			//直接跳回到了前面的main函数里
			//也就是matrix数独已经填好了!!!
			return;
		}
		int[] zero = zeros.get(position);
		int i = zero[0];
		int j = zero[1];
		for(int digit = 0; digit < 9 && !valid; digit++) {
			if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]) {
				line[i][digit] = true;
				column[j][digit] = true;
				block[i/3][j/3][digit] = true;
				matrix[i][j] = digit + 1;
				solveSudoku(matrix, position + 1);
				//回溯
				line[i][digit] = false;
				column[j][digit] = false;
				block[i/3][j/3][digit] = false;
			}
		}
	}
}
