package HJ51_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 6, 2021 7:00:58 PM
*/
import java.util.*;
public class HJ55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			String string;
			int count = 0;
			for(int i = 1; i <= n; i++) {
				string = String.valueOf(i);
				if(string.contains("7") || i % 7 == 0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
