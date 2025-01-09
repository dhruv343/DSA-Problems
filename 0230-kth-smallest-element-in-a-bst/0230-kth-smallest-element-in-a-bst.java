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
    public int count=0;
    public int result=-1;

    public void inOrder(TreeNode root, int k){
        if(root==null) return;

        inOrder(root.left,k);
        
        count++;
        if(count==k){
            result=root.val;
            return;
        }

        inOrder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {

         inOrder(root,k);

         return result;
    }
}