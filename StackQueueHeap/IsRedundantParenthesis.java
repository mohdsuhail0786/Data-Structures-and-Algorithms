import java.util.*;
/**
 * Given a string of balanced expression,
 * find if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
 * Print ‘Yes’ if redundant, else ‘No’.
 */
public class IsRedundantParenthesis {
    boolean containRedundantParenthesis(String s){
        if(s=="")
            return false;
        else{
            Stack<Character> st=new Stack<>();
            int len=s.length();
            for(int i=0;i<len;i++){
                char c=s.charAt(i);
                if(c==')'){
                    char ch=st.pop();
                    if(ch=='(' || st.peek()=='(')
                        return false;
                    while(st.peek()!='(')
                        st.pop();
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            return true;
        }
    }
}

class Main{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String exp=scan.next();
        IsRedundantParenthesis obj=new IsRedundantParenthesis();
        boolean result=obj.containRedundantParenthesis(exp);
        System.out.println(result);
        scan.close();
    }
}
