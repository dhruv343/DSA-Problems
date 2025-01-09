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

    void inOrder(TreeNode root,List<Integer> list){
        
        if(root==null) return;

        inOrder(root.left,list);

        list.add(root.val);

        inOrder(root.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        System.out.print(list);

        int s=0;
        int n=list.size();
        int e=n-1;

        while(s<e){

            int sum=list.get(s)+list.get(e);

            if(sum==k){
                return true;
            }
            else if(sum>k){
                e--;
            }
            else{
                s++;
            }
            
        }

        return false;
    }
}