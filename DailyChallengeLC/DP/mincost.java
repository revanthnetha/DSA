class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(f(cost,0,dp),f(cost,1,dp));

    }

    public int f(int[] costs,int idx,int dp[]){
        if(idx>=costs.length){
            return 0;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        int one =  costs[idx] + f(costs,idx+1,dp);
        int second = costs[idx] + f(costs,idx+2,dp);
        return dp[idx]= Math.min(one,second);
    }
}
