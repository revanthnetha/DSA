class Solution {
    int dr[] = {0,1,0,-1};
    int dc[] = {1,0,-1,0};
    char ch[] = {'R','D','L','U'};
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        String s="";
        if(m[0][0]==0){
            ans.add(new String("-1"));
            return ans;
        }
            
        int vis[][] = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(vis[i],0);
        f(m,n,ans,s,0,0,vis);
        return ans;
    }
        
    public boolean safe(int row,int col,int n){
        return row<n && col<n && row>=0 && col>=0;
    }
    
    public void f(int[][] m,int n,ArrayList<String> ans,String s,int row,int col,int vis[][]){
        
        if(row==n-1 && col==n-1){
            ans.add(s);
            return;
        }
        for(int i=0;i<4;i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            
            if(safe(nr,nc,n) && vis[nr][nc]==0 && m[nr][nc]==1){
                s += ch[i];
                vis[row][col]=1;
                f(m,n,ans,s,nr,nc,vis);
                vis[row][col]=0;
                s = s.substring(0,s.length()-1);
            }
        }
    }
}