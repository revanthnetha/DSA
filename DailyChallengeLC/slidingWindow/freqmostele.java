class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        long currsum=0;
        int ans=0;
        for(int right=0;right<nums.length;right++){
            currsum+=(long)nums[right];
            while(currsum+k<(long)nums[right]*(right-left+1)){
                currsum -= (long)nums[left];
                left++;
            }
            ans = Math.max(ans,(right-left+1));
        }
        return ans;
    }
}