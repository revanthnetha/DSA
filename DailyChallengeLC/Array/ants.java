class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
       int max =0;
       for(int ele : left)
        max = Math.max(max,ele);
        for(int ele : right)
        max = Math.max(max,n-ele);
        return max;
    }
}