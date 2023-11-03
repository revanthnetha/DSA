class Solution {
    public boolean backspaceCompare(String s, String t) {
     String a = back(s);
     String b = back(t);
     return a.equals(b); 
    }

    public String back(String l){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<l.length();i++){
            if(l.charAt(i)=='#'){
             if (!st.isEmpty())
                st.pop();
            }
            else
            st.push(l.charAt(i));
        }
        if(st.isEmpty())
            return " ";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}