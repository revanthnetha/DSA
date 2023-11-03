//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int row;
        int dis;
        public Pair(int row,int dis){
            this.row = row;
            this.dis = dis;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        int d[] = new int[100000];
        Arrays.fill(d,Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        d[start]=0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int dis = p.dis;
            
            if(row==end){
                return dis;
            }
            
            for(int ele : arr){
                int k = ele*row;
                if(k>99999)
                    k = k%100000;
                if(dis+1 < d[k]){
                    d[k] = dis+1;
                    q.add(new Pair(k,dis+1));
                }
            }
        }
        return -1;
    }
}
