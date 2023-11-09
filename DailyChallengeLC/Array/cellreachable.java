class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx && sy==fy && t==1)
            return false;
        // if(sy==fy)
        //     return Math.abs(sx-fx)<=t;
        // if(sx==fx)
        //     return Math.abs(sy-fy)<=t;
        int l = Math.abs(sx-fx);
        int b = Math.abs(sy-fy);
        int d = Math.abs(b-l);
        // int d = Math.max(l,b)-Math.min(l,b);
        if(d+Math.min(l,b)<=t)
            return true;
        return false;
    }
}