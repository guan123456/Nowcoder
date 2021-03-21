package HJ23_plus_practice;
import java.awt.RenderingHints.Key;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 3, 2021 3:51:10 PM
*/
import java.util.*;
public class HJ36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			//这里没错，就是我自己手贱在nihao后多敲了一个空格！！！所以length变成了6！！！
			String key = scanner.nextLine().toLowerCase();
			String neededEncode = scanner.nextLine();
			System.out.println(Method(key, neededEncode));
		}
	}
	public static String Method(String str,String neededEncode) {
		char[] letter = new char[26];
		//boolean[] add = new boolean[26];
		//StringBuffer repeat = new StringBuffer();
		int temp = 0;//标记letter下标temp前的数字都已经填有字母
		
		//我靠，字符为nihao的length居然是6而不是5!!!
		//nextLine()函数的坑
		int length = str.length();
		for(int i = 0; i < str.length(); i++) {
			boolean flag = false;
			//这里其实可以再改进，但算了
			for(int j = 0; j < temp; j++) {
				if(letter[j] == str.charAt(i)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				letter[temp] = str.charAt(i);
				//add[str.charAt(i) - 97] = true;
				temp++;
			}
		}
		//这一步忘记排除已经填了的了
		//这里不是i = temp,是i = 0
		for(int i = 0; i < 26; i++) {
			//string = "97" 而不是 string = "a"!!!
			//所以需要强制转换为char
			String string = String.valueOf((char)(i + 'a'));
			if(!str.contains(string)) {
				letter[temp] = (char)(i + 'a');
				temp++;
			}
		}
		StringBuffer inputStr = new StringBuffer();
		for(int i = 0; i < neededEncode.length(); i++) {
			char element = neededEncode.charAt(i);
			if(element >= 'a' && element <= 'z') {
				inputStr.append(letter[element - 'a']);
			}else if(element >= 'A' && element <= 'Z') {
				//这里也是，需要强制转换为char，不然会输出数字！！！
				inputStr.append((char)(letter[element - 'A'] - 'a' + 'A'));
			}else {
				inputStr.append(element);
			}
		}
		return inputStr.toString();
	}

}
