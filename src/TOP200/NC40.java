package TOP200;

import java.util.ArrayList;

/**
* @author 作者:guan
* @createDate 创建时间：Mar 8, 2021 12:34:54 PM
*/


public class NC40 {

	public class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int x) {
			this.val = x;
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//我的这种方法可以应对链表数据少的情况
	//但是如果一多了起来，我这就会出现数值越界的情况!!!
	public ListNode addInList_1(ListNode head1, ListNode head2) {
		if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        int temp = 0;
		StringBuffer num1 = new StringBuffer();
		StringBuffer num2 = new StringBuffer();
		while(head1 != null) {
			num1.append(head1.val);
            head1 = head1.next;
		}
		while(head2 != null) {
			num2.append(head2.val);
            head2 = head2.next;
		}
		int total = Integer.parseInt(num1.toString())+Integer.parseInt(num2.toString());
        ArrayList<Integer> list = new ArrayList<Integer>();
		while(total != 0) {
			temp = total % 10;
			list.add(temp);
			total /= 10;
		}
		ListNode head = new ListNode(list.get(list.size()-1));
        ListNode result = head;
        if(list.size()>=2){
           for(int i = list.size()-2; i >= 0; i--) {
			ListNode node = new ListNode(list.get(i));
	
			head.next = node;
			head = head.next;
		}
        }

		return result;
	}
	
	//另一种
	public ListNode reverse(ListNode node) {
		if(node == null) {
			return node;
		}
		ListNode pre = null;
		ListNode next = null;
		while(node != null) {
			next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		return pre;
	}
	
	public ListNode addInList(ListNode head1,ListNode head2) {
		if(head1==null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		ListNode l1 = reverse(head1);
		ListNode l2 = reverse(head2);
		//用于结果输出，默认第一个是0，故而输出时返回
		ListNode result = new ListNode(0);
		int c = 0;
		while(l1 != null || l2 != null || c != 0) {
			int v1;
			int v2;
			if(l1 != null) {
				v1 = l1.val;
			}else {
				v1=0;
			}
			if(l2 != null) {
				v2 = l2.val;
			}else {
				v2=0;
			}
			int val = v1+v2+c;
			c = val/10;
			ListNode cur = new ListNode(val%10);
			//这里采用头插法
			cur.next =result.next;
			result.next = cur;
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}
		return result.next;
	}
}
