package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input5 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);
	//int n = scanner.nextInt();也对
	int n = Integer.parseInt(scanner.nextLine());
	for(int i = 0; i < n; i++) {
		int total = scanner.nextInt();
		int sum = 0;
		for(int j = 0; j < total; j++) {
			sum += scanner.nextInt();
		}
		System.out.println(sum);

}
}

}
