package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 9, 2021 10:56:36 AM
*/
public class NC1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solve(String s, String t) {
		if(s==null || s.length() == 0) {
			return t;
		}
		if(t==null || t.length()==0) {
			return s;
		}
		int sIndex = s.length() - 1;
		int tIndex = t.length() - 1;
		int m1=0;
		int m2=0;
		int carry = 0;
		StringBuffer sBuffer = new StringBuffer();
		while(sIndex >= 0 || tIndex >= 0) {
			if(sIndex >= 0) {
				m1 = s.charAt(sIndex)-'0';
			}else {
				m1 = 0;
			}
			if(tIndex >= 0) {
				m2 = t.charAt(tIndex)- '0';
			}else {
				m2 = 0;
			}
			int sum = m1 + m2 + carry;
			carry = sum/10;
			sBuffer.append((char)((sum%10)+'0'));
			sIndex--;
			tIndex--;
		}
		if(carry != 0) {
			sBuffer.append('1');
		}
		sBuffer.reverse();
		return sBuffer.toString();
	}
}
