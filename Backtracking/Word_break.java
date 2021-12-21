import java.util.*;

/**GFG PRACTICE
 * Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Each dictionary word can be used more than once.
 * Return all such possible sentences.
 * 
 * Input:n=5  s="catsanddog" 
 *       dict={"cats", "cat", "and", "sand", "dog"}
 * Output: (cats and dog)(cat sand dog)
 */

public class Word_break {
    public static void main(String[] args) {
        List<String> dict=new ArrayList<>(Arrays.asList("micro", "soft", "hi", "ring", "microsoft","hiring"));
        String str="microsofthiring";
        Solution_word_break obj=new Solution_word_break();
        List<String> result=obj.wordBreak(dict.size(), dict, str);
        for(String s:result)
            System.out.println("("+s+")");
    }
}

/**APPROACH
 * try every prefix of the string, if it is a word in given dict then use it and recurse with the remaining value
 */

class Solution_word_break{
    public List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> result=new ArrayList<>();
        solution(s,dict,"",result);
        return result;
    }
    
    public void solution(String str,List<String> dict,String cur,List<String> result){
        if(str.length()==0){
            result.add(cur.substring(1));
            return;
        }
        
        for(int i=0;i<str.length();i++){
            String prefix=str.substring(0,i+1);
            if(isInDict(prefix,dict)){
                String rem=str.substring(i+1);
                cur=cur+" "+prefix;
                solution(rem,dict,cur,result);
                cur=cur.substring(0,cur.lastIndexOf(" "));
            }
        }
    }
    
    public boolean isInDict(String str,List<String> dict){
        for(String s : dict)
            if(s.equals(str))
                return true;
        return false;
    }
}
