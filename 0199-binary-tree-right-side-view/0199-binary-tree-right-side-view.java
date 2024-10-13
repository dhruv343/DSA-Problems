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
    public void traversal(TreeNode root,List<Integer> answer,int lvl){
    
    if(root==null){
        return;
    }

    if(lvl==answer.size()){
    answer.add(root.val);
    }

    traversal(root.right,answer,lvl+1);
    traversal(root.left,answer,lvl+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> answer=new ArrayList<>();

        int lvl=0;

        traversal(root,answer,lvl);

        return answer;
    }
}