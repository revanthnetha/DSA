class Solution {
    class Pair{
        int row;
        int col;
        int d;
        public Pair(int row,int col,int d){
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.d-b.d));
        int m = grid.length;
        int n = grid[0].length;
        int dr[] = {0,1,1,1,0,-1,-1,-1};
        int dc[] = {1,1,0,-1,-1,-1,0,1};
        int vis[][] = new int[m][n];
        if(grid[0][0]==1)
            return -1;
        pq.add(new Pair(0,0,0));
        vis[0][0]=1;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int d = p.d;
            
            if(row==m-1 && col == n-1)
                return d+1;

            for(int i=0;i<8;i++){
                int nr = row+dr[i];
                int nc = col + dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0 && vis[nr][nc]==0){
                    pq.add(new Pair(nr,nc,d+1));
                    vis[nr][nc]=1;
                }
            }
        }
        return -1;
    }
}
