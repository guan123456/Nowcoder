package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 3, 2021 3:51:10 PM
*/
import java.util.*;
public class HJ40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String string = scanner.nextLine();
			int letter = 0;
			int blank = 0;
			int number = 0;
			int other = 0;
			for(int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if(Character.isLetter(c)) {
					letter++;
				}else if(Character.isDigit(c)){
					number++;
					//这里还可以写成c == ' '
				}else if(Character.isWhitespace(c)) {
					blank++;
				}else {
					other++;
				}
			}
			System.out.println(letter);
			System.out.println(blank);
			System.out.println(number);
			System.out.println(other);
		}
		
	}

}
