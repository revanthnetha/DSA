class Solution {
    public void left(int heights[],int lefts[]){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty())
                lefts[i] = 0;
            else
                lefts[i] = st.peek()+1;
            st.push(i);
        }
    }

    public void right(int heights[],int rights[]){
        Stack<Integer> st = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty())
                rights[i] = heights.length-1;
            else
                rights[i] = st.peek()-1;
            st.push(i);
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int lefts[] = new int[n];
        int rights[] = new int[n];
        left(heights,lefts);
        right(heights,rights);
        int area = 0;
        for(int i=0;i<n;i++){
            area = Math.max(area,(rights[i]-lefts[i]+1)*heights[i]);
        }
        return area;
    }
}