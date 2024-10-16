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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;

        while(true){
          if(node!=null){
            list.add(node.val);
            stack.push(node);
            node=node.left;
          }

          else{
            if(stack.isEmpty()){
                break;
            }

            TreeNode noDe=stack.pop();

            node=noDe.right;
          }
        }

        return list;
    }
}