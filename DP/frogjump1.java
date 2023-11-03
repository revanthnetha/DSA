import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n];
        //tabulation
        for(int i=1;i<n;i++){
            int left = dp[i-1] + Math.abs(heights[i-1]-heights[i]);
           int right = (i>1) ? dp[i-2]+Math.abs(heights[i-2]-heights[i]) : Integer.MAX_VALUE;

          dp[i]=Math.min(left,right);
        }
        
        //space optimization
        int prev2 = 0;
        int prev =0;
         for(int i=1;i<n;i++){
            int left = prev + Math.abs(heights[i-1]-heights[i]);
           int right = (i>1) ? prev2+Math.abs(heights[i-2]-heights[i]) : Integer.MAX_VALUE;

          int curr=Math.min(left,right);
          prev2 = prev;
          prev = curr;
        }
        return prev;
        // return dp[n-1];
        // return f(n-1,heights,dp);
    }

    //memoization 
    // public static int f(int n ,int heights[],int dp[]){
    //     if(n==0)
    //         return 0;
        
    //     if(dp[n]!=0)
    //         return dp[n];
    //     int left = f(n-1,heights,dp) + Math.abs(heights[n-1]-heights[n]);
    //     int right = (n>1) ? f(n-2,heights,dp)+Math.abs(heights[n-2]-heights[n]) : Integer.MAX_VALUE;

    //     return dp[n]=Math.min(left,right);
    // }

}

// https://www.codingninjas.com/studio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION