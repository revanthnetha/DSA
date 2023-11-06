// class Solution {
//     public int uniquePaths(int m, int n) {
//         int N = n+m-2;
//         int k = n-1;
//         double res = 1;
//         for(int i=1;i<=k;i++){
//             res = res*(N-k+i)/i;
//         }
//         return (int)res;
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int d[] : dp){
            Arrays.fill(d,1);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
      return dp[m-1][n-1];
    }

    // public int f(int i,int j,int m,int n,int dp[][]){
    //     if(i==m-1 && j==n-1)    return 1;
    //     if(i>=m || j>=n) return 0;
    //     if(dp[i][j]!=-1)
    //         return dp[i][j];
    //     return dp[i][j] = f(i+1,j,m,n,dp)+f(i,j+1,m,n,dp);
    // }
}