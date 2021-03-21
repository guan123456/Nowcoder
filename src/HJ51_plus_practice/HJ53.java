package HJ51_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 6, 2021 11:37:20 AM
*/
import java.util.*;
public class HJ53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			if(n <= 2) {
				System.out.println(-1);
			}else if(n % 2 == 1) {
				System.out.println(2);
			}else if(n % 4 == 0) {
				System.out.println(3);
			}else {
				System.out.println(4);
			}
		}
	}

}
