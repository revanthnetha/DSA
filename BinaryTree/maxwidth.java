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
    class Pair{
        TreeNode node;
        int col;
        public Pair(TreeNode node,int col){
            this.node= node;
            this.col = col;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        q.add(null);
        int ans = 0;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(p==null){
                ans = Math.max(ans,r-l+1);
                l = Integer.MAX_VALUE;
                r = Integer.MIN_VALUE;
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                 TreeNode curr = p.node;
                 int col = p.col;
                 l = Math.min(l,col);
                 r = Math.max(r,col);
                if(curr.left!=null) 
                    q.add(new Pair(curr.left,2*col+1));
                if(curr.right!=null)
                    q.add(new Pair(curr.right,2*col+2));
            }
            
        }
        return ans;
    }
}