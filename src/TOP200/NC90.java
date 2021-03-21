package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 15, 2021 4:52:43 PM
*/

import java.util.ArrayList;

public class NC90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	ArrayList<Integer> res = new ArrayList<>();
	public int[] getMinStack(int[][] op) {
		for(int i = 0; i < op.length; i++) {
			if(op[i][0] == 1) {
				list.add(op[i][1]);
			}else if(op[i][0] == 2) {
				list.remove(list.size()-1);
			}else if(op[i][0] == 3) {
				res.add(getMin(list));
			}
		}
		int[] array = new int[res.size()];
		for(int i = 0; i < res.size(); i++) {
			array[i] =res.get(i);
		}
		return array;
	}

	public int getMin(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		for(int val : list) {
			if(min > val) {
				min = val;
			}
		}
		return min;
	}
}
