package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 3, 2021 3:51:10 PM
*/
import java.util.*;
public class HJ37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(GetRabitNumbers(n));
		}
	}
	public static int GetRabitNumbers(int n) {
		if(n < 3) {
			return 1;
		}
		int pre = 1;
		int mid = 1;
		int cur = 0;
		for(int i = 3; i <= n; i++) {
			cur = pre + mid;
			pre = mid;
			mid = cur;
		}
		return cur;
	}

	//以下的方式会计算错误
/*	public static int GetRabitNumbers(int n) {
		if(n < 3) {
			return 1;
		}
		int pre = 1;
		int mid = 2;
		//这里修改为int cur = 2;
		int cur = 0;
		//这里修改为int i = 4; 就可以了
		for(int i = 3; i <= n; i++) {
			cur = pre + mid;
			pre = mid;
			mid = cur;
		}
		return cur;
	}*/
}
