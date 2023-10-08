public class Solution {
    public int[] prevSmaller(int[] A) {
        int ans[]=new int[A.length];
       
        Stack<Integer>s = new Stack<>();
       
        for(int i=0;i<A.length;i++){
            while(!s.isEmpty() && s.peek()>=A[i]){
                s.pop();
            }
           
            if(s.isEmpty())ans[i]=-1;
            else ans[i]=s.peek();
           
            s.push(A[i]);
        }
        return ans;
    }
}