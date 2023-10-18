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
        int row;
        int col;
        public Pair(TreeNode node,int row,int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> a = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> hm = new TreeMap<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode node= p.node;
            int row = p.row;
            int col = p.col;
            if(!hm.containsKey(col))
                hm.put(col,new TreeMap<>());
            if(!hm.get(col).containsKey(row))
                hm.get(col).put(row,new ArrayList<>());
            hm.get(col).get(row).add(node.val);
            if(node.left!=null){
                q.add(new Pair(node.left,row+1,col-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,row+1,col+1));
            }
        }
        int l = hm.size();
        for(TreeMap<Integer,ArrayList<Integer>> t : hm.values()){
            ArrayList<Integer> a1 = new ArrayList<>();
            for(ArrayList<Integer> k : t.values()){
                Collections.sort(k);
                a1.addAll(k);
            }
            a.add(a1);
        }
        return a;
    }
}
