package HJ08;
import java.util.*;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 24, 2021 2:53:22 PM
*/
public class MergeTable {

	//使用next()方法时，将空格看作是两个字符串的间隔
	//使用nextInt()方法时，与next()方法类似，只是它的返回值是int类型的，依旧将空格看作是两个输入的数据的间隔
	//（当使用nexInt()方法时，只能输入int类型的数据。）
	//nextInt()不会读取换行符；next()划分每个元素的标准是：空格、制表符、或者换行符。
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
			int n = scanner.nextInt();
			for(int i = 0; i < n; i++) {
				int key = scanner.nextInt();
				int value = scanner.nextInt();
				if(map.containsKey(key)) {
					map.put(key, map.get(key) +value);
				}else {
					map.put(key, value);
				}
			}
			//这里要用Integer 而不是 int，map.keySet()可以对map实现遍历
			for(Integer key : map.keySet()) {
				System.out.println(key + " " + map.get(key));
			}
		}

	}
}
