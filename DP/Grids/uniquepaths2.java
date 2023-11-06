class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if( obstacleGrid[0][0]==1 )
            return 0;
        int prev[] = new int[n];
        for(int i=0;i<m;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[j]=1;
                else if(obstacleGrid[i][j]==1)
                    curr[j]=0;
                else{
                int up =0;
                if(i>=1) up = prev[j];
                int left=0;
                if(j>=1) left = curr[j-1];
                curr[j] = left + up;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

    // public int f(int m,int n,int[][] obstacleGrid,int dp[][]){
    //     if((m<0 || n<0) || m>=0 && n>=0 && obstacleGrid[m][n]==1){
    //         return 0;
    //     }
    //     if(m==0 && n==0)
    //         return 1;
    //     if(dp[m][n]!=-1)
    //         return dp[m][n];
    //     return dp[m][n] = f(m-1,n,obstacleGrid,dp) + f(m,n-1,obstacleGrid,dp);
    // }
}

//   int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int dp[][] = new int[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0 && j==0) dp[i][j]=1;
//                 else if(obstacleGrid[i][j]==1)
//                     dp[i][j]=0;
//                 else{
//                 int up =0;
//                 if(i>=1) up = dp[i-1][j];
//                 int left=0;
//                 if(j>=1) left = dp[i][j-1];
//                 dp[i][j] = left + up;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }