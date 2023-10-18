class Solution {

    public void dfs(int node,Stack<Integer> st, int vis[],ArrayList<ArrayList<Integer>> a){
        vis[node]=1;
        for(int ele : a.get(node)){
            if(vis[ele]==0){
                dfs(ele,st,vis,a);
            }
        }
        st.push(node);
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<>());
        }
        for(int ele[] : relations){
            a.get(ele[0]).add(ele[1]);
        }

        int vis[] = new int[n+1];
        Stack<Integer> st = new Stack<>();
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                dfs(i,st,vis,a);
            }
        }
        int dis[] = new int[n+1];
        for(int i=1;i<=n;i++)
            dis[i] = time[i-1];
            int max=0;
        while(!st.isEmpty()){
            int ele = st.pop();
            int currd = dis[ele];
            for(int k : a.get(ele)){
                int d = time[k-1];
                if(currd+d>dis[k]){
                    dis[k] = currd+d;
                }
            }
        }
        for(int i=1;i<=n;i++){
            max = Math.max(max,dis[i]);
        }
        return max;
    }
}

// https://leetcode.com/problems/parallel-courses-iii/submissions/?envType=daily-question&envId=2023-10-18