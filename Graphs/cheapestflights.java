class Solution {

    class Pair{
        int node;
        int dis;
        int steps;
        public Pair(int node,int dis,int steps){
            this.node = node;
            this.dis = dis;
            this.steps = steps;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)    
            adj.add(new ArrayList<>());
        for(int ele[] : flights){
            adj.get(ele[0]).add(new Pair(ele[1],ele[2],0));
        }
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src,0,0));
        int d[] = new int[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[src]=0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int dis = p.dis;
            int steps = p.steps;

            if(steps<=k){
            for(Pair ele : adj.get(node)){
                if(dis+ele.dis<=d[ele.node]){
                d[ele.node] = dis+ele.dis;
                pq.add(new Pair(ele.node,dis+ele.dis,steps+1));
                }
            }
            }
        }
        if(d[dst]==Integer.MAX_VALUE)
        return -1;
        return d[dst];
    }
}