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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        return f(preorder,inorder,0,n-1,0,n-1,hm,n);
    }

    public TreeNode f(int[] preorder,int[] inorder,int ps,int pe,int is,int ie,HashMap<Integer,Integer> hm,int n){
        if(ps>pe || is>ie || ie<0 || pe<0 || is>=n || ps>=n)
            return null;
        int idx= hm.get(preorder[ps]);
        int numsleft = idx-is;
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = f(preorder,inorder,ps+1,ps+numsleft,is,idx-1,hm,n);
        root.right = f(preorder,inorder,ps+numsleft+1,pe,idx+1,ie,hm,n);
        return root;
    }
}