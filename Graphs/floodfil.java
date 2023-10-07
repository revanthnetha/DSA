class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int image[][],int sr,int sc,int vis[][],int in,int dr[],int dc[],int c){
        vis[sr][sc]=1;
        image[sr][sc]=c;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
        for(int i=0;i<4;i++){
            int nr = row+dr[i];
            int nc = col + dc[i];
            if(nr>=0 && nc>=0 && nr<image.length && nc<image[0].length && image[nr][nc]==in && vis[nr][nc]==0){
                vis[nr][nc]=1;
                image[nr][nc] = c;
                q.add(new Pair(nr,nc));
            }
        }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int vis[][] = new int[m][n];
        int initial = image[sr][sc];
        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        bfs(image,sr,sc,vis,initial,dr,dc,color);
        return image;
    }
}