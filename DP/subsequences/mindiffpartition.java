//space optimization

public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
		int sum=0;
		for(int ele : arr)
			sum+=ele;
		boolean prev[]=new boolean[sum+1];
		if(arr[0]<=sum)
			prev[arr[0]] = true;
		for(int idx=1;idx<n;idx++){
			boolean curr[] = new boolean[sum+1];
			curr[0] = true;
			for(int tar=1;tar<=sum;tar++){
				boolean notpick=prev[tar];
				boolean pick=false;
				if(tar>=arr[idx])
					pick =prev[tar-arr[idx]];
				curr[tar] =  pick || notpick;
			}
			prev=curr;
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<=sum/2;i++){
			if(prev[i]==true){
				int s1=i;
				int s2=sum-i;
				min = Math.min(min,Math.abs(s2-s1));
			}
		}
		return min;

    }
}

//tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		int sum=0;
		for(int i :arr) sum+=i;
		boolean dp[][] = new boolean[n][sum+1];
		for(int i=0;i<n;i++) dp[i][0] = true;
		if(arr[0]<=sum) dp[0][arr[0]] = true;

		for(int i=1;i<n;i++){
			for(int j=1;j<=sum;j++){
				boolean nt = dp[i-1][j];
				boolean take = false;
				if(arr[i]<=j) take = dp[i-1][j-arr[i]];
				dp[i][j] = take || nt;
			}
		}

		int k=0;
		for(int i=sum/2;i<=sum;i++){
			if(dp[n-1][i]==true){
				k=i;
				break;
			}
		}
		int l = sum-k;
		return Math.abs(l-k);
	}

}

//just check the last row.