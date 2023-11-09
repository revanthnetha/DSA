class Solution {
    public int f(int amount,int coins[],int dp[]){
        if(amount==0)
            return 0;
        if(amount<0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        if(dp[amount]!=-1)
            return dp[amount];
        for(int i=0;i<coins.length;i++){
            int ans=f(amount-coins[i],coins,dp);
            if(ans!=Integer.MAX_VALUE)
                min = Math.min(min,1+ans);
        }
        return dp[amount]= min;
    }
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = f(amount,coins,dp);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }
}