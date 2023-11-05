//{ Driver Code Starts
import java.util.*;

import Recursion.Solution;

import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    class Pair{
        int node;
        int d;
        public Pair(int node,int d){
            this.node = node;
            this.d = d;
        }
    }
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       PriorityQueue<Pair> hm = new PriorityQueue<>((x,y)->x.d-y.d);
       hm.add(new Pair(S,0));
       
       int dis[] = new int[V];
       Arrays.fill(dis,(int)1e9); 
       dis[S] = 0;
       while(!hm.isEmpty()){
           Pair p = hm.remove();
           int node = p.node;
           int d = p.d;
           
           for(int i=0;i<adj.get(node).size();i++){
                   int currd = adj.get(node).get(i).get(1);
                   int currn = adj.get(node).get(i).get(0);
                   
                   if(currd+d<dis[currn]){
                    //   if(dis[currn]!=(int)1e9){
                    //       hm.remove(new Pair(currn,dis[currn]));
                    //   }
                       dis[currn]=currd+d;
                       hm.add(new Pair(currn,dis[currn]));
                   }
               
           }
       }
       return dis;
    }
}


// https://youtu.be/3dINsjyfooY?si=B8CW6Qw-7I7TkE1Q
//time : Elog(V)