
public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
		long dp[][] = new long[n][value+1];
		for(int i=0;i<=value;i++){
			if(i%denominations[0]==0) dp[0][i] =1;
			else dp[0][i]=0;
		}

		for(int idx=1;idx<n;idx++){
			for(int T=0;T<=value;T++){
				long notpick = dp[idx-1][T];
				long pick =0;
				if(denominations[idx]<=T)
					pick = dp[idx][T-denominations[idx]];
				dp[idx][T]=pick+notpick;
			}
		}
		return dp[n-1][value];

	}

	// public static int f(int idx,int T,int denominations[],int dp[][]){
	// 	  if(idx==0){
    //         if(T%coins[0]==0)
    //             return 1;
    //         return 0;
    //     }
	// 	if(dp[idx][T]!=-1)
	// 		return dp[idx][T];
	// 	int notpick = f(idx-1,T,denominations,dp);
	// 	int pick =0;
	// 	if(denominations[idx]<=T)
	// 		pick = f(idx,T-denominations[idx],denominations,dp);
	// 	return dp[idx][T]=pick+notpick;
	// }
	
}


// https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471?source=youtube&campaign=striver_dp_videos&leftPanelTabValue=PROBLEM