class Solution {
    public int integerBreak(int n) {
        // if(n<=3)
        //     return n-1;
        // int ans=0;
        // for(int i=1;i<=n;i++){
        //     int q = n/i;
        //     int rem = n%i;
        //     int sum=1;
        //     if(rem==1)
        //         q-=1;
        //     while(q-->0){
        //         sum*=i;
        //     }
        //     if(rem==1){
        //         sum*=(i+rem);
        //     }
        //     else if(rem!=0)
        //     sum *= (rem);
            
        //     ans = Math.max(sum,ans);
        //     System.out.println(sum);
        // }
        // return ans;
        if(n<=3)
            return n-1;
        int quot= n/3;
        int rem = n%3;
        int ans=1;
        if(rem==1){
            ans = (int)Math.pow(3,quot-1)*4;
        }else if(rem==0){
            ans = (int)Math.pow(3,quot);
        }else
            ans = (int)Math.pow(3,quot)*rem;
        return ans;
    }
}