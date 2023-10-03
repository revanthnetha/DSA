class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0;
        int r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target)
                return mid;
        //one of the half is sorted- half kosame check chesthunav
        //left part sorted
            if(nums[l]<=nums[mid]){
                //left half loo ele unda 
                if(nums[l]<=target && target<nums[mid])
                    r = mid-1;
                else
                    l = mid+1;
            }else{
                //right part sorted
                //right part loo ele undaa
                if(nums[r]>=target && nums[mid]<target)
                    l=mid+1;
                else
                    r= mid-1;
            }
        }
        return -1;
    }
}