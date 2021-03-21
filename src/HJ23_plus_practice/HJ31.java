package HJ23_plus_practice;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 2, 2021 12:54:32 PM
*/
public class HJ31 {

	//这道题有个坑,你需要除去字符串首尾的空格!
	//当输入字符串是空格开头时，输出的字符串最后面会有空格
	//所以在输出前把左右两边空格除去
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String string = scanner.nextLine();
			//将输入的不规则句子（存在多个空格相隔）转化成只有一个空格间隔的句子
			char[] charArray = string.toCharArray();
			StringBuffer sBuffer = new StringBuffer();
			//(XX)int temp = 0;//记录新单词之间有多少个空格
			for(int i = 0; i < charArray.length; i++) {
				if(JudgeLetter(charArray[i])) {
					sBuffer.append(charArray[i]);
					//这里需要加判断(i-1) >= 0 && JudgeLetter(charArray[i-1])!!!!!
				}else if((i-1) >= 0 && JudgeLetter(charArray[i-1]) &&(i + 1) < charArray.length && JudgeLetter(charArray[i+1])) {
					sBuffer.append(" ");
					//(XX)temp++;
				}
			}
			
			//(XX)char[] chars = new char[2*temp + 1];
			//直接先将sBuffer转成string然后再转成char数组即可
			//最终的目的都是为了可以转成char数组
			char[] chars = sBuffer.toString().toCharArray();
			//重头戏
			int start = 0;
			int end = 0;
			reverseCharArray(chars, 0, chars.length - 1);
			while(start < chars.length - 1) {
				while(end < chars.length && chars[end] != ' ') {
					end++;
				}
				reverseCharArray(chars, start, end - 1);
				start = ++end;
			}
			System.out.print(chars);
			System.out.println();
		}
	
	}
	
	//利用正则表达式匹配的简介方法
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        String[] strArray = scanner.nextLine().split("[^a-zA-Z]+");
        StringBuffer sb = new StringBuffer();
        for(int i = strArray.length - 1; i >= 0; i--){
            sb.append(strArray[i] + " ");
        }
        System.out.println(sb.toString().trim());
	}*/
	public static boolean JudgeLetter(char c) {
		if((c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z')) {
			return true;
		}else {
			return false;
		}
	}
	public static void reverseCharArray(char[] chars,int start,int end) {
		while(start <= end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}
	
	
	
}
