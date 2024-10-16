/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        TreeNode node=root;

        while( node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                TreeNode temp=stack.peek().right;

                if(temp==null){
                   TreeNode tempNode=stack.pop();
                   list.add(tempNode.val);

                   while(!stack.isEmpty() && stack.peek().right==tempNode){
                    tempNode=stack.pop();
                    list.add(tempNode.val);
                   }
                }
                else{
                    node=temp;
                }
            }
        }
        return list;
    }
}