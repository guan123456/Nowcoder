package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 7, 2021 1:06:28 PM
*/
public class NC22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void merge(int[] A,int m,int[] B,int n) {
		//特殊用例
		if(m == 0) {
			for(int k = 0; k < B.length; k++) {
				A[k] = B[k];
			}
		}else {
			int i = m - 1;
			int j = n - 1;
			int s = m + n - 1;
			while(j >= 0 && i >= 0) {
				if(A[i] > B[j]) {
					A[s--] = A[i--];
				}else {
					A[s--] = B[j--];
				}
			}
			if(i == -1) {
				for(;j >= 0; j--) {
					A[j] = B[j];
				}
			}
		}
/*		for(int i = m + n - 1; i >= 0; i--) {
			
		}*/
	}
}
