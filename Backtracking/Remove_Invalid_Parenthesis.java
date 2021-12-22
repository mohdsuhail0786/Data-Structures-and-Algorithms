import java.util.*;

/**LEETCODE
 * Given a string s that contains parentheses and letters,
 * remove the minimum number of invalid parentheses to make the input string valid.
 * 
 * Input: s="()())()"
 * Output: ["(())()","()()()"]
 * 
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * 
 * Input: s=")a("
 * Output: ["a"]
 */

public class Remove_Invalid_Parenthesis {
    public static void main(String[] args) {
        String str="((()((s((((()";
        Solution_Remove_invalid_parenthesis obj=new Solution_Remove_invalid_parenthesis();
        List<String> result=obj.removeInvalidParentheses(str);
        System.out.println(result);
    }
}

/**APPROACH
 * the idea is, first find the minimum number of parenthesis removals
 * then try to remove each bracket from string till removals > 0
 * and when a string with no of removals 0 found, add it to the result
 */

class Solution_Remove_invalid_parenthesis {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> hs=new HashSet<>(); //hashset to remove redundant solutions
        int removals=findRemoves(s); //find minimum removals
        solution(s,removals,hs,new HashMap<>());
        List<String> result=new ArrayList<>(hs);
        if(result.size()==0)
            result.add("");
        return result;
    }
    
    public void solution(String s,int removals,HashSet<String> hs,Map<String,Boolean> map){
        if(map.containsKey(s) && map.get(s))
            return;
        map.put(s,true);
        
        if(removals==0){
            if(hs.contains(s))
                return;
            int removals_remains=findRemoves(s);
            if(removals_remains==0 && !hs.contains(s)){
                hs.add(s);
            }
            return;
        }
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='a' && c<='z')
                continue;
            String left=s.substring(0,i);
            String right=s.substring(i+1);
            String remaining=left+right; //string after removing ith element
            solution(remaining,removals-1,hs,map);
        }
    }
    
    //function to find minimum number of removals of parenthesis from a string
    public int findRemoves(String s){
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c>='a' && c<='z')//if character then leave it
                continue;
            if(c=='(') //always push opening bracket
                st.push(c);
            else{
                if(!st.isEmpty() && st.peek()=='(') //if top is opening bracket then pop it
                    st.pop();
                else
                    st.push(c); //if top is closing then push
            }
        }
        return st.size(); //return remaining invalid parenthesis
    }
}
