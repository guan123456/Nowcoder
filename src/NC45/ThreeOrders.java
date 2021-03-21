package NC45;
import java.util.*;
/**
* @author 作者:guan
* @createDate 创建时间：Feb 23, 2021 4:10:12 PM
*/
public class ThreeOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		TreeNode(int x){
			val = x;
		}
	}

    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> in = new ArrayList<Integer>();
    ArrayList<Integer> post = new ArrayList<Integer>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
        preOrder(root);
        inOrder(root);
        postOrder(root);
        int[][] result = new int[3][pre.size()];
        result[0] = ArrayListToArray(pre);
        result[1] = ArrayListToArray(in);
        result[2] = ArrayListToArray(post);
        return result;
    }
    
    private int[] ArrayListToArray(ArrayList<Integer> list){
        if(list == null || list.size() < 1){
            return new int[0];
        }
        int[] temp = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            temp[i] = list.get(i);
        }
        return temp;
    }
    private void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        in.add(root.val);
        inOrder(root.right);
    }
    private void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
    }
}
