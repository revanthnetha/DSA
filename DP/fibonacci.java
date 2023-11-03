class Solution {
    public int fib(int n) {
       if(n<=1)
        return n;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        //tabulation
        // dp[0]=0;
        // dp[1]=1;
        // for(int i=2;i<=n;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];
        int prev2= 0;
        int prev1 = 1;
        for(int i=2;i<=n;i++){
            int curr = prev1+prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
        // return fib(n-1) + fib(n-2);
    }

    //memoization

    // public int f(int n,int dp[]){
    //     if(n<=1)
    //     return n;
    //     if(dp[n]!=-1)
    //         return dp[n];
    //     return dp[n] = f(n-1,dp) + f(n-2,dp);
    // }
}
