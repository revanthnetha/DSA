class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int vis[] = new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,adj,vis);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int n,ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[n]=1;
        for(Integer it : adj.get(n)){
            if(vis[it]==0){
                vis[it]=1;
                dfs(it,adj,vis);
            }
        }
    }
}