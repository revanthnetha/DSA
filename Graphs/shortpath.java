//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair{
        int node;
        int d;
        public Pair(int node,int d){
            this.node = node;
            this.d = d;
        }
    }
    
    //2 O(N+M)
    public void dfs(int i,ArrayList<ArrayList<Pair>> adj,int vis[],Stack<Integer> st){
        vis[i]=1;
        
        for(Pair p : adj.get(i)){
            if(vis[p.node]==0){
                dfs(p.node,adj,vis,st);
            }
        }
        st.push(i);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
	   ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	   for(int i=0;i<N;i++)
	    adj.add(new ArrayList<>());
	   for(int i=0;i<M;i++){
	
	           adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	   }
	   int vis[] = new int[N];
	   Stack<Integer> st = new Stack<>();
	   for(int i=0;i<N;i++){
	       if(vis[i]==0){
	           dfs(i,adj,vis,st);
	       }
	   }
	   int dis[] = new int[N];
	   Arrays.fill(dis,(int)1e9);
	   dis[0]=0;
	   while(!st.isEmpty()){
	       int ele = st.pop();
	       int currdis = dis[ele];
	      
	       for(Pair p : adj.get(ele)){
	           int d = p.d;
	           if(currdis+d<dis[p.node])
	           dis[p.node] = currdis+d;
	       }
	       
	   }
	   for(int i=0;i<N;i++){
	       if(dis[i]==(int)1e9)
	        dis[i]=-1;
	   }
	   return dis;
	}
}


// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1