package TOP200;

import java.util.ArrayList;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 10, 2021 2:32:27 PM
*/
public class NC51 {

	public class ListNode{
		int val;
		ListNode next =null;
		ListNode(int x){
			this.val = x;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//常规，从头到尾一个一个组合
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		//应该加上判断边界值
        if(lists==null || lists.size() == 0){
            return null;
        }
		ListNode result = lists.get(0);
		for(int i = 1; i < lists.size(); i++) {
			ListNode temp = lists.get(i);
			result = merge(result, temp);
		}
		return result;
	}

	public ListNode merge(ListNode list1,ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		if(list1.val < list2.val) {
			list1.next = merge(list1.next, list2);
			return list1;
		}else {
			list2.next = merge(list1, list2.next);
			return list2;
		}
	}
	
	//分治，归并排序
	public ListNode mergeKLists_1(ArrayList<ListNode> lists) {
		if(lists==null || lists.size()==0) {
			return null;
		}
		return mergeLists(lists, 0, lists.size()-1);
		
	}
	public ListNode mergeLists(ArrayList<ListNode> lists,int low, int high) {
		if(low >= high) {
			return lists.get(low);
		}
		int mid = low + ((high-low) >> 1);
		ListNode l1 = mergeLists(lists,low,mid);
		ListNode l2 = mergeLists(lists,mid+1,high);
		return merge(l1, l2);
	}
}
