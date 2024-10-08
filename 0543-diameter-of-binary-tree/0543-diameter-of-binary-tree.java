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

    public int[] diameterAndHeight(TreeNode root){

    if(root==null){
    return new int[]{0,0};
    }
    
    int[] left=diameterAndHeight(root.left);
    int[] right=diameterAndHeight(root.right);
    int diameter=left[1]+right[1]+1;
    
    int[] pair=new int[2];

    pair[0]=Math.max(Math.max(left[0],right[0]),diameter);

    pair[1]=Math.max(left[1],right[1])+1;
    return pair;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int diameter=diameterAndHeight(root)[0];
        return diameter-1;
    }
}