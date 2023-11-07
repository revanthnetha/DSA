class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min=Integer.MAX_VALUE;
        int dp[][] = new int[m][n];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        for(int i=0;i<n;i++)
         min = Math.min(min,f(0,i,m,n,grid,dp)); 
        return min;
    }

     public int f(int row,int col,int m,int n,int grid[][],int dp[][]){
        if(row==m-1){
            return grid[row][col];
        }
        if(dp[row][col]!=-1)
            return dp[row][col];
        int max=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i!=col){
                max =Math.min(max, (grid[row][col]+f(row+1,i,m,n,grid,dp)));
            }
        }
        return dp[row][col]= max;
    }
}