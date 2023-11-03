//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Queue<ArrayList<String>> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for(String s : wordList)
            st.add(s);
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
         if (!st.contains(targetWord)) {
            return ans;
        }
        ArrayList<String> b = new ArrayList<>();
        b.add(startWord);
        q.add(b);
        ArrayList<String> used = new ArrayList<>();
        used.add(startWord);
        int level=0;
        while(!q.isEmpty()){
            ArrayList<String> a = q.remove();
            String s = a.get(a.size()-1);
            if(a.size()>level){
                level++;
                for(String t : used){
                    st.remove(t);
                }
            }
            used.clear();

            if(s.equals(targetWord)){
                if(ans.size()==0)
                ans.add(new ArrayList<>(a));
                else if(ans.get(0).size()==a.size())
                     ans.add(new ArrayList<>(a));  
            }
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<'z';ch++){
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i,ch);
                    if(st.contains(sb.toString())){
                        a.add(sb.toString());
                        used.add(sb.toString());
                        q.add(new ArrayList<>(a));
                        a.remove(a.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}

// https://practice.geeksforgeeks.org/problems/word-ladder-ii/1