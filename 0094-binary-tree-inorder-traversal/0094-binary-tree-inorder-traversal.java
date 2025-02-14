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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        //morris traversal

        TreeNode curr=root;
        ArrayList<Integer> inOrder=new ArrayList<>();

        while(curr!=null){

            if(curr.left==null){
                inOrder.add(curr.val);
                curr=curr.right;
            }

            else{
             
             TreeNode prev=curr.left;

             while(prev.right!=null && prev.right!=curr){
                prev=prev.right;
             }

             if(prev.right==null){
                prev.right=curr;
                curr=curr.left;
             }
             else{
                prev.right=null;
                inOrder.add(curr.val);
                curr=curr.right;
             }

            }
        }

        return inOrder;
    }
}