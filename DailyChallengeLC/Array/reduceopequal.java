class Solution {
    public int reductionOperations(int[] nums) {
       HashSet<Integer> st = new HashSet<>();
       for(int ele : nums){
           st.add(ele);
       } 
       int n = st.size()-1;
       Arrays.sort(nums);
      int s= nums[0];
      int ans=0;
       for(int i=nums.length-1;i>=1;i--){
           if(nums[i]==s)
            break;
           if(nums[i]!=nums[i-1]) n--;
           ans+= n;
       }
       return ans;
    }
}

    // public int reductionOperations(int[] nums) {
    //     Arrays.sort(nums);
    //     int res=0;
    //     int curr=0;
    //     for(int i=1; i<nums.length; i++){
    //         if(nums[i]>nums[i-1]){
    //             curr++;
    //         }
    //         res = res + curr;
    //     }
    //     return res;
    // }

    // https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/description/