package NC88;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 23, 2021 5:17:22 PM
*/
public class FindKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//题目要求的是第K大，我日了！！！
	//我潜意识里是觉得是第K小！！！
	//那么这个快速排序得改一改了
	   public int findKth(int[] a, int n, int K) {
	        // write code here
	        int start = 0;
	        int end = a.length - 1;
	        int index = partition(a,start,end);
	        while(index != K - 1){
	            if(index < K - 1){
	                start = index + 1;
	                index = partition(a,start,end);
	            }else{
	                end = index - 1;
	                index = partition(a,start,end);
	            }
	        }
	        return a[index];
	        
	    }
	    private int partition(int[] arr, int start, int end){
	        int pivotKey = arr[start];
	        while(start < end){
	            while(start < end && arr[end] <= pivotKey){
	                end--;
	            }
	            arr[start] = arr[end];
	            while(start < end && arr[start] >= pivotKey){
	                start++;
	            }
	            arr[end] = arr[start];
	        }
	        arr[start] = pivotKey;
	        return start;
	    }
}
