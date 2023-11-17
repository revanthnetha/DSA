class Solution {
    public int minPairSum(int[] nums) {
        // Arrays.sort(nums);
        // int p1=0;
        // int p2=nums.length-1;
        // int max=0;
        // while(p1<p2){
        //     max = Math.max(nums[p1]+nums[p2],max);
        //     p1++;
        //     p2--;
        // }
        // return max;
        int freq[] = new int[100001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans= Integer.MIN_VALUE;
        for(int ele : nums){
            min = Math.min(ele,min);
            max = Math.max(max,ele);
            freq[ele]++;
        }
        while(min<=max){
            if(freq[min]==0)
                min++;
            else if(freq[max]==0) max--;
            else{
                ans = Math.max(ans,min+max);
                freq[min]--;
                freq[max]--;
            }
        }
        return ans;
    }
}

// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/?envType=daily-question&envId=2023-11-17

// get familiar with the frequency map instead of sorting in certain cases to optimize the TC.
// SC->O(n)