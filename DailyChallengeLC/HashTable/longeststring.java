class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        HashMap<String,Integer> hm = new HashMap<>();
        int max=0;
        for(String s : words){
            int curr = 1;
            for(int i=0;i<s.length();i++){
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                String res = sb.toString();
                if(hm.containsKey(res)){
                    curr = Math.max(curr,hm.get(res)+1);
                }
            }
            hm.put(s,curr);
            max = Math.max(max,curr);
        }
        return max;
    }
}