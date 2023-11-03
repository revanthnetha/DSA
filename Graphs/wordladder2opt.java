class Solution {
    class Pair{
        String s;
        int d;
        public Pair(String s,int d){
            this.s = s;
            this.d = d;
        }
    }

    public void dfs(String endWord,HashMap<String,Integer> hm, String beginWord,List<List<String>> ans,ArrayList<String> a){
        if(hm.containsKey(endWord)){
        int d = hm.get(endWord);
        if(endWord.equals(beginWord)){
            a.add(endWord);
            Collections.reverse(a);
            ans.add(new ArrayList<>(a));
            Collections.reverse(a);
            a.remove(a.size()-1);
        }
        for(int i=0;i<endWord.length();i++){
            for(char ch='a';ch<='z';ch++){
                StringBuilder sb = new StringBuilder(endWord);
                sb.setCharAt(i,ch);
                if(hm.containsKey(sb.toString()) && hm.get(sb.toString()) == d-1){
                    a.add(endWord);
                    dfs(sb.toString(),hm,beginWord,ans,a);
                    a.remove(a.size()-1);
                }
            }
        }
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        HashSet<String> st = new HashSet<>();
        hm.put(beginWord,0);
        for(String k : wordList)
            st.add(k);
        q.add(new Pair(beginWord,0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            String s = p.s;
            int d = p.d;
            if(s.equals(endWord)){
                break;
            }
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i,ch);
                    if(st.contains(sb.toString())){
                        q.add(new Pair(sb.toString(),d+1));
                        if(!hm.containsKey(sb.toString()))
                        hm.put(sb.toString(),d+1);
                        st.remove(sb.toString());
                    }
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> a= new ArrayList<>();
        dfs(endWord,hm,beginWord,ans,a);
    return ans;
    }
}