package TOP200;

import java.util.Stack;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 7, 2021 1:24:02 PM
*/
public class NC52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//高，实在是高!这样可以少写一段判断!!!
	public boolean isValid (String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				stack.push(')');
			}else if(chars[i] == '{') {
				stack.push('}');
			}else if(chars[i] == '[') {
				stack.push(']');
			}else if(stack.isEmpty() || stack.pop() != chars[i]) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
