/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair{
        int height;
        boolean isBalanced;

        public Pair(int h,boolean b){
            this.height=h;
            this.isBalanced=b;
        }
    }

    public Pair f(TreeNode root){
        
        if(root==null){
            return new Pair(0,true);
        }

        Pair left=f(root.left);
        Pair right=f(root.right);

        if(left.isBalanced && right.isBalanced && Math.abs(left.height-right.height)<=1){
            return new Pair(Math.max(left.height,right.height)+1,true);
        }
        return  new Pair(Math.max(left.height,right.height)+1,false);

    }

    public boolean isBalanced(TreeNode root) {
        
        if(root==null){
            return true;
        }
        Pair left=f(root.left);
        Pair right=f(root.right);

        if(left.isBalanced && right.isBalanced && Math.abs(left.height-right.height)<=1){
            return true;
        }
        return false;
    }
}