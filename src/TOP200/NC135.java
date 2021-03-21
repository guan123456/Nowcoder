package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 18, 2021 5:05:54 PM
*/
import java.util.*;

public class NC135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int n = prices.length;
		if(n < 2) {
			return 0;
		}
		int[] p = new int[n];
		int max = prices[n-1];
		p[n-1] = 0;
		for(int i = n - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			p[i] = Math.max(p[i+1],max-prices[i]);
		}
		int res = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n - 1; i++) {
			min = Math.min(min, prices[i]);
			res = Math.max(res, prices[i]-min + p[i+1]);
		}
		return res;
	}
}
