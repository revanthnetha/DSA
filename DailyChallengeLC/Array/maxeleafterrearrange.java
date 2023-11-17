class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > res) {
                ++res;
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/?envType=daily-question&envId=2023-11-15