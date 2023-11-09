class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele : nums)
            sum+=ele;
        if(sum%2!=0)
            return false;
        sum=sum/2;
        int n= nums.length;
        int dp[][] = new int[n][sum+1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return f(n-1,sum,nums,dp);
    }

    public boolean f(int idx,int sum,int nums[],int dp[][]){
        if(sum==0)
            return true;
        if(idx==0)
            return nums[0]==sum;
        if(dp[idx][sum]!=-1)
            return (dp[idx][sum] == 1) ? true : false;
        boolean notpick = f(idx-1,sum,nums,dp);
        boolean pick = false;
        if(sum>=nums[idx])
            pick = f(idx-1,sum-nums[idx],nums,dp);
        dp[idx][sum] = ((pick || notpick == true)? 1 : 0);
        return pick || notpick;
    }
}

//tabulation

 public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele : nums)
            sum+=ele;
        if(sum%2!=0)
            return false;
        sum=sum/2;
        int n= nums.length;
        boolean dp[][] = new boolean[n][sum+1];
        for(int i=0;i<n;i++)
            dp[i][0] = true;
        if(nums[0]<=sum)
            dp[0][nums[0]] = true;
        for(int idx=1;idx<n;idx++){
            for(int t=1;t<=sum;t++){
                boolean notpick = dp[idx-1][t];
                boolean pick = false;
                if(t>=nums[idx])
                    pick = dp[idx-1][t-nums[idx]];
                dp[idx][t] = pick || notpick == true; 
            }
        }
        return dp[n-1][sum];
    }

    //space optimization

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele : nums)
            sum+=ele;
        if(sum%2!=0)
            return false;
        sum=sum/2;
        int n= nums.length;
        boolean prev[] = new boolean[sum+1];
        if(nums[0]<=sum)
            prev[nums[0]] = true;
        for(int idx=1;idx<n;idx++){
            boolean curr[] = new boolean[sum+1];
            curr[0] = true;
            for(int t=1;t<=sum;t++){
                boolean notpick = prev[t];
                boolean pick = false;
                if(t>=nums[idx])
                    pick = prev[t-nums[idx]];
                curr[t] = pick || notpick; 
            }
            prev = curr;
        }
        return prev[sum];
    }