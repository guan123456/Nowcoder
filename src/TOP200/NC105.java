package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 7, 2021 12:53:23 PM
*/
public class NC105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(int[] nums, int target) {
		int index = -1;
		int start = 0;
		int end = nums.length-1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				index = mid;
				end = mid - 1;
			}else if(target > nums[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return index;
	}
	
/*	public int binarySearch(int target ,int start,int end,int[] nums) {
		if(start > end) {
			return -1;
		}else {
			int mid = start + (end - start) / 2;
			if(target >nums[start]) {
				
			}
		}
	}*/
}
