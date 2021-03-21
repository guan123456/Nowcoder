package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			String[] strArray = str.split(" ");
			int sum = 0;
			for(int i =0; i < strArray.length; i++) {
				sum += Integer.parseInt(strArray[i]);
			}
			System.out.println(sum);
		}
	}

}
