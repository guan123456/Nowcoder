package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			for(int i = 0; i < n; i++) {
				//这里统一成小写处理更好
				//String string = scanner.next();
				String string = scanner.next().toLowerCase();
				//还是用key，value比较好
				//List<Integer[]> list = new ArrayList<Integer[]>();
				//for(int j = 0; j < string.length(); j++) {}
				int result = Method(string);
				System.out.println(result);
			}
		}
	}
	
	public static int Method(String str) {
		int[] arr = new int[26];
		for(int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		Arrays.sort(arr);
		int result = 0;
/*		int Weight = 26;
		for(int i = 25; i >= 0; i--) {
			if(arr[i] != 0) {
				result += Weight * arr[i];
				Weight--;
			}
		}*/
		int weight = 1;
		for(int i = 0; i < 26; i++) {
			if(arr[i] != 0) {
				result += weight * arr[i];
				weight++;
			}else {
				weight++;
			}
		}
		return result;
	}

}
