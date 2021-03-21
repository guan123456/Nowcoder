package NC105;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 23, 2021 4:47:58 PM
*/
public class Upper_bound__ {

    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int right = n - 1;
        int left = 0;
        int middle = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(a[mid] >= v){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left + 1;
    }
}
