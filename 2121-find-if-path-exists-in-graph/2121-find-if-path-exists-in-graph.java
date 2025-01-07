class Solution {

    boolean path(boolean[] vis, ArrayList<Integer>[] graph,int src,int dest){

     if(src==dest) return true;

      vis[src]=true;

      for(int it:graph[src]){
           if(!vis[it]){
             if(path(vis,graph,it,dest)) return true;
           }
      } 
      return false;
       
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Integer>[] graph=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(path(visited,graph,source,destination)) return true;
            }
        }
        
        return false;
    }
}