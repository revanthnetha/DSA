//memoization
import java.util.* ;
import java.io.*; 
public class Solution {

    public static int f(int n,int[] num, int tar,int dp[][]){
        if(tar==0) return 1;
        if(n==0) {
             return (tar==num[0])?1 : 0;
            
         }

        if(dp[n][tar]!=-1)
            return dp[n][tar];
        int nottake = f(n-1,num,tar,dp);
        int take =0;
        if(num[n]<=tar)
            take = f(n-1,num,tar-num[n],dp);
        return dp[n][tar]=take+ nottake;
    }
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int dp[][] = new int[n][tar+1];
        for(int i=0;i<n;i++)
            dp[i][0] = 1;
        if(num[0]<=tar)
        dp[0][num[0]] = 1;
        for(int i=1;i<n;i++){
            for(int j=1;j<=tar;j++){
                    int nottake = dp[i-1][j];
                    int take =0;
                    if(num[i]<=j)
                        take = dp[i-1][j-num[i]];
                   dp[i][j]=take+ nottake;
            }
        }
        return dp[n-1][tar];
    }
}

//space optimization
 public static int findWays(int num[], int tar) {
        int n = num.length;
        int mod=(int)Math.pow(10,9)+7;
        int prev[] = new int[tar+1];
        prev[0]=1;
        if(num[0]<=tar)
        prev[num[0]] = 1;
        for(int i=1;i<n;i++){
             int curr[] = new int[tar+1];
            curr[0]=1;
            for(int j=1;j<=tar;j++){
                    int nottake = prev[j];
                    int take =0;
                    if(num[i]<=j)
                        take = prev[j-num[i]];
                   curr[j]=(take+ nottake)%mod;
            }
            prev = curr;
        }
        return prev[tar]%mod;
    }