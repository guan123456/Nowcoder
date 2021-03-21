package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 16, 2021 12:46:01 PM
*/

import java.util.*;

public class NC37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}

	//先按照开始区间start排序,调用了Collections的比较方法
	//好精炼的做法
	public ArrayList<Interval> merge(ArrayList<Interval> intervals){
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		for(int i = 1; i < intervals.size(); i++) {
			int preStart = intervals.get(i-1).start;
			int preEnd = intervals.get(i-1).end;
			int curStart = intervals.get(i).start;
			int curEnd = intervals.get(i).end;
			if(curStart <= preEnd) {
				intervals.set(i, new Interval(preStart,Math.max(preEnd, curEnd)));
				//如果有合并，那么保留当前这一个，删除前面一个即可，这样后面i-1可以访问到
				intervals.set(i-1, null);
			}
		}
		//这一步是把那些置null的位置清理掉
		while(intervals.remove(null));
		return intervals;
	}
}
