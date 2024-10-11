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

    class tuple{
        TreeNode node;
        int row;
        int col;
        public tuple(TreeNode node,int x,int y){
        this.node=node;
        this.row=x;
        this.col=y;
        } 
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

     TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();

     Queue<tuple> queue=new LinkedList<tuple>();

     queue.offer(new tuple(root,0,0));

     while(!queue.isEmpty()){
        tuple ele=queue.poll();

        TreeNode node=ele.node;
        int row=ele.row;
        int col=ele.col;

        if(!map.containsKey(col)){
            map.put(col,new TreeMap<>());
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row,new PriorityQueue<>());
        }

        map.get(col).get(row).offer(node.val);

        if(node.left!=null){
            queue.offer(new tuple(node.left,row+1,col-1));
        }

        if(node.right!=null){
            queue.offer(new tuple(node.right,row+1,col+1));
        }

     }

     
    
     List<List<Integer>> answer=new ArrayList<>();

     for(TreeMap<Integer,PriorityQueue<Integer>> innerMap :map.values()){
        answer.add(new ArrayList<>());

        for(PriorityQueue<Integer> pq:innerMap.values()){
            
            while(!pq.isEmpty()){
                answer.get(answer.size()-1).add(pq.poll());
            }
         
        }
     }

     return answer;

    }
}