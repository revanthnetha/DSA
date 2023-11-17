package subsequences;
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

//striver memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
         int dp[][] = new int[n][amount+1];
        for(int d[] : dp)
         Arrays.fill(d,-1);
        int k = f(n-1,amount,coins,dp);
        int ans = k==(int)Math.pow(10,9) ? -1 : k;
        return ans;
    }

    public int f(int idx,int T,int coins[],int dp[][]){
        if(idx==0){
            if(T%coins[0]==0)
                return T/coins[0];
            return (int)Math.pow(10,9);
        }
        if(dp[idx][T]!=-1)
            return dp[idx][T];
        int nottake = f(idx-1,T,coins,dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx]<=T){
            take = 1+ f(idx,T-coins[idx],coins,dp);
        }
        return dp[idx][T]=Math.min(take,nottake);
    }
}

//tabulation
 public int coinChange(int[] coins, int amount) {
        int n = coins.length;
         int dp[][] = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
                dp[0][i] = i/coins[0];
            else
                dp[0][i] = (int)Math.pow(10,9);
        }
        for(int idx=1;idx<n;idx++){
            for(int T=0;T<=amount;T++){
                int nottake = dp[idx-1][T];
                int take = Integer.MAX_VALUE;
                if(coins[idx]<=T){
                    take = 1+ dp[idx][T-coins[idx]];
                }
                dp[idx][T]=Math.min(take,nottake);
            }
        }
        int k = dp[n-1][amount];
        int ans = k==(int)Math.pow(10,9) ? -1 : k;
        return ans;
    }

//space optimization

 public int coinChange(int[] coins, int amount) {
        int n = coins.length;
         int prev[] = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
                prev[i] = i/coins[0];
            else
                prev[i] = (int)Math.pow(10,9);
        }
        for(int idx=1;idx<n;idx++){
            int curr[] = new int[amount+1];
            for(int T=0;T<=amount;T++){
                int nottake = prev[T];
                int take = Integer.MAX_VALUE;
                if(coins[idx]<=T){
                    take = 1+ curr[T-coins[idx]];
                }
                curr[T]=Math.min(take,nottake);
            }
            prev = curr;
        }
        int k = prev[amount];
        int ans = k==(int)Math.pow(10,9) ? -1 : k;
        return ans;
    }