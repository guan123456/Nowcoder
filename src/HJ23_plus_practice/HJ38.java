package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 3, 2021 3:51:10 PM
*/
import java.util.*;
public class HJ38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			double distance = 3 * n - ((double)n/8);
			double high = ((double)n/32);
			System.out.println(distance);
			System.out.println(high);
		}
	}

}
