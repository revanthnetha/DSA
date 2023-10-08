class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<ArrayList<String>> st = new HashSet<>();
        int vis[][] = new int[m][n];
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    bfs(grid,i,j,vis,st,dr,dc);
                }
            }
        }
        return st.size();
    }
    
    public void bfs(int grid[][],int row,int col,int vis[][],Set<ArrayList<String>> st,int dr[],int dc[]){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        ArrayList<String> a = new ArrayList<>();
        a.add(new String("0 0"));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;
        for(int i=0;i<4;i++){
            int nr = dr[i]+r;
            int nc = dc[i] + c;
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && vis[nr][nc]==0 && grid[nr][nc]==1){
                vis[nr][nc]=1;
                // String s = "";
                // s+= nr-row+ " ";
                // s += nc-col;
                a.add(new String(""+ (nr-row)+ " " + (nc-col)));
                q.add(new Pair(nr,nc));
            }
        }
        }
        st.add(a);
    }
}

