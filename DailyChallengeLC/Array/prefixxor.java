class Solution {
    public int[] findArray(int[] pref) {
        int ans[] = new int[pref.length];
        ans[0] = pref[0];
        int prev = ans[0];
        for(int i=1;i<pref.length;i++){
            ans[i] = prev^pref[i];
            prev = ans[i]^prev;
        }
        return ans;
    }
}

// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/