package HJ23_plus_practice;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 2, 2021 12:54:32 PM
*/
public class HJ35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//从上到下一行一行打印即可，搞清楚打印的逻辑就行
		//最重要的是找出统一的公式就行
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int temp = 0;
/*			for(int i = 1 ; i <= n; i++) {
				//原来写法for(int j = 0; j < n - i; j++)
				for(int j = 1; j <= n -i + 1 ; j++) {
					if(j == 1) {
						temp = j+(i*(i-1))/2;
						System.out.print(temp + " ");
						
					}else {
						System.out.print(temp + ((j + i - 1)*(j + i))/2 - ((i+1)*i)/2 + " ");
					}
				}
				System.out.println();
			}*/
			//以上方法改进
			for(int i = 0; i < n; i++) {
				for(int j = (i + 1); j <= n; j++) {
					System.out.print(((j*j + j) /2) - i + " ");
				}
				System.out.println();
			}
			//或者还有方法
			//第一行[1 3 6 10]
			//第二行是 去掉第一行的第一列，然后将后面的[3 6 10]分别减1得到的。
		}
	}

}
