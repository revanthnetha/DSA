class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int num=0;
        // for(int ele : nums){
        //     num ^= ele;
        // }
        // return num;
        //Apply B.S
        int n= nums.length;
        int l=1;
        int r = n-2;
        if(n==1)
            return nums[0];
        if(nums[0]!=nums[1])
            return nums[0];
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            else if((mid%2==0 && nums[mid]==nums[mid-1]) || (mid%2==1 && nums[mid]==nums[mid+1]))
                r = mid-1;
            else
                l = mid+1;
        }
        return -1;
    }
}
//0,1,2,3,4,5,6,7,8
//[1,1,2,3,3,4,4,8,8]
//e o idx o e o e o e o e
