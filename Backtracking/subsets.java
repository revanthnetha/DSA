class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int N = nums.length;
        f(nums,0,N,a,ans);
        return ans;
    }

    public void f(int[] nums,int idx,int N, List<Integer> a,List<List<Integer>> ans ){
        if(idx>=N){
                ans.add(new ArrayList<>(a));
            return;
        }
        a.add(nums[idx]);
        f(nums,idx+1,N,a,ans);
        a.remove(a.size()-1);
        f(nums,idx+1,N,a,ans);
    }
}