package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 16, 2021 1:09:43 PM
*/
public class NC144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//哦对了，数组中元素有可能是负数的,这样的话就比较复杂了
	//动态规划
	/*
	 * 每个位置有两个状态， 拿或者不拿 
     * 拿当前位置时， 最大值只能从 不拿上一个位置 转移来
     * 不拿当前位置时，最大值可以从 不拿上一个位置 和 拿上一个位置 转移
	 */
	public long subsequence(int n, int[] array) {
		long res = 0;
		long a = 0;
		long b = 0;//因为dp[i]只与dp[i-1]和dp[i-2]有关，所以分别定义两个数表示dp[i-1]和dp[i-2];
		for(int x : array) {
			long c = Math.max(a+x, b);//相当于dp[i]=max(dp[i-1],dp[i-2]+array[i]);
			a = b;
			b = c;
		}

		return res;
	}
	
	//更好理解的方式
	public long subsequence_1(int n, int[] array) {
        if(n==1){
            return array[0];
        }
        if(n==2){
            return Math.max(array[0],array[1]);
        }
        int[] dp = new int[n];
        dp[0] = array[0];
        dp[1] = array[1];
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i-1],+dp[i-2] + array[i]);
		}
		return dp[n-1];
	}
}
