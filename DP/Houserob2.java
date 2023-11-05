class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int n= nums.length;
        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0)
                temp1[i-1] = nums[i];
            if(i!=n-1)
                temp2[i] = nums[i];
        }
        return Math.max(rob1(temp1),rob1(temp2));
    }

    //meoization

    // public int f(int idx,boolean rot,int nums[],int dp[]){
    //     if(rot && idx>nums.length-2){
    //         return 0;
    //     }
    //     if(!rot && idx>nums.length-1)
    //         return 0;
    //     if(dp[idx]!=-1)
    //         return dp[idx];
    //     int pick = nums[idx]+f(idx+2,rot,nums,dp);
    //     int notpick = f(idx+1,rot,nums,dp);
    //     return dp[idx]=Math.max(pick,notpick);
    // }
    public int rob1(int[] nums) {
      int n = nums.length;
      if(n == 1)
        return nums[0];
     int prev1 = nums[0];
     int prev = Math.max(nums[0], nums[1]);
     for(int i=2;i<nums.length;i++){
        int pick = nums[i]+prev1;
        int notpick = prev;
        int curr = Math.max(pick,notpick);
        prev1 = prev;
        prev = curr;
     }
     return prev;
    }
}

 // if(nums.length==1)
        //     return nums[0];
        // int dp[] = new int[nums.length];
        // Arrays.fill(dp,-1);
        // int max1 = f(0,true,nums,dp);
        //  Arrays.fill(dp,-1);
        // int max2 = f(1,false,nums,dp);
        // return Math.max(max1,max2);

    //circular -> just take first and last array as two parts