import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++)
            dp[0][i]=value[0];
        for(int idx=1;idx<n;idx++){
            for(int W=0;W<=maxWeight;W++){
                int notpick = dp[idx-1][W];
                int pick = 0;
                if(W>=weight[idx])
                    pick = value[idx]+dp[idx-1][W-weight[idx]];
                dp[idx][W] = Math.max(pick,notpick);
            }
        }
        return dp[n-1][maxWeight];
    }

    public static int f(int weight[],int value[],int idx,int W,int dp[][]){
        if(idx==0){
            if(weight[0]<=W)
                return value[0];
            return 0;
        }
        if(dp[idx][W]!=-1)
            return dp[idx][W];
        int notpick = f(weight,value,idx-1,W,dp);
        int pick = 0;
        if(W>=weight[idx])
            pick = value[idx]+f(weight,value,idx-1,W-weight[idx],dp);
        return dp[idx][W] = Math.max(pick,notpick);
    }
}

// 2 1d array Space Optimization
 static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int prev[] = new int[maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++)
            prev[i]=value[0];
        for(int idx=1;idx<n;idx++){
            int curr[] = new int[maxWeight+1];
            for(int W=0;W<=maxWeight;W++){
                int notpick = prev[W];
                int pick = 0;
                if(W>=weight[idx])
                    pick = value[idx]+prev[W-weight[idx]];
                curr[W] = Math.max(pick,notpick);
            }
            prev = curr;
        }
        return prev[maxWeight];
    }


// 1 1d Array Space Optimization