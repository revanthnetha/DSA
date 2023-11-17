class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<String,Integer> hm = new HashMap<>();
        return f(n-1,target,nums,hm);
    }

    public int f(int idx,int target,int nums[],HashMap<String,Integer> hm){
        if (idx < 0) {
            return (target == 0) ? 1 : 0;
        }
        String s = idx+","+target;
        if(hm.containsKey(s))
            return hm.get(s);
        int add  = f(idx-1,target-nums[idx],nums,hm);
        int sub = f(idx-1,target+nums[idx],nums,hm);
        hm.put(s,add+sub);
        return add+sub;
    }
}

//second approach ++ Easy Striver Solution ==> s1-s2  = T
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int t=0;
        for(int ele : nums)
            t+=ele;
        int k = (target+t)/2;
        if((target+t)%2!=0)
            return 0;
        return f(n-1,k,nums);
    }

    public int f(int idx,int T,int nums[]){
        if(idx==0){
            if(nums[0]==0 && T==0)
                return 2;
            if(T==0 || T==nums[0])
                return 1;
            return 0;
        }
        int notpick = f(idx-1,T,nums);
        int pick=0;
        if(T>=nums[idx])
            pick = f(idx-1,T-nums[idx],nums);
        return pick+notpick;
    }
}
