package HJ23_plus_practice;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 2, 2021 12:54:32 PM
*/
public class HJ33 {

	//int类型的取值范围为： -2^31 到 2^31-1
	//所以本道题只能使用long类型而不能使用int类型
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String string = scanner.nextLine();
			long n = Long.parseLong(scanner.nextLine());
			IPTranlateToDecimal(string);
			DecimalTranslateToIP(n);
			
		}
	}
	public static void IPTranlateToDecimal(String str) {
		//这里不应该这样划分
		//(x)String[] strArray = str.split(".");
		String[] strArray = str.split("\\.");
		StringBuffer binary = new StringBuffer();
		for(int i = 0; i < strArray.length; i++) {
			binary.append(DecimalTranslateToBinary(Integer.parseInt(strArray[i])));
		}
		String newStr = binary.toString();
		long res = Long.parseLong(newStr,2);
		System.out.println(res);
	}
	
	//将十进制数转化为8位2进制数
	public static String DecimalTranslateToBinary(int num) {
		StringBuffer sBuffer = new StringBuffer();
		int k = 1 << 7;
		int flag;
		for(int i = 0; i < 8; i++) {
			flag = ((num & k) == 0 ? 0 : 1);
			sBuffer.append(flag);
			k = k >> 1;
		}
		return sBuffer.toString();
	}
	
	public static void DecimalTranslateToIP(long n) {
		StringBuffer newIP = new StringBuffer();
		//String[] temp = new String[4];
		//int index = 0;
		//移动k有问题 1<<31 的返回值是负数 具体值为-231
		//int类型的取值范围为： -2^31 到 2^31-1
		//神奇操作！！！long k = 1 << 31; k的值却为-2147483648
		long k = 1;
		k = k << 31;
		int flag;
		StringBuffer binary = new StringBuffer();
		for(int i = 1; i <= 32; i++) {
			flag = ((n & k) == 0 ? 0 : 1);
			binary.append(flag);
			k = k >> 1;
			//下面方式复杂了
/*			if(i > 0 && i % 8 == 0) {
				temp[index] = (binary.substring(i-8, i)).toString();
				index++;
			}*/
		}
		for(int i = 8; i <= 32; i+=8) {
			int decimal = BinaryTranslateToDecimal((binary.substring(i-8, i)).toString());
			if(i < 32) {
				newIP.append(decimal + ".");
			}else {
				newIP.append(String.valueOf(decimal));
			}
		}
		System.out.println(newIP.toString());
	}
	
	public static int BinaryTranslateToDecimal(String str) {
		int result = Integer.parseInt(str,2);
		return result;
	}
}
