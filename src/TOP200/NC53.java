package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 7, 2021 7:04:04 PM
*/

import HJ23_plus_practice.HJ48.ListNode;

public class NC53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode{
		int val;
		ListNode next = null;
	}
	public ListNode removeNthFromEnd(ListNode head,int n) {
		if(head == null) {
			return null;
		}
		ListNode pListNode = head;
		ListNode qListNode = head;
		ListNode pre = null;
        for(int i = 0; i < n; i++){
            pListNode = pListNode.next;
        }
        if(pListNode == null) {
        	return head.next;
        }
        while(pListNode != null) {
        	pListNode = pListNode.next;
        	pre = qListNode;
        	qListNode = qListNode.next;
        	if(pListNode == null) {
        		pre.next = qListNode.next;
        	}
        }
        return head;
	}
	//另一种
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i < n; i++)
            first = first.next;
        //如果n的值等于链表的长度,直接返回去掉头结点的链表
        if(first == null)
            return head.next;
        while(first.next != null)   //同时移动两个指针
        {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
