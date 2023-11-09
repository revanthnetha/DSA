import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k+1];
        for(boolean d[] : dp)
            Arrays.fill(d,false);
        for(int i=0;i<n;i++)
            dp[i][0] = true;
        if(k>=arr[0])
           dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                boolean notpick = dp[i-1][j];
                boolean pick = false;
                if(j>=arr[i])
                    pick = dp[i-1][j-arr[i]];
                dp[i][j]=pick | notpick;
            }
        }
        return dp[n-1][k];
    }

    // public static boolean f(int idx,int k,int arr[],boolean dp[][]){
    //     if(k==0)
    //         return true;
    //     if(idx==0)
    //         return k==arr[0];
    //     if(dp[idx][k]!=false)
    //         return dp[idx][k];
    //     boolean notpick = f(idx-1,k,arr,dp);
    //     boolean pick = false;
    //     if(k>=arr[idx])
    //         pick = f(idx-1,k-arr[idx],arr,dp);
    //     return dp[idx][k]=pick || notpick;
    // }
}
