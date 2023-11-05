class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currsum = 0;
        for (int i = 0; i < k; i++) {
            currsum += nums[i];
        }
        double ans = currsum;
        
        for (int i = k; i < nums.length; i++) {
            currsum += nums[i] - nums[i-k];
            ans = Math.max(ans,currsum);
        }

        return ans/k;
    }
}
