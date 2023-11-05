class Solution {
    // class Pair{
    //     int round;
    //     int count;
    //     public Pair(int round,int count){
    //         this.round = round;
    //         this.count = count;
    //     }
    // }
    public int getWinner(int[] arr, int k) {

        int winner = Math.max(arr[0],arr[1]);
        int c = 1;
        for(int i=2;i<arr.length;i++){
            if(c==k)
                return winner;
            if(winner>arr[i])
                c++;
            else{
                winner = arr[i];
                c=1;
            }
        }
        return winner;
        // ArrayList<Integer> a = new ArrayList<>();
        // for(int ele : arr)
        //     a.add(ele);
        // HashMap<Integer,Pair> hm = new HashMap<>();
        // int r=1;
        // while(r<=a.size()){
        //     int f = a.get(0);
        //     int s = a.get(1);
        //     int ele = f>s ? 1 : 0;
        //     int l = a.get(ele);
        //     a.remove(ele);
        //     a.add(l);
        //     if(k==1)
        //         return a.get(0);
        //     if(!hm.containsKey(a.get(0))){
        //         hm.put(a.get(0),new Pair(r,1));
        //     }else{
        //         Pair p = hm.get(a.get(0));
        //         if(p.count+1==k){
        //             return a.get(0);
        //         }
        //         hm.remove(a.get(0));
        //         if(p.round+1==r){
        //             hm.put(a.get(0),new Pair(r,p.count+1));
        //         }else{
        //             hm.put(a.get(0),new Pair(r,1));
        //         }
        //     }
        //     r++;
        // }
        // return a.get(0);
    }
}

// return Arrays.stream(arr).max().getAsInt();