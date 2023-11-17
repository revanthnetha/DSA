class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer> f = new HashMap<>();
        HashMap<Character,Integer> e = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!f.containsKey(s.charAt(i)))
                f.put(s.charAt(i),i);
        }
        for(int i=s.length()-1;i>=0;i--){
            if(!e.containsKey(s.charAt(i)))
                e.put(s.charAt(i),i);
        }
        int ans=0;
        for(char ch='a';ch<='z';ch++){
            if(f.containsKey(ch)){
                int i1 = f.get(ch);
                int i2 = e.get(ch);
                if(i1+1<=i2 && i1+1<s.length()-1 && i2>=0){
                String s1 = s.substring(i1+1,i2);
                Set<Character> set = new HashSet<>();
                for (char c : s1.toCharArray()) {
                set.add(c);
                }
                ans += set.size();
            }
            }
        }
        return ans;
    }
}

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2023-11-14