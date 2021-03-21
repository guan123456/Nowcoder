package HJ51_plus_practice;
import java.awt.RenderingHints.Key;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 6, 2021 11:37:20 AM
*/
import java.util.*;
public class HJ51 {

	public static class ListNode{
		int val;
		ListNode next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			ListNode list = new ListNode();
			ListNode head = list;
			for(int i = 0; i < n; i++) {
				ListNode node = new ListNode();
				int value = scanner.nextInt();
				node.val = value;
				list.next = node;
				list = node;
			}
			int KthFromEnd = scanner.nextInt();
			if(KthFromEnd <= 0 || KthFromEnd > n) {
				System.out.println(0);
			}else {
				for(int i = 0; i < n - KthFromEnd + 1; i++) {
					head = head.next;
				}
				System.out.println(head.val);
			}
		}
	}
	
	//以上代码如果用java自带的ArrayList实现如下
/*	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		while(Scanner.hasNext()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int n = Scanner.nextInt();
			for(int i = 0; i < n; i++) {
				int val = Scanner.nextInt();
				list.add(val);
			}
			int k = Scanner.nextInt();
			if(k <= 0 || k > n) {
				System.out.println(0);
			}else {
				System.out.println(list.get(list.size() - k));
			}
		}
	}
*/
}
