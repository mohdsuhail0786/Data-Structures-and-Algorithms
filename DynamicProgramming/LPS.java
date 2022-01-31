import java.util.*;

/**
 * Longest Palindromic Subsequence
 */

public class LPS {
    public static void main(String[] args) {
        Solution_lps obj=new Solution_lps();
        System.out.println(obj.longestPalinSubseq("abaccbr"));
    }
}

class Solution_lps
{
    public int longestPalinSubseq(String s)
    {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=1;

        for(int k=1;k<n;k++){
            int i=0,j=k;
            while(i<n && j<n){
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=2+dp[i+1][j-1];
                else dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
                i+=1;
                j+=1;
            }
        }
        return dp[0][n-1];
        //return recursive(s,new HashMap<String,Integer>());
    }
    
    public int recursive(String s,HashMap<String,Integer> map){
        if(s.length()<=1) return s.length();
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)) return 2;
            else return 1;
        }
        
        if(map.containsKey(s)) return map.get(s);
        int res=0;
        if(s.charAt(0)==s.charAt(s.length()-1)){
            res=longestPalinSubseq(s.substring(1,s.length()-1))+2;
        }
        else{
            int incFirst=longestPalinSubseq(s.substring(0,s.length()-1));
            int incLast=longestPalinSubseq(s.substring(1,s.length()));
            res= Math.max(incFirst,incLast);
        }
        
        map.put(s,res);
        return res;
    }
}
