import java.util.*;
/**
 * Find all the possible palindromic substring partitions of a given string
 * Input1="baab"
 * Output1=[["b","a","a","b"],["b","aa","b"],["baab"]]
 * 
 * Input2="abaaba"
 * Output2=[["a","b","a","a","b","a"],["a","b","a","aba"],["a","b","aa","b","a"],["a","baab","a"],["aba","a","b","a"],["aba","aba"],["abaaba"]]
 */

public class Palindromic_Partitioning {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        Solution obj = new Solution();
        List<List<String>> partitions = new ArrayList<>();
        partitions=obj.partition(s);
        System.out.println("Palindromic partitions are: "+partitions);
        scan.close();
    }
}

/**APPROACH
 * iterate over the string and find the prefix.
 * Now check this prefix is palindrome or not if yes then call recursively for remaining string.
 * Otherwise do nothing.
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        helper(s,result,new ArrayList<>());
        return result;
    }
    
    public void helper(String str,List<List<String>> result,List<String> cur){
        if(str.equals("")){
            List<String> temp=new ArrayList<>(cur);
            result.add(temp);
        }
        else{
            for(int i=0;i<str.length();i++){
                String prefix = str.substring(0,i+1);
                String remains=str.substring(i+1);
                if(isPalindrome(prefix)){
                    cur.add(prefix);
                    helper(remains,result,cur);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int s=0,e=str.length()-1;
        while(s<e){
            if(str.charAt(s)!=str.charAt(e))
                return false;
            s+=1;
            e-=1;
        }
        return true;
    }
}
