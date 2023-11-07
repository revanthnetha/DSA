class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min=Integer.MAX_VALUE;
        // int dp[][] = new int[m][n];
        // for(int l=0;l<n;l++)
        //      dp[0][l] = matrix[0][l];
        int prev[] = new int[n];
        for(int i=0;i<n;i++)
            prev[i] = matrix[0][i];
        for(int j=1;j<m;j++){
            int curr[] = new int[n];
            for(int k=0;k<n;k++){
                int down = matrix[j][k] + prev[k];
                int left =  matrix[j][k] + ((k>0)?  prev[k-1] : (int)Math.pow(10,9));
                int right =  matrix[j][k] + ((k<n-1) ? prev[k+1]  : (int)Math.pow(10,9));
                curr[k]= Math.min(down,Math.min(left,right));
            }
            prev = curr;
        }
        for(int i=0;i<n;i++)
        min = Math.min(min,prev[i]);
        return min;
    }

    //overlapping subproblems 1 dp array--> refer to the notes.
    // public int f(int row,int col,int m,int n,int matrix[][],int dp[][]){
    //     if(col<0 || col>=n)
    //         return (int)Math.pow(10,9);
    //     if(row==m-1){
    //         return matrix[row][col];
    //     }

    //     if(dp[row][col]!=-1)
    //         return dp[row][col];
    //     int down = matrix[row][col] + f(row+1,col,m,n,matrix,dp);
    //     int left =  matrix[row][col] + f(row+1,col-1,m,n,matrix,dp);
    //     int right =  matrix[row][col] + f(row+1,col+1,m,n,matrix,dp);
    //     return dp[row][col]= Math.min(down,Math.min(left,right));
    // }

    //   for(int k=0;k<n;k++){
    //             int down = matrix[j][k] + dp[j-1][k];
    //             int left =  matrix[j][k] + ((k>0)?  dp[j-1][k-1] : (int)Math.pow(10,9));
    //             int right =  matrix[j][k] + ((k<n-1) ? dp[j-1][k+1]  : (int)Math.pow(10,9));
    //             dp[j][k]= Math.min(down,Math.min(left,right));
    //         }
}