class Solution {

    class Pair{
        String node;
        int d;
        public Pair(String node,int d){
            this.node = node;
            this.d = d;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> s1 = new HashSet<>();
        for(String s : wordList)
            s1.add(s);
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p = q.remove();
            String s = p.node;
            int d = p.d;
            if(s.equals(endWord))
                return d;
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i,ch);
                String k = sb.toString();
                if(s1.contains(k)){
                    q.add(new Pair(k,d+1));
                    s1.remove(k);
                }
                }
            }
        }
        return 0;
    }
}

// https://leetcode.com/problems/word-ladder/description/