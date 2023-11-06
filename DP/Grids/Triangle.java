class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        // int dp[][] = new int[m][n];
        // for(int d[] : dp)
        //     Arrays.fill(d,-1);
        int front[] = new int[n];
        // for(int j=0;j<n;j++)
        //     dp[m-1][j] = triangle.get(m-1).get(j);
        for(int j=0;j<n;j++)
            front[j] = triangle.get(m-1).get(j);
        
        for(int i=m-2;i>=0;i--){
            int curr1[] = new int[n];
            for(int j=triangle.get(i).size()-1;j>=0;j--){
                int curr = triangle.get(i).get(j) + front[j];
                int next = triangle.get(i).get(j) + front[j+1];
                curr1[j]=Math.min(curr,next);
            }
            front = curr1;
        }
        return front[0];
    }
}

//  public int f(int row,int col,int m ,int n,List<List<Integer>> triangle,int dp[][]){
//         if(row==m-1 && col<n){
//             return triangle.get(row).get(col);
//         }
//         if(dp[row][col]!=-1)
//             return dp[row][col];
//         int curr = triangle.get(row).get(col) + f(row+1,col,m,n,triangle,dp);
//         int next = triangle.get(row).get(col) + f(row+1,col+1,m,n,triangle,dp);
//         return dp[row][col]=Math.min(curr,next);
//     }