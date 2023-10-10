class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[2];
        int n = nums.length;
        Arrays.fill(a,-1);
        int ans=-1;
        int l =0;
        int h = n-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid]==target){
                ans=mid;
                //to calculate the lowest index
                h=mid-1;
            }
            else if(nums[mid]<target)
                l = mid+1;
            else
                h = mid-1;
        }
        a[0]=ans;
         ans=-1;
         l =0;
         h = n-1;

         while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid]==target){
                ans=mid;
                //to calculate the higehst index
                l=mid+1;
            }
            else if(nums[mid]<target)
                l = mid+1;
            else
                h = mid-1;
        }
        a[1]=ans;
       
          return a;  

    }
}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int leftIndex = binarySearch(nums, target, true);
//         int rightIndex = binarySearch(nums, target, false);

//         if (leftIndex <= rightIndex) {
//             return new int[]{leftIndex, rightIndex};
//         } else {
//             return new int[]{-1, -1};
//         }
//     }

//     private int binarySearch(int[] nums, int target, boolean findLeft) {
//         int low = 0;
//         int high = nums.length - 1;
//         int index = -1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             if (nums[mid] == target) {
//                 index = mid;
//                 if (findLeft) {
//                     high = mid - 1;
//                 } else {
//                     low = mid + 1;
//                 }
//             } else if (nums[mid] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return index;
//     }
// }