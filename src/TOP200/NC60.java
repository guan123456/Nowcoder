package TOP200;
/**
* @author 作者:guan
* @createDate 创建时间：Mar 16, 2021 11:47:22 AM
*/
import java.util.*;
public class NC60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		
	}
	//判断一棵树是否为搜索二叉树和完全二叉树
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] result = new boolean[2];
        if(JudgeBinarySearchTree(root)){
            result[0] = true;
        }
        if(JudgeCompleteBinaryTree(root)){
            result[1] = true;
        }
        return result;
        
    }
    //递归判断左子树和右子树是否是二叉搜索树
    public boolean JudgeBinarySearchTree(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.left != null && root.left.val > root.val){
            return false;
        }
        if(root.right != null && root.right.val < root.val){
            return false;
        }
        return JudgeBinarySearchTree(root.left) && JudgeBinarySearchTree(root.right);
    }
    
    public boolean JudgeCompleteBinaryTree(TreeNode root){
       //1.层次遍历直至遇到第一个空节点
       //2.完全二叉树在遇到空节点之后剩余的应当全是空节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //先进先出，这里使得最后剩下的是叶节点的两个空指针null
        while(queue.peek()!=null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        
        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}
