class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        // for(int d[][] : dp){
        //     for(int k[] : d){
        //         Arrays.fill(k,-1);
        //     }
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dp[m-1][i][i] = grid[m-1][j];
                else
                dp[m-1][i][j] = grid[m-1][i] + grid[m-1][j];
            }
        }

        for(int r=m-2;r>=0;r--){
            for(int c1=0;c1<n;c1++){
                for(int c2=0;c2<n;c2++){
                     int max=Integer.MIN_VALUE;
                    for(int d1=-1;d1<=1;d1++){
                        for(int d2=-1;d2<=1;d2++){
                            int value = (c1==c2) ? grid[r][c1]  :  grid[r][c1]+grid[r][c2] + ((c1+d1>=0 && c1+d1<n && c2+d2>=0 && c2+d2<n )? dp[r+1][c1+d1][c2+d2] : (int)Math.pow(10,-9));
                            max = Math.max(max,value);
                        }
                    }
                    dp[r][c1][c2]=max;
                }
            }
        }
        return dp[0][0][n-1];
        // return f(0,0,n-1,m,n,grid,dp);
    }

    // public int f(int r,int c1,int c2,int m,int n,int grid[][],int dp[][][]){
    //     if(c1<0 || c1>=n || c2<0 || c2>=n){
    //         return (int)Math.pow(10,-9);
    //     }

    //     if(r==m-1){
    //         if(c1==c2){
    //             return grid[r][c1];
    //         }else{
    //             return grid[r][c1]+grid[r][c2];
    //         }
    //     }

    //     if(dp[r][c1][c2]!=-1)
    //         return dp[r][c1][c2];
    //     //explore all the paths
    //     int max=Integer.MIN_VALUE;
    //     for(int d1=-1;d1<=1;d1++){
    //         for(int d2=-1;d2<=1;d2++){
    //             int value = (c1==c2) ? grid[r][c1]  :  grid[r][c1]+grid[r][c2] + f(r+1,c1+d1,c2+d2,m,n,grid,dp);
    //             max = Math.max(max,value);
    //         }
    //     }
    //     return dp[r][c1][c2]=max;
    // }
}