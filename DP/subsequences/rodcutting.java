public class Solution {
	public static int cutRod(int price[], int n) {
		int cut[] = new int[n];
		for(int i=0;i<n;i++)
			cut[i] = i+1;
		int dp[][] = new int[n][n+1];
		for(int i=0;i<n;i++){
			for(int j=0;j<=n;j++){
				dp[i][j]=-1;
			}
		}
		return f(n-1,price,n,cut,dp);
	}

	public static int f(int idx,int price[],int n,int cut[],int dp[][]){
		if(idx==0){
			if(n%cut[0]==0){
				return (n/cut[0])*price[cut[idx]-1];
			}
			return 0;
		}
		if(dp[idx][n]!=-1)
			return dp[idx][n];
		int notpick = f(idx-1,price,n,cut,dp);
		int pick = 0;
		if(n>=cut[idx]){
			pick = price[cut[idx]-1] + f(idx,price,n-cut[idx],cut,dp);
		}
		return dp[idx][n]=Math.max(pick,notpick);
	}
}

//tabulation
public static int cutRod(int price[], int n) {
	int cut[] = new int[n];
	for(int i=0;i<n;i++)
		cut[i] = i+1;
	int dp[][] = new int[n][n+1];
	for(int i=0;i<=n;i++){
		if(i%cut[0]==0){
			dp[0][i] = (i/cut[0])*price[cut[0]-1];
		}else{
			dp[0][i] = 0;
		}
	}
	for(int i=1;i<n;i++){
		for(int j=0;j<=n;j++){
			int notpick = dp[i-1][j];
			int pick = 0;
			if(j>=cut[i]){
				pick = price[cut[i]-1] + dp[i][j-cut[i]];
			}
			dp[i][j]=Math.max(pick,notpick);
		}
	}
	return dp[n-1][n];
}

//space optimizationn 

	public static int cutRod(int price[], int n) {
		int cut[] = new int[n];
		for(int i=0;i<n;i++)
			cut[i] = i+1;
		int prev[] = new int[n+1];
		for(int i=0;i<=n;i++){
			if(i%cut[0]==0){
				prev[i] = (i/cut[0])*price[cut[0]-1];
			}else{
				prev[i] = 0;
			}
		}
		for(int i=1;i<n;i++){
			int curr[] = new int[n+1];
			for(int j=0;j<=n;j++){
				int notpick = prev[j];
				int pick = 0;
				if(j>=cut[i]){
					pick = price[cut[i]-1] + curr[j-cut[i]];
				}
				curr[j]=Math.max(pick,notpick);
			}
			prev = curr;
		}
		return prev[n];
	}
