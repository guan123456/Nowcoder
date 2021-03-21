package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			//这个题目的and的位置着实让人有点抓狂，题目的意思是只有百位之后才有and
			//如果百位上为0，就不加用and了。
			//实际上正常的话是要加and的，
			//2016按照题目的意思就是two thousand sixteen
			//但我觉得按照英语说法的习惯，two thousand and sixteen要更好一些。
			//这种办法比较繁杂，还是算了
			//String longNum = scanner.nextLine();
			//char[] chars = longNum.toCharArray();
			long num = scanner.nextLong();
			System.out.println(DigitToEnglish(num));
		}
	}
	public static String[] num1 = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	public static String[] num2 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen","seventeen", "eighteen", "nineteen" };
	public static String[] num3 = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty","ninety" };
	public static int BILLION = 1000000000;
	public static int MILLION = 1000000;
	public static int THOUSAND = 1000;
	public static String DigitToEnglish(long num) {
		if(num < 0) {
			return "error";
		}
		StringBuffer result = new StringBuffer();
		long billion = num / BILLION;//十亿部分
		if(billion != 0) {
			result.append(trans(billion) + " billion ");
		}
		num %= BILLION;
		
		long million = num / MILLION;//百万部分
		if(million != 0) {
			result.append(trans(million) + " million ");
		}
		num %= MILLION;
		
		long thousand = num / THOUSAND;//千部分
		if(thousand != 0) {
			result.append(trans(thousand) + " thousand ");
		}
		num %= THOUSAND;
		
		if(num != 0) {//余下部分
			result.append(trans(num));
		}
		return result.toString().trim();//最后去除字符串后面的空格
	}
	
	public static String trans(long num) {
		StringBuffer sBuffer = new StringBuffer();
		long hundred = num / 100; //百位处理
		if(hundred != 0) {
			//num1从zero开始存，而刚好数组下标从0开始
			sBuffer.append(num1[(int) hundred] + " hundred");
		}
		num %= 100;
		
		long Ten = num / 10;//十位处理
		if(Ten != 0) {
			if(hundred != 0) {//若有百位，则加上“and”
				sBuffer.append(" and ");
			}
			if(Ten == 1) {
				//num2从ten开始，刚好数组下标从0开始
				sBuffer.append(num2[(int)(num % 10)]);
			}else {
				//这里为什么减2，是因为数组下标从0开始，且num3从twenty开始存，所以3-2 = 1，代表thirty
				sBuffer.append(num3[(int)(Ten - 2)] + " ");
				if(num % 10 != 0) {
					//num1从zero开始存，而刚好数组下标从0开始
					sBuffer.append(num1[(int)(num % 10)]);
				}
			}
		}else if(num % 10 != 0) {//如果没有十位的部分，则直接翻译个位部分，比如：102
			if(hundred != 0) {
				sBuffer.append(" and ");
			}
			sBuffer.append(num1[(int)(num % 10)]);
		}
		return sBuffer.toString().trim();//去掉前后空格
	}

}
