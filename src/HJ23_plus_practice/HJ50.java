package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ50 {

	private static Stack<Character> stack = new Stack<>();//辅助栈
	private static StringBuilder output = new StringBuilder();//输出框，用于表示后缀表达式
	private static ArrayList<Integer> digitCount = new ArrayList<>();//存储对应的运算数位数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			//可以先将其他类型的括号转化为统一括号
			//比如[],{}转换成()
			//本题将转变成中缀表达式求值
			String string = scanner.nextLine();
			String infixExpression = string.replace('{', '(').replace('}', ')')
					.replace('[', '(').replace(']', ')');
			char[] chars = infixExpression.toCharArray();
			String suffixExpression = infixTransToSuffix(chars);
			System.out.println(cal(suffixExpression));
		}
	}
	
	//将中缀表达式转化为后缀表达式
	public static String infixTransToSuffix(char[] chars) {
		//从左到右扫描每一个字符
		for(int i = 0;i < chars.length; i++) {
			//如果扫描到的是数字
			if(Character.isDigit(chars[i])) {
				int temp = 0;
				//可能该数字有几位数字
				while(i < chars.length && Character.isDigit(chars[i])) {
					//存储运算数
					output.append(chars[i]);
					//这里的i改变对整个for循环都有用
					i++;
					temp++;
				}
				//这里需要i--因为回到循环中i++了
				i--;
				digitCount.add(temp);
				//如果是右括号直接压栈
			}else if(chars[i] == '(') {
				stack.push(chars[i]);
				//如果是'-'或者'+'，它们是最低优先级的运算了
			}else if(chars[i] == '+' || chars[i] == '-') {
				//如果当前'-'表示的是负号
				//那么可以加一个0-的操作，并记录下来
				//这里有可能有数组越界-1,所以需要更改一下
				//原if(chars[i] == '-' && chars[i-1] == '(')
				if(chars[i] == '-' && (i==0 || chars[i-1] == '(')) {
					output.append('0');
					digitCount.add(1);
				}
				//如果栈为空,则需要将栈中元素弹出，直到该操作符的优先级大于栈顶元素的优先级
				//当前是'-'或'+'，是最低优先级，故把栈中操作数全部出栈即可
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'
						|| stack.peek() == '+' || stack.peek() == '-')) {
					output.append(stack.pop());
				}
				//把当前操作数入栈
				stack.push(chars[i]);
				//类似如上
			}else if(chars[i] == '*' || chars[i] == '/') {
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					output.append(stack.pop());
				}
				stack.push(chars[i]);
			}else {
				//如果遇到的是栈顶是左括号'(',就直接出栈，直到不是左括号'('才停止出栈
				//因为output是不存储括号的
				while(!stack.isEmpty() && stack.peek() != '(') {
					output.append(stack.pop());
				}
				stack.pop();
			}
		}
		//输入的中缀表达式已经扫描完了，但是堆栈中仍然存在操作符的时候
		//我们应该讲堆栈中的操作符导出并输入到output 当中
		while(!stack.isEmpty()) {
			output.append(stack.pop());
		}
		return output.toString();
	}

	//后缀表达式的计算
	public static int cal(String output) {
		int index = 0;
		Stack<Integer> stack1 = new Stack<Integer>();
		char[] chars = output.toCharArray();
		//从左到右扫描
		for(int i = 0; i < chars.length; i++) {
			//遇到数字压栈
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
				//把下标往前移动，以便获取下一个数字的位数
				index++;
				//遇到操作符，弹出栈顶的两个元素，先弹出的元素在右边，后弹出的元素在左边
				//进行计算后，将结果压栈，再往后扫描，直到扫描结束，栈顶元素即为最终结果
			}else {
				int num1 = stack1.pop();
				int num2 = stack1.pop();
				if(chars[i] == '+') {
					stack1.push(num1+num2);
				}else if(chars[i] == '-') {
					stack1.push(num2 - num1);
				}else if(chars[i] == '*') {
					stack1.push(num1 * num2);
				}else {
					stack1.push(num2/num1);
				}
			}
		}
		return stack1.pop();
	}
}
