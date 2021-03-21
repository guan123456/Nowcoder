package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//这里写成scanner.hasNextLine()真是害人不浅!!!
		while(scanner.hasNext()) {
			String string = scanner.next();
			int n = scanner.nextInt();
/*			char[] chars = string.toCharArray();
			int i = 0;
			int count = 0;
			for(int j = 0; j < chars.length; j++) {
				if(chars[j] > 128) {
					count += 2;
					if(count < n) {
						i++;
					}
				}else {
					count++;
					if(count <= n) {
						i++;
					}
				}
			}
			System.out.println(string.substring(0,i));*/
			StringBuffer sBuffer = new StringBuffer();
			if(n > string.length()) {
				System.out.println("");
			}else {
				for(int i = 0; i < n; i++) {
					sBuffer.append(string.charAt(i));
				}
				System.out.println(sBuffer.toString());
			}
		}
	}

}
