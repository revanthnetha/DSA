class Solution {
    public int minPathSum(int[][] grid) {
        // int dp[][] = new int[grid.length][grid[0].length];
        // for(int d[] : dp)
        //     Arrays.fill(d,-1);
        int prev[] = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int curr[] = new int[grid[0].length];
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0)
                    curr[0]=grid[0][0];
                else{
                    int down=grid[i][j];
                    if(i>0) down += prev[j];
                    else  down+=(int)Math.pow(10,9);
                    int right=grid[i][j];
                    if(j>0) right += curr[j-1];
                    else right+=(int)Math.pow(10,9);
                    curr[j] = Math.min(down,right);
                }
            }
            prev=curr;
        }
        return prev[grid[0].length-1];
    }
}

    // public int f(int m, int n, int[][] grid,int dp[][]) {
    //     if (m == grid.length - 1 && n == grid[0].length - 1) {
    //         return grid[m][n];
    //     }

    //     if (m >= grid.length || n >= grid[0].length) {
    //         return (int)Math.pow(10,9);
    //     }

    //     if(dp[m][n]!=-1)
    //         return dp[m][n];

    //     int down = grid[m][n] + f(m + 1, n, grid,dp); 
    //     int right = grid[m][n] + f(m, n + 1, grid,dp); 

    //     return dp[m][n]=Math.min(down, right);
    // }
