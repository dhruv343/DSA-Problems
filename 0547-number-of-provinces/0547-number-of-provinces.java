class Solution {
    void dfs(int node,boolean[] visited,ArrayList<Integer>[] graph){
     System.out.print(node+" ");
     visited[node]=true;

     for(Integer it:graph[node]){
        if(visited[it]==false){
            dfs(it,visited,graph);
        }
     }
    }
    public int findCircleNum(int[][] isConnected) {

        int n=isConnected.length;
        ArrayList<Integer>[] graph=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph[i+1].add(j+1);
                    graph[j+1].add(i+1);
                }
            }
        }

        boolean[] visited=new boolean[n+1];
        int count=0;

        for(int i=1;i<=n;i++){
            if(visited[i]==false){
             dfs(i,visited,graph);
             System.out.print("-- ");
             count++;
            }
        }

        return count;
    }
}