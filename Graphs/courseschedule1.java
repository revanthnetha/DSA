class Solution {
    public boolean dfs(int node,int vis[],ArrayList<ArrayList<Integer>> a,int pathvis[]){
        vis[node]=1;
        pathvis[node]=1;
        for(int ele : a.get(node)){
            if(vis[ele]==0){
                if(dfs(ele,vis,a,pathvis)==true)
                    return true;
            }else if(pathvis[ele]==1){
                return true;
            }
        }
        pathvis[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            a.add(new ArrayList<>());
        int vis[] = new int[numCourses];
        int pathvis[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int l = prerequisites[i][0];
            int r = prerequisites[i][1];
            a.get(r).add(l);
        }
        for(int i=0;i<a.size();i++){
            if(vis[i]==0){
                if(dfs(i,vis,a,pathvis)==true){
                    return false;
                }
            }
        }
        return true;
    }
}