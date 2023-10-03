class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
       int n1 = nums1.length;
       int n2 = nums2.length;
       if(n1>n2) return findMedianSortedArrays(nums2, nums1);
       int l = 0;
       int h = n1;
       int part = (n1+n2+1)/2;
       double ans=0;
       while(l<=h){
           int cut1 = (l+h)/2;
           int cut2 = part-cut1;
           int l1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
           int l2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
           int r1 = cut1==n1 ? Integer.MAX_VALUE : nums1[cut1];
           int r2 = cut2==n2 ? Integer.MAX_VALUE : nums2[cut2];
           if(l1<=r2 && l2<=r1){
               if((n1+n2)%2==0){
                   ans = (double)(Math.max(l1,l2) + Math.min(r1,r2))/2.0;
               }else
                ans = (double)Math.max(l1,l2);
                return ans;
           }else if(l1>r2)
            h = cut1-1;
            else
            l = cut1+1;
       }    
       return 0.0;
    }
}