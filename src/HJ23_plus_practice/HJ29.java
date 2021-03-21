package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 1, 2021 6:25:57 PM
*/
import java.util.*;
public class HJ29 {
	//需不需要转化成char来比较呢？
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String stringEncode = scan.nextLine();
			String stringDecode = scan.nextLine();
			Encode(stringEncode);
			Decode(stringDecode);
		}
		
	}
	
	//这里重复过多，可以拆成两个函数
	public static void Encode(String strEncode) {
		//这里还可以做优化
		//char[] chars = strEncode.toCharArray();
		StringBuffer newStr = new StringBuffer();
		for(int i = 0; i < strEncode.length(); i++) {
			if(strEncode.charAt(i) >= 'a' && strEncode.charAt(i) < 'z') {
				newStr.append((char)(strEncode.charAt(i) - 31));
			}else if(strEncode.charAt(i) == 'z') {
				newStr.append('A');
			}else if(strEncode.charAt(i) >= 'A' && strEncode.charAt(i) < 'Z') {
				newStr.append((char)(strEncode.charAt(i) + 33));
			}else if(strEncode.charAt(i) == 'Z') {
				newStr.append('a');
			}else if(strEncode.charAt(i) >= '0' && strEncode.charAt(i) < '9') {
				newStr.append((char)(strEncode.charAt(i) + 1));
			}else if(strEncode.charAt(i) == '9') {
				newStr.append('0');
			}else {
				newStr.append((char)(strEncode.charAt(i)));
			}
		}
		System.out.println(newStr.toString());
	}
	
	//这里重复过多，可以拆成两个函数
	public static void Decode(String strDecode) {
		StringBuffer newStr = new StringBuffer();
		//可以创建一个char数组简化  char[] chars = strDecode.toCharArray();
		for(int i = 0; i < strDecode.length(); i++) {
			if(strDecode.charAt(i) > 'a' && strDecode.charAt(i) <= 'z') {
				//char数组的话 strDecode.charAt(i) 可写成chars[i]
				//但是两者都需要在计算之后显示转换回char，格式为char(x)
				newStr.append((char)(strDecode.charAt(i) - 33));
			}else if(strDecode.charAt(i) == 'a') {
				newStr.append('Z');
			}else if(strDecode.charAt(i) > 'A' && strDecode.charAt(i) <= 'Z') {
				newStr.append((char)(strDecode.charAt(i) + 31));
			}else if(strDecode.charAt(i) == 'A') {
				newStr.append('z');
			}else if(strDecode.charAt(i) > '0' && strDecode.charAt(i) <= '9') {
				newStr.append((char)(strDecode.charAt(i) - 1));
			}else if(strDecode.charAt(i) == '0') {
				newStr.append('9');
			}else {
				newStr.append((char)(strDecode.charAt(i)));
			}
		}
		System.out.println(newStr.toString());
	}
}
