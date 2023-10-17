
class Pair{
    int d;
    Node node;
    Pair(Node node,int d){
        this.node = node;
        this.d = d;
    }
}

//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> a = new ArrayList<>();
        if(root==null)
            return a;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> mp = new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            Node curr = p.node;
            int d = p.d;
            if(mp.get(d)==null)
                mp.put(d,curr.data);
            if(mp.get(d)!=null)
                mp.replace(d,curr.data);
            if(curr.left!=null)
                q.add(new Pair(curr.left,d-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right,d+1));
        }
        
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            a.add(entry.getValue());
        }
            
        return a;
    }
    
}
