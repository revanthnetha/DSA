class Solution {
    public boolean dfs(int root,int leftChild[],int rightChild[],int vis[]){
        vis[root] = 1;
        if(leftChild[root]!=-1){
            if(vis[leftChild[root]]==1)
                return false;
            if(dfs(leftChild[root],leftChild,rightChild,vis)==false)
                return false;
        }
        if(rightChild[root]!=-1){
            if(vis[rightChild[root]]==1)
                return false;
            if(dfs(rightChild[root],leftChild,rightChild,vis)==false)
                return false;
        }
        return true;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
       // Find the root node and then do the BFS.
       int vis[]  =new int[n];
       for(int i=0;i<n;i++){
           if(leftChild[i]!=-1)
            vis[leftChild[i]] = 1;
           if(rightChild[i]!=-1)
            vis[rightChild[i]] = 1;
       }
       int src=-1;
       int cnt=0;
       for(int i=0;i<n;i++){
           if(vis[i]==0){
               src = i;
               cnt++;
           }
       }
       if(cnt!=1)
            return false;
        Queue<Integer> q = new LinkedList<>();
         Arrays.fill(vis,0);
        boolean ans = dfs(src,leftChild,rightChild,vis);
        // q.add(src);
        // vis[src]=1;
        // while(!q.isEmpty()){
        //     int p = q.remove();
        //     if(leftChild[p]!=-1){
        //         if(vis[leftChild[p]]==1)
        //             return false;
        //         q.add(leftChild[p]);
        //         vis[leftChild[p]]=1;
        //     }
        //      if(rightChild[p]!=-1){
        //         if(vis[rightChild[p]]==1)
        //             return false;
        //         q.add(rightChild[p]);
        //         vis[rightChild[p]]=1;
        //     }
        // }
        for(int ele : vis){
            if(ele==0)
                return false;
        }
        return ans;

    }
}