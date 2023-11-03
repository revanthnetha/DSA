/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    class Pair{
        int sum;
        int cnt;
        public Pair(int sum,int cnt){
            this.sum = sum;
            this.cnt = cnt;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        f(root);
        return ans;
    }

    public Pair f(TreeNode root){
        if(root==null) {
            return new Pair(0,0);
        }

        Pair left = f(root.left);
        Pair right = f(root.right);
        int sum = root.val + left.sum + right.sum;
        int cnt = 1 + left.cnt + right.cnt;
        if(root.val == sum/cnt)
            ans++;
        return new Pair(sum,cnt);
    }

    // public void f(TreeNode root){
    //     if(root==null)
    //         return;
    //     f(root.left);
    //     ArrayList<Integer> a = new ArrayList<>();
    //     avg(root,a);
    //     int sum =0;
    //     for(int ele : a)
    //         sum+=ele;
    //     int n = a.size();
    //     if(root.val == ((sum)/n))
    //         ans++;
    //     f(root.right);
    // }

    // public void avg(TreeNode root,ArrayList<Integer> a){
    //      if(root==null)
    //         return;
    //     avg(root.left,a);
    //     a.add(root.val);
    //     avg(root.right,a);
    // }
}