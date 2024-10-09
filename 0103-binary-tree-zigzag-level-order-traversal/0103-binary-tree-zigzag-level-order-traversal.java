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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {



        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> answer=new ArrayList<>();
        boolean reverse=true;
        queue.offer(root);
        if(root==null){
            return answer;
        }

        while(!queue.isEmpty()) {

            int size=queue.size(); ///no of nodes on current level
            List<Integer> ele=new ArrayList<>();
            reverse=!reverse;

            for(int i=0;i<size;i++){

            TreeNode node=queue.remove();
            ele.add(node.val);

            if(node.left!=null){
            queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }

            }

            if(reverse){
            Collections.reverse(ele);
            }

            answer.add(ele);
        }
        
        return answer;
    }
}