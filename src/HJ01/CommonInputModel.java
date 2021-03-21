package HJ01;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 23, 2021 7:31:33 PM
*/
public class CommonInputModel {
	
	

	//Type 1
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String string = scanner.nextLine();
			System.out.println(lengthOfLast(string));
		}
	}
	
	public static int lengthOfLast(String str) {
		String[] strings = str.split(" ");
		return strings[strings.length - 1].length();
	}*/
	
	/*
	 * 
	 * nextInt()读取结果为一个int类型数据，返回int值

     * nextFloat()读取结果为float类型，返回float值

     * next()读取结果为String类型,返回string类型

     * nextLine()读取结果为String类型,返回string类型
	 */
	//Type 2
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//nextLine()方法的结束符只是Enter键，即nextLine()方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的.
		//如果有两行或者多行输入，则可以分别 String a = scanner.nextLine();
		//String b = scanner.nextLine();等等
		String line = scanner.nextLine();
		String[] arr = line.split(" ");
		System.out.println(arr[arr.length - 1].length());
	}

}
