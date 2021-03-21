package HJ23_plus_practice;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 2, 2021 12:54:32 PM
*/
public class HJ34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//一开始以为分成三部分排序并拼接在一起
		//1.数字
		//2.大写字母
		//3.小写字母
		//但是实际上，本题可以说是排序题
		//只不过是以ASCII的大小作为排序逻辑
		//Arrays.sort()函数可以直接排序，太苟了
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String string = scanner.nextLine();
			char[] chars = string.toCharArray();
			Arrays.sort(chars);
			System.out.println(chars);
		}
	}

}
