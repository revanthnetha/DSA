class Solution {
    public int majorityElement(int[] nums) {
       int ans=0;
       //moore algorithm
       int ele=nums[0];
       int ptr = 1;
       for(int i=1;i<nums.length;i++){
           if(ptr==0){
                ele = nums[i];
                ptr = 1;
            }else{
           if(ele == nums[i])
            ptr++;
            else
            ptr--;
            }
       }

        return ele;
    }
}
