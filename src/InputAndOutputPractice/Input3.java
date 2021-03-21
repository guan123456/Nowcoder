package InputAndOutputPractice;

import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 26, 2021 6:16:32 PM
*/
public class Input3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String string = scanner.nextLine();
			String[] strArray = string.split(" ");
			if(Integer.parseInt(strArray[0])==0 && Integer.parseInt(strArray[1]) == 0) {
				break;
			}else {
				System.out.println(Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[1]));
			}
		}
	}

}
