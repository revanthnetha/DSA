//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair{
        int node;
        int d;
        public Pair(int node,int d){
            this.node = node;
            this.d = d;
        }
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        Queue<Pair> q = new LinkedList<>();
        int dis[] = new int[n];
        ArrayList<ArrayList<Integer>> a =new ArrayList<>();
        for(int i=0;i<n;i++)
            a.add(new ArrayList<>());
        for(int ele[] : edges){
            a.get(ele[0]).add(ele[1]);
            a.get(ele[1]).add(ele[0]);
        }
        q.add(new Pair(src,0));
        Arrays.fill(dis,(int)1e9);
        dis[src]=0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int d=p.d;
            for(int ele : a.get(p.node)){
                if(d+1<dis[ele]){
                    dis[ele] = d+1;
                    q.add(new Pair(ele,d+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dis[i]==(int)1e9)
                dis[i]=-1;
        }
        return dis;
    }
}
