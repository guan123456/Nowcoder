package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 16, 2021 1:47:45 PM
*/
import java.util.*;
public class NC141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean judge(String str) {
		int len = str.length();
		for(int i = 0; i < len/2; i++) {
			if(str.charAt(i)!=str.charAt(len-1-i)) {
				return false;
			}
		}
		return true;
	}
}
