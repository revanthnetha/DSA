class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       int indegree[] = new int[V];
       Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<V;i++){
           for(int ele : adj.get(i)){
               indegree[ele]++;
           }
       }
       for(int i=0;i<V;i++){
           if(indegree[i]==0)
            q.add(i);
       }
       int ans[] = new int[V];
       int i=0;
       while(!q.isEmpty()){
           int k = q.remove();
           ans[i++]=k;
           for(int ele : adj.get(k)){
               indegree[ele]--;
               if(indegree[ele]==0)
                q.add(ele);
           }
       }
       return ans;
    }
}

