package HJ23_plus_practice;

import java.util.Scanner;


/**
* @author 作者:guan
* @createDate 创建时间：Feb 27, 2021 12:10:05 PM
*/
public class HJ23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			int[] array = new int[26];
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < str.length(); i++) {
				//这里直接array[str.charAt(i)-97]也行
				if(array[(int)str.charAt(i) - 97] != 0) {
					array[(int)str.charAt(i) - 97]++;
					//我写错在这里，这里应该是else，而不是每一次都要执行！！！
				}else {
					array[(int)str.charAt(i) - 97] = 1;
				}

			}
			for(int i = 0; i < array.length; i++) {
				if(array[i] < min && array[i] != 0) {
					min = array[i];
				}
			}
			for(int i = 0; i < str.length(); i++) {
				if(array[(int)str.charAt(i) - 97] > min) {
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
