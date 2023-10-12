/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l=0;
        int r= mountainArr.length()-1;
        int peakidx = peak(0,r-1,mountainArr);
        int first = lower(l,peakidx,target,mountainArr);
        int second = upper(peakidx+1,r,target,mountainArr);
        return first==-1 ? second : first;
    }

    public int peak(int l,int r,MountainArray mountainArr){
        while(l!=r){
            int mid = l +(r-l)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                l = mid+1;
            }else
                r= mid;
        }
        return l;
    }
    public int lower(int l,int r,int target,MountainArray mountainArr){
        int ans=-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(mountainArr.get(mid)==target){
                ans = mid;
                r = mid-1;
            }
            else if(mountainArr.get(mid)>target){
                r = mid-1;
            }else
                l = mid+1;
        }
        return ans;
    }
     public int upper(int l,int r,int target,MountainArray mountainArr){
         int ans=-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(mountainArr.get(mid)==target){
                ans = mid;
                r = mid-1;
            }
            else if(mountainArr.get(mid)>target){
                l = mid+1;
            }else
                r = mid-1;
        }
        return ans;
    }
}