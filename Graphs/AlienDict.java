class Solution
{
    public void compare(String s1,String s2,ArrayList<ArrayList<Integer>> a){
        int k=0;
        while(k<s1.length() && k<s2.length()){
            if(s1.charAt(k)==s2.charAt(k))
                k++;
            else{
                int n1 = s1.charAt(k)-'a';
                int n2 = s2.charAt(k) -'a';
                a.get(n1).add(n2);
                return;
            }
        }
    }
    
    public void dfs(int i,Stack<Integer> st,ArrayList<ArrayList<Integer>> a,int vis[]){
        vis[i]=1;
        for(int ele : a.get(i)){
            if(vis[ele]==0)
            dfs(ele,st,a,vis);
        }
         st.add(i);
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0;i<K;i++)
            a.add(new ArrayList<>());
        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            compare(s1,s2,a);
        }
        
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[K];
        for(int i=0;i<K;i++){
            if(vis[i]==0)
                dfs(i,st,a,vis);
        }
        String ans="";
        while(!st.isEmpty()){
            ans += (char)(st.pop()+'a');
        }
        return ans;
        
    }
}

// https://practice.geeksforgeeks.org/problems/alien-dictionary/1
