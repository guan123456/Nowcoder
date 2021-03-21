package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 11, 2021 12:35:18 PM
*/
import java.util.*;
public class NC54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> threeSum(int[] num){
		if(num.length < 3) {
			return result;
		}
		int curSum = 0;
		int start = num[0];
		int end = num[1];
		Arrays.sort(num);
		//这里有两层去重，第一层是固定位的去重，第二层是其他两数的去重
		for(int i = 0; i < num.length - 2; i++) {
			//第一层去重，固定位去重
			if(i != 0 && num[i] == num[i-1]) {
				continue;
			}
			start = i + 1;
			end = num.length-1;
			while(start < end) {
				curSum = num[start] + num[end];
				if(curSum + num[i] == 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[start]);
					list.add(num[end]);
					result.add(list);
					start++;
					end--;
					//第二层去重，其他两数的去重
					while(start < end && num[start] == num[start-1]) {
						start++;
					}
					while(start < end && num[end] == num[end+1]) {
						end--;
					}
				}else if(curSum + num[i] < 0) {
					start++;
				}else {
					end--;
				}
			}
		}
		return result;
	}

}
