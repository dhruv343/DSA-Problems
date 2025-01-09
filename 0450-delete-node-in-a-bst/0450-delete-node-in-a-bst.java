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

    public int min(TreeNode root){
        TreeNode temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
           
           if(root==null){
            return null;
           }


           if(root.val==key){
             if(root.left==null && root.right==null){
                return null;
             }
             else if(root.left==null && root.right!=null){
                return root.right;
             }
             else if(root.right==null && root.left!=null){
                return root.left;
             }
             else if(root.left!=null && root.right!=null){
                
                int mini=min(root.right);
                root.right=deleteNode(root.right,mini);
                root.val=mini;
                return root;
             }   
           }

           else if(root.val>key){
            root.left=deleteNode(root.left,key);
           }

           else{
            root.right=deleteNode(root.right,key);
           }
           
           return root;


    }
}