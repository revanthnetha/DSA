

//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair{
    int d;
    Node node;
    Pair(Node node,int d){
        this.node = node;
        this.d = d;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> a = new ArrayList<>();
        if(root==null)
            return a;
        Map<Integer,Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            Node curr = p.node;
            int d = p.d;
            if(mp.get(d)==null){
                mp.put(d,curr.data);
            }
            if(curr.left!=null){
                q.add(new Pair(curr.left,d-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right,d+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            a.add(entry.getValue());
        }
        return a;
    }
}