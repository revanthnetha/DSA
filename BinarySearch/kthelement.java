class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m) return kthElement( arr2, arr1, m, n, k);
        int l = Math.max(0,k-n);
       int h = Math.min(k,n);
        while(l<=h){
            int cut1 = (l+h)/2;
            int cut2 = k - cut1;
            int l1 = cut1<=0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2 = cut2<=0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int r1 = cut1>=n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2>=m ? Integer.MAX_VALUE : arr2[cut2];
            if(l1<=r2 && l2<=r1){
                return (long)Math.max(l1,l2);
            }
            else if(l1>r2)
                h = cut1-1;
            else
                l = cut1+1;
        }
        return 0;
    }
}