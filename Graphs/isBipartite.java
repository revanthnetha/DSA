class Solution {
    public boolean check(int start,int graph[][],int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int ele : graph[curr]){
                if(color[ele]==-1){
                    color[ele] = (color[curr]==0)? 1 : 0;
                    q.add(ele);
                }else{
                    if(color[ele]==color[curr])
                        return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int start,int graph[][],int color[],int c){
        color[start] = c;
        for(int ele : graph[start]){
            if(color[ele]==-1){
                if(dfs(ele,graph,color,1-c)==false)
                    return false;
            }else if(color[ele]==c)
                    return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int color[] = new int[m];
        Arrays.fill(color,-1);
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(dfs(i,graph,color,0)==false)
                    return false;
            }
        }
        return true;
    }
}