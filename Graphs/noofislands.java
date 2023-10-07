class Solution {
    int dr[] = {0,1,0,-1};
    int dc[] = {1,0,-1,0};
    public void dfs(int i,int j,char grid[][],int vis[][]){
        vis[i][j] = 1;
        for(int k=0;k<4;k++){
            int nr = i + dr[k];
            int nc = j + dc[k];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]=='1' && vis[nr][nc]==0){
                vis[nr][nc]=1;
                dfs(nr,nc,grid,vis);
            }
        }   

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (n == 0) return 0;
        int ans=0;
        int vis[][]= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
}
