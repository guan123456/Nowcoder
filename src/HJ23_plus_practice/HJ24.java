package HJ23_plus_practice;

import java.util.Scanner;

/**
* @author 作者:guan
* @createDate 创建时间：Feb 27, 2021 12:50:59 PM
*/
public class HJ24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int n = scan.nextInt();
			//判断边界条件，如果少于3个数就没必要排
			if(n <= 2) {
				System.out.println(0);
			}
			int[] members = new int[n];//存储每一个数据元素
			int[] left_queue = new int[n];//数据元素从左到右对应的最大递增子序列数
			int[] right_queue = new int[n];//数据元素从右到左的最大递增子序列数
			for(int i = 0; i < n; i++) {//初始化各个数组数据
				members[i] = scan.nextInt();
				left_queue[i] = 1;
				right_queue[i] = 1;
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(members[i] > members[j] && left_queue[j] + 1 > left_queue[i]) {
						//实时更新left_queue[i]的值
						left_queue[i] = left_queue[j] + 1;
					}
				}
			}
			for(int i = n - 1; i >=0; i--) {
				for(int j = n - 1; j > i; j--) {
					if(members[i] > members[j] && right_queue[j] + 1 > right_queue[i]) {
						//实时更新right_queue[i]的值
						right_queue[i] = right_queue[j] + 1;
					}
				}
			}
			int max = 0;//max代表符合合唱团队列所能达到的最大人数
			for(int i = 0; i < n; i++) {
				if(left_queue[i] + right_queue[i] > max) {
					max = left_queue[i] + right_queue[i];
				}
			}
			//因为left_queue[i]+right_queue[i]多加了numbers[i]一遍
			//也就是n-max多减了1，需要+1
			System.out.println(n - max + 1);
		}
	}

}
