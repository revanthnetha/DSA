import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int sum=0;
		for(int ele : arr)
			sum+=ele;
		int s=d+sum;
		if(s%2!=0)
			return 0;
		s = s/2;
		int prev[] = new int[s+1];
		int mod = (int)Math.pow(10,9)+7;
		if(arr[0]==0) prev[0] = 2;
		else prev[0] =1;
		if(arr[0]!=0 && arr[0]<=s)
			prev[arr[0]]=1;
		for(int i=1;i<arr.length;i++){
			int curr[] = new int[s+1];
			for(int j=0;j<=s;j++){
				int notpick = prev[j];
				int pick = 0;
				if(j>=arr[i])
					pick = prev[j-arr[i]];
				curr[j]=(pick+notpick)%mod;
				}
				prev = curr;
		}	
		return prev[s]%mod;
	}

	public static int f(int idx,int s,int arr[],int dp[][]){
		if(idx==0){
		if(s==0 && arr[0]==0)
			return 2;
		if(s==0 || arr[0]==s)
			return 1;
		return 0;
		}
             
		if(dp[idx][s]!=-1)
			return dp[idx][s];

		int notpick = f(idx-1,s,arr,dp);
		int pick = 0;
		if(s>=arr[idx])
			pick = f(idx-1,s-arr[idx],arr,dp);
		return dp[idx][s]=pick+notpick;
	}
}