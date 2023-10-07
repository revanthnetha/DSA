class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        int vis[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && (i==0 || i==m-1 || j==0 || j==n-1)){
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                }
            }
        }
        int dr[]= {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row=p.row;
            int col=p.col;
            for(int i=0;i<4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O'){
                    if(vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                    }
                }
            }
        }
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    board[i][j]='X'; 
                }
            }
        }
    }
}
