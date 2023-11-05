class Solution {
    public int rob(int[] nums) {
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

    //memoization
    // public int f(int idx,int nums[],int dp[]){
    //     if(idx>=nums.length)
    //         return 0;
    //     if(dp[idx]!=-1)
    //         return dp[idx];
    //     int pick = nums[idx]+f(idx+2,nums,dp);
    //     int notpick = f(idx+1,nums,dp);
    //     return dp[idx]= Math.max(pick,notpick);
    // }
}

//tabulation
//  public int rob(int[] nums) {
//      int dp[] = new int[nums.length];
//      Arrays.fill(dp,0);
//      dp[0] = nums[0];
//       int n = nums.length;
    
//       if (n == 1) {
//         return nums[0];
//     }
//      dp[1] = Math.max(nums[0], nums[1]);
//      for(int i=2;i<nums.length;i++){
//         int pick = i>=2 ? nums[i]+dp[i-2] : Integer.MIN_VALUE;
//         int notpick = dp[i-1];
//         dp[i] = Math.max(pick,notpick);
//      }
//      return dp[nums.length-1];
//     }
