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

    public boolean f(TreeNode rootL,TreeNode rootR){
        if(rootL==null && rootR==null){
            return true;
        }
        if(rootL==null || rootR==null){
            return false;
        }
        
        return rootL.val==rootR.val && f(rootL.left,rootR.right) && f(rootL.right,rootR.left);

    }
    public boolean isSymmetric(TreeNode root) {
      
      if(root==null){
        return true;
      }
      return f(root.left,root.right);  
      
    }
}