class Solution {
    class Pair{
        int node;
        int parent;
        public Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public boolean bfs(int src,ArrayList<ArrayList<Integer>> adj,int vis[]){
     Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src]=1;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            int parent = p.parent;
            for(Integer ele : adj.get(node)){
                if(vis[ele]==0){
                    q.add(new Pair(ele,node));
                    vis[ele]=1;
                }else if(vis[ele]==1 && ele != parent){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(bfs(i,adj,vis)) return true;
            }
        }
        return false;
    }
}