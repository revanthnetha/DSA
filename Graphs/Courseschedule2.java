class Solution {
     public boolean dfs(int node,int vis[],ArrayList<ArrayList<Integer>> a,int pathvis[],Stack<Integer> st){
        vis[node]=1;
        pathvis[node]=1;
        for(int ele : a.get(node)){
            if(vis[ele]==0){
                if(dfs(ele,vis,a,pathvis,st)==true)
                    return true;
            }else if(pathvis[ele]==1){
                return true;
            }
        }
        st.push(node);
        pathvis[node]=0;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++)
            a.add(new ArrayList<>());
        int vis[] = new int[numCourses];
        int pathvis[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int l = prerequisites[i][0];
            int r = prerequisites[i][1];
            a.get(r).add(l);
        }
        int ans[] = new int[numCourses];
        for(int i=0;i<a.size();i++){
            if(vis[i]==0){
                if(dfs(i,vis,a,pathvis,st)==true){
                    return (new int[0]);
                }
            }
        }
        int i=0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
    }
