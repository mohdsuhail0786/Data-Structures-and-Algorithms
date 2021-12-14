import java.util.*;
/**
 * count number of palindromic substrings of a given string
 * Input="aaa"
 * Output=6 {a,a,a,aa,aa,aaa}
 */

public class Palindromic_SubStrings{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        Solution obj = new Solution();
        int result=obj.countSubstrings(s);
        System.out.println("Number of palindromic substrings: "+result);
        scan.close();
    }
}

/**
 * Approach :->
 * #first find odd length palindromes and then even length
 * iterate over each character and perform these two tasks
 * FOR ODD LENGTH==> initialize two pointers l=i and r=i. Now check if str[l]==str[r] and increment count till l & r in bounds
 * FOR EVEN LENGTH==> initialize two pointers l=i and r=i+1. Now check if str[l]==str[r] and increment count till l & r in bounds
 * 
 * TC ==> O(n^2) SC ==> O(1)
 */

class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            count+=palindromes(i,i,s,n); //odd length palindromes
            count+=palindromes(i,i+1,s,n); //even length palindromes
        }
        return count;
    }
    
    public int palindromes(int l,int r,String s,int n){
        int count=0;
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            System.out.println(s.substring(l, r+1));
            count+=1;
            l-=1;
            r+=1;
        }
        return count;
    }
}