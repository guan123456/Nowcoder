package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 8, 2021 12:01:39 PM
*/
public class NC127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String LCS(String str1, String str2) {
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
			return "";
		}
		int indexMax = 0;
		int maxLen = 0;
		int m = str1.length();
		int n = str2.length();
		
		////dp[i][j]代表 str1[0~i-1]和str2[0~j-1] 的最长公共子串的长度
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					if(i == 0 || j == 0) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = dp[i-1][j-1] + 1;
					}
				}else {
					dp[i][j] = 0;
				}
				//处理完dp[i][j]之后,查看一下是否需要记录下来
				//indexMax表示最长公共子串的结尾字符
				if(maxLen < dp[i][j]) {
					maxLen = dp[i][j];
					indexMax = i;
				}
			}
		}
		//如果没有公共的
		if(maxLen == 0) {
			return "";
		}
		//字符串截取的长度有(end-start+1) = maxLen, 那么start = indexMax +1-maxLen
        // maxLen即为所截取的字符串的长度。
		return str1.substring(indexMax-maxLen+1,indexMax+1);
	}
}
