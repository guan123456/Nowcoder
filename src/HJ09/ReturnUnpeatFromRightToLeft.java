package HJ09;
import java.util.*;
import java.util.HashSet;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 24, 2021 3:23:27 PM
*/
public class ReturnUnpeatFromRightToLeft {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		//使用StringBuffer可以改变字符串
		StringBuffer sBuffer = new StringBuffer(string);
		//Set是一个接口，而HashSet是一个类。
		//HashSet继承并实现了Set。Set set  = new HashSet();
		//这句创建了一个HashSet的对象后把上溯到了Set。
		//此时它是一个Set引用了，有些HashSet有但是Set没有的属性和方法，它就不能再用了。
		//如果没有特别需求的话,最好使用Set set= new HashSet();
		//便于程序代码的重构. 这就是面向接口编程的好处。
		//如果是写共通类共通方法的话，建议少用特性，多用面向接口。
		sBuffer.reverse();
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < sBuffer.length();i++) {
			//在调用Set.add()方法向Set中添加元素的时候需要进行判断，如果添加的元素重复的话将返回false。
			if(set.add(sBuffer.substring(i, i+1))) {
				System.out.print(sBuffer.substring(i,i+1));
			}
		}
	}
}
