class Solution {
    
    private boolean dfs(int node,int vis[],ArrayList<ArrayList<Integer>> adj){
        vis[node]=2;
        for(int ele : adj.get(node)){
            if(vis[ele]==0){
                if(dfs(ele,vis,adj)==true) return true;
            }else if(vis[ele]==2){
                return true;
            }
        }
        vis[node] = 1;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       int vis[] = new int[V];
    //   int pathvis[] = new int[V];
       for(int i=0;i<V;i++){
           if(vis[i]==0){
               if(dfs(i,vis,adj)==true)
                return true;
           }
       }
       return false;
    }
} 