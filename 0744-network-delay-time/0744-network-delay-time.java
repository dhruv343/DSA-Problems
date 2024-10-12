class Solution {
    class Edge{
        int v;
        int wt;

        Edge(int v,int wt){
        this.v=v;
        this.wt=wt;
        }
    }
    class Pair {
        int node;
        int dist;

        Pair(int n,int d){
         node=n;
         dist=d;
        }
    }

    public int[] dijkstra(List<Edge>[] graph,int src){
       int[] dist=new int[graph.length];
    //    boolean[] visited=new boolean[graph.length];
       Queue<Pair> pq=new LinkedList<>();
       
       dist[0]=-1;

       for(int i=1;i<dist.length;i++){
        if(i!=src){
            dist[i]=Integer.MAX_VALUE;
        }
       }

       pq.add(new Pair(src,0));

       while(!pq.isEmpty()){
        Pair temp=pq.remove();
        
            for(int i=0;i<graph[temp.node].size();i++){
                Edge neigh=graph[temp.node].get(i);
                int v=neigh.v;
                int wt=neigh.wt;

                if(dist[temp.node]+wt<dist[v]){
                    dist[v]=dist[temp.node]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        
       }
       
       return dist;

       
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] graph=new ArrayList[n+1];
        for(int i=1;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int wt=times[i][2];

            graph[u].add(new Edge(v,wt));
        }
        
        int[] ans=dijkstra(graph,k);
  
        int min=Integer.MIN_VALUE;

        for(int i=1;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE){
                return -1;
            }
            min=Math.max(min,ans[i]);
        }
        
        return min;
    }
}