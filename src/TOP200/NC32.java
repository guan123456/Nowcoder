package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 9, 2021 11:21:42 AM
*/
public class NC32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sqrt(int x) {
		return (int)Math.sqrt(x);
	}
	
	//连续n个奇数相加的结果一定是平方数
	//所以，不断的进行奇数相加，并判断x大小即可
	public int sqrt_1(int x) {
		int i = 1;
		int res = 0;
		while(x >= 0) {
			x -= i;
			res++;
			i += 2;
		}
		return res-1;
	}
	//这里有点迷糊
	public int sqrt_2(int x) {
		long i = 1;
		while(i * i < x) {
			i *= 2;
		}
		while(i * i > x) {
			i = i - 1;
		}
		return (int)i;
	}
}
