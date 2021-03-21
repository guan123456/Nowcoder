package HJ51_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 6, 2021 11:37:20 AM
*/
import java.util.*;
public class HJ54 {

	private static Stack<Character> stack = new Stack<Character>();
	private static StringBuffer output = new StringBuffer();
	private static ArrayList<Integer> digitCount = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String infixExpression = scanner.nextLine();
			char[] chars = infixExpression.toCharArray();
			String suffixExpression = infixTransToSuffix(chars);
			System.out.println(cal(suffixExpression));
		}
	}
	
	public static String infixTransToSuffix(char[] chars) {
		for(int i = 0; i <chars.length; i++) {
			if(Character.isDigit(chars[i])) {
				int temp = 0;
				while(i < chars.length && Character.isDigit(chars[i])) {
					output.append(chars[i]);
					i++;
					temp++;
				}
				i--;
				digitCount.add(temp);
			}else if(chars[i] == '(') {
				stack.push(chars[i]);
			}else if(chars[i] == '+' || chars[i] == '-') {
				//这里有可能有数组越界-1,所以需要更改一下
				//原if(chars[i] == '-' && chars[i-1] == '(')
				if(chars[i] == '-' && (i==0 || chars[i-1] == '(')) {
					output.append('0');
					digitCount.add(1);
				}
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'
						|| stack.peek() == '+' || stack.peek() == '-')) {
					output.append(stack.pop());
				}
				stack.push(chars[i]);
			}else if(chars[i] == '*' || chars[i] == '/') {
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					output.append(stack.pop());
				}
				stack.push(chars[i]);
			}else {
				while(!stack.isEmpty() && stack.peek() != '(') {
					output.append(stack.pop());
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			output.append(stack.pop());
		}
		return output.toString();
	}

	public static int cal(String output) {
		int index = 0;
		Stack<Integer> stack1 = new Stack<Integer>();
		char[] chars = output.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(Character.isDigit(chars[i])) {
				int total = 0;
				int count = digitCount.get(index);
				while(count > 0) {
					total = 10 * total + (chars[i] - '0');
					i++;
					count--;
				}
				i--;
				stack1.push(total);
				index++;
			}else {
				int num1 = stack1.pop();
				int num2 = stack1.pop();
				if(chars[i] == '+') {
					stack1.push(num1+num2);
				}else if(chars[i] == '-') {
					stack1.push(num2-num1);
				}else if(chars[i] == '*') {
					stack1.push(num1*num2);
				}else {
					stack1.push(num2/num1);
				}
			}
		}
		return stack1.pop();
	}
}
