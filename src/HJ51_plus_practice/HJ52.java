package HJ51_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 6, 2021 11:37:20 AM
*/
import java.util.*;
public class HJ52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String strA = scanner.next();
			String strB = scanner.next();
//			int ic = 1;
//			int dc = 1;
//			int rc = 1;
//			int cost = strEditCost(strA, strB, ic, dc, rc);
			int cost = dp2(strA, strB);
			System.out.println(cost);
		}
	}
	//借鉴蓝天萝卜的做法
	public static int strEditCost(String strA, String strB, int ic, int dc, int rc) {
		int m = strA.length();
		int n = strB.length();
		//使用了二维数组
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			dp[0][i] = i*ic;
		}
		for(int i = 1; i <= m; i++) {
			dp[i][0] = i * dc;
		}
		//关键在于三个前置变量
		//1和2可以直接获取，它们会随着3的更新而动态更新
		//1.dp[x-1][y-1]
		//2.dp[x][y-1]
		//3.dp[x-1][y]
		for(int x = 1; x <= m; x++) {
			for(int y = 1; y <= n; y++) {
				//这里可以直接赋值就行了
				int cost1 = dp[x-1][y] + dc;
				int cost2 = dp[x][y-1] + ic;
				int cost3 = 0;
				//如果A中第x个字符与B中第y个字符相等
				if(strA.charAt(x-1) == strB.charAt(y-1)) {
					cost3 = dp[x-1][y-1];
				//如果A中第x个字符与B中第y个字符不相等
				}else {
					cost3 = dp[x-1][y-1] + rc;
				}
				dp[x][y] = Math.min(cost1, cost2);
				dp[x][y] = Math.min(dp[x][y], cost3);
				//把这里改一下就可以对应下面了
//				int cost1 = dp[x-1][y];
//				int cost2 = dp[x][y-1];
//				int cost3 = dp[x-1][y-1];
//				//如果A中第x个字符与B中第y个字符相等
//				if(strA.charAt(x-1) == strB.charAt(y-1)) {
//					cost3 = dp[x-1][y-1]-1;
//				//如果A中第x个字符与B中第y个字符不相等
//				}
//				dp[x][y] =1+ Math.min(Math.min(cost1, cost2), cost3);
			}
		}
		return dp[m][n];
	}
	
	//动态规划使用一维数组的情况
	//dp[x-1][y-1]拷贝到了dp[x][y]上
	//动态更新dp[x][y]，最后要求得dp[x-1][y-1]，直接获取dp[x][y]即可
	//所以数组大小要lenB + 1;
	public static int dp2(String strA, String strB) {
		int lenA = strA.length();
		int lenB = strB.length();
		//使用了一维数组
		int[] record = new int[lenB + 1];
		for(int i = 0; i <= lenB; i++) {
			record[i] = i;
		}
		for(int x = 1; x <= lenA; x++) {
			//lu存储dp[x-1][y-1],也就是二维数组左上角那个数
			int lu = record[0];
			//哦哦哦，这里不是A匹配B
			//是编辑距离，也就是相互的，所以record[0]要赋值x
			record[0] = x;
			//卡了半天的原因
			//1.k= 原record[y]
			//2.record[y]改变
			//(lu有可能有操作)
			//3.lu = k，也就是k = 原record[y]
			//下一循环
			//4.k= 原record[y+1] 
			//5.(lu有可能有操作,未操作前还是等于上一循环的原record[y])
			//6.lu = k，也就是k = 原record[y+1]
			//终于理解了一维数组存储不了二维数组左上角的dp[x-1][y-1]了
			//这里是固定x(行),移动y(列),也就是从左到右
			//record[y]相当于dp[x-1][y]
			//record[y-1]相当于dp[x][y-1]
			//lu则动态存储dp[x-1][y-1]
			//费了那么多时间去思考，还不如画个矩阵一目了然！！！
			//因为是从上到下，从左到右，那么每到下一行，前面一行的record已经更新了
			//所以当走到(x,y)时，对应的record(y-1)及之前都已更新了
			//故而，record(y-1)可以表示dp[x][y-1],record(y)可以表示dp[x-1][y]
			//而dp[x-1][y-1]无法用record表示，故而需要用额外的变量存储与表示
			//-------------record(y-1),record(y),record(y+1)---------record(lenB)
			//-------------------------------------------------------------------
			//-------------(x-1 , y-1),(x-1 , y),--------------------------------
			//-------------(x   , y-1),(x   , y),--------------------------------
			//-------------------------------------------------------------------
			//-------------------------------------------------------------------
			for(int y = 1;  y <= lenB; y++) {
				//获取dp[x-1][y-1]并赋值给k
				//先保存record[y]以便下次赋值给lu
				int k = record[y];
				//如果A中第x个字符与B中第y个字符相等
				//先对lu减1
				if(strA.charAt(x-1) == strB.charAt(y-1)) {
					lu -= 1;
				}
				//这一步覆盖，也就是本来下一层循环使用record[y-1]得到应该是dp[x-1][y-1]
				//但是有了这一步，下一层循环使用record[y-1]得到的是dp[x][y-1]
				record[y] = 1 + Math.min(record[y],Math.min(record[y-1], lu));
				//保存当前层dp[x][y]，下一层就表示了dp[x-1][y-1]
				lu = k;
			}
		}
		return record[lenB];
	}
}
