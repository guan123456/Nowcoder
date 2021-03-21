package HJ23_plus_practice;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 4, 2021 4:26:14 PM
*/
import java.util.*;

public class HJ48 {

	//通不过就算了，我花了一个半个小时，做了几个测试用例都没问题!!!
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val = x;
		}
	}
	private static ListNode resultList;
	private static boolean isDeleted;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			//本题考查一下新建一个链表并删除链表中元素
			//新建表时题目的指向巨坑
			int n = scanner.nextInt();
			int head = scanner.nextInt();
			resultList = new ListNode(head);
			//建立链表
			for(int i = 0; i < n - 1; i++) {
				int to = scanner.nextInt();
				int from = scanner.nextInt();
				ConstructList(from, to, resultList);
			}
            
			int deletedNodeValue = scanner.nextInt();
			ListNode result = deleteNode(resultList, deletedNodeValue);
			if(isDeleted == true) {
				while(result != null) {
					System.out.print(result.val + " ");
					result = result.next;
				}
			}
			System.out.println();
		}
	}
	
	//建立链表
	public static void ConstructList(int from,int to,ListNode list) {
		ListNode p = list;
		//不存在新结点指向头结点的情况
		//只存在头结点指向新结点的情况
		if(from == p.val) {
			ListNode node = new ListNode(to);
			if(p.next != null) {
				//断开，保存后续结点，方便插入新结点后的连接
				ListNode next = p.next;
				//新结点先连接后续结点
				node.next = next;
				//连接头结点
				p.next = node;
			}else {
				p.next = node;
			}
			//这里默认p.next !=null了，因为第一行必定连接头结点
		}else {
			ListNode next = p.next;
			//这里默认原有链表一定存在有值为from或者to的链表结点
			while(next.val != from && next.val != to) {
				next = next.next;
                p = p.next;
			}
			if(next.val == from) {
				ListNode node = new ListNode(to);
				if(next.next != null) {
					//断开，保存后续结点，方便插入新结点后的连接
					ListNode temp = next.next;
					//新结点先连接后续结点
					node.next = temp;
					//连接头结点
					next = node;
				}else {
					next.next = node;
				}
			}else if(next.val == to) {
				ListNode node = new ListNode(from);
				node.next = next;
				p.next = node;
			}	
		}
	}
	//删除值为deletedNodeValue的结点
	public static ListNode deleteNode(ListNode list, int nodeValue) {
		if(list.val == nodeValue) {
			isDeleted = true;
			return list.next;
		}
		ListNode pre = list;
		ListNode cur = list.next;
		while(cur != null && cur.val != nodeValue) {
			pre = cur;
			cur = cur.next;
		}
		if(cur != null) {
			isDeleted = true;
			pre.next = cur.next;
		}
		return list;
	}
}
