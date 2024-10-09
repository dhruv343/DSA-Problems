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
class BSTIterator {
    
    LinkedList<Integer> list=new LinkedList<>();
    int pointer;

    public void inOrder(TreeNode root ,LinkedList<Integer> list){

    if(root==null){
        return;
    }
    inOrder(root.left,list);
    list.add(root.val);
    inOrder(root.right,list);

    }

    public BSTIterator(TreeNode root) {
        inOrder(root,list);
        pointer=-1;
    }
    
    public int next() {
        pointer++;
        return list.get(pointer);
    }
    
    public boolean hasNext() {
        int check=pointer+1;
        if(check<list.size()){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */