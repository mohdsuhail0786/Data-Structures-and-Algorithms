import java.util.*;
/**
 * Write a program to reverse a stack using recursion.
 * You are not allowed to use loop constructs like while, for..etc,
 * and you can only use the following ADT functions on Stack S:
 * isEmpty(S)
 * push(S)
 * pop(S)
 */

public class ReverseStackRecursion {
    void reverse(Stack<Integer> st){
        if(st.isEmpty())
            return;
        else{
            int top=st.pop();
            reverse(st);
            insertAtBottom(st,top);
        }
    }
    
    void insertAtBottom(Stack<Integer> st,int val){
        if(st.isEmpty())
            st.push(val);
        else{
            int top=st.pop();
            insertAtBottom(st, val);
            st.push(top);
        }
    }
}

class Main{
    public static void main(String[] args) {
        ReverseStackRecursion obj=new ReverseStackRecursion();
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        obj.reverse(s);
        System.out.println(s);
    }
}
