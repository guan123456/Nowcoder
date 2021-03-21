package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//method 1
		while(scanner.hasNextInt()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(a+b);
		}
		
		//method 2
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			String[] inputArray = input.split(" ");
			System.out.println(Integer.parseInt(inputArray[0]) + Integer.parseInt(inputArray[1]));
		}
	}

}
