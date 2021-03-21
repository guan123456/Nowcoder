package HJ23_plus_practice;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 2, 2021 12:54:32 PM
*/
public class HJ32 {

	//最好的是manacher算法，但是比较难理解
	//预处理将长度为n的字符串扩展成2n+1，前后以及字符间加特殊字符即可
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String string = scanner.nextLine();
			System.out.println(Process(string));
		}
	}
	
/*  暴力方式一，暴力一次奇数，再暴力一次偶数，取最大值
 * 	public static int Process(String str) {
		int len = str.length();
		if(len < 1) {
			return 0;
		}
		int max = 1;
		//暴力一次奇数
		for(int i = 1; i < len - 1; i++) {
			int k = i - 1;
			int j = i+1;
			int count = 0;
			while(k >= 0 && j <= len - 1) {
				if(str.charAt(k) == str.charAt(j)) {
					count++;
					k--;
					j++;
				}else {
					break;
				}
			}
			max = (max >= count*2 + 1) ? max : (count * 2 + 1);
		}
		//暴力一次偶数
		for(int i = 1; i < len - 1; i++) {
			int k = i - 1;
			int j = i;
			int count = 0;
			while(k >= 0 && j <= len - 1) {
				if(str.charAt(k) == str.charAt(j)) {
					count++;
					k--;
					j++;
				}else {
					break;
				}
			}
			max = (max >= count * 2) ? max : (count * 2);
		}
		return max;
	}*/
	
	//暴力方式二 效率没那么高
	public static int Process(String s) {
		int len = s.length();
		if(len < 1) {
			return 0;
		}
		int maxLen = 1;
		char[] chars = s.toCharArray();
		//重点步骤
		for(int i = 0; i < len - 1; i++) {
			for(int j = i + 1; j < len; j++) {
				if(j - i + 1 > maxLen && valid(chars, i, j)) {
					maxLen = j - i + 1;
				}
			}
		}
		return maxLen;
	}
	
	public static boolean valid(char[] chars,int start,int end) {
		while(start < end) {
			if(chars[start] != chars[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
