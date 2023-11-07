class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int time[] = new int[dist.length];
        for(int i=0;i<dist.length;i++){
            time[i] = (dist[i]-1)/speed[i];
        }
        Arrays.sort(time);
        int ans=0;
        int t=0;
        for(int i=0;i<time.length;i++){
            if(t<=time[i]){
                t++;
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}