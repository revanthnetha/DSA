class Solution {
    public boolean dfs(int node,int graph[][],int vis[],int pathvis[],int mark[]){
        vis[node]=1;
        pathvis[node]=1;
        mark[node]=0;
        for(int ele : graph[node]){
            if(vis[ele]==0){
                if(dfs(ele,graph,vis,pathvis,mark)==true){
                mark[ele] = 0;
                return true;
                }
            }else if(pathvis[ele]==1){
                mark[ele]=0;
                return true;
            }
        }
        mark[node] = 1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int vis[] = new int[m];
        int pathvis[] = new int[m];
        List<Integer> a = new ArrayList<>();
        int mark[] = new int[m];
        for(int i=0;i<m;i++){
            dfs(i,graph,vis,pathvis,mark);
        }

        for(int i=0;i<m;i++){
            if(mark[i]==1)
                a.add(i);
        }
        return a;
    }
}