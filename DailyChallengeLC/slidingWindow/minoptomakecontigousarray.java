class Solution {
    public int minOperations(int[] nums) {
       int n = nums.length;
       Set<Integer> st = new HashSet<>();
       for(int ele : nums)
        st.add(ele);
    // To get the unique elements we are taking an hashset
      int ans[] = new int[st.size()];
      int k=0;
      for(int ele : st){
          ans[k++]=ele;
      }
      //sorting the array to perform sliding window approch 
      Arrays.sort(ans);
      int end=0;
      int max=0;
      //take one ele as start
      for(int start=0;start<k;start++){
          // For every ele of start check the maximum candidates count less than the last ele.
          while(end<k && ans[end]<ans[start]+n){
              end++;
          } 
          int count = end-start;
          //mmaximazing the count
          max = Math.max(count,max);
      }
      return n- max;
    }
}

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/
// leetcode hard 