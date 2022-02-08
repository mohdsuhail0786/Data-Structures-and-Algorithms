import java.util.*;
public class Generic_stack{  
    public static void main(String[] args){  
        CustomizedStack<Integer> st=new CustomizedStack<>(10);
        for(int i=1;i<=10;i++) st.push(i);
        st.print();
        
        System.out.println();
        CustomizedStack<String> st1=new CustomizedStack<>(10);
        String[] arr=new String[]{"1","2","3","4","5","6","7","8","9","10"};
        for(String s: arr) st1.push(s);
        st.print();
    }  
}

class CustomizedStack<T>{
    ArrayList<T> arr;
    int size,top=-1;
    CustomizedStack(int size){
        this.size=size;
        this.arr=new ArrayList<T>(size);
    }
    public void push(T val){
        if(top==size-1){
            System.out.println("Stack overflow");
            return;
        }
        top+=1;
        arr.add(top,val);
    }
    public T pop(){
        if(top==-1){
            System.out.println("Stack Underflow");
            return null;
        }
        T val=arr.get(top);
        top-=1;
        return val;
    }
    public void print(){
        if(top==-1){
            System.out.println("Stack is Empty");
            return;
        }
        int temp=top;
        while(temp>=0){
            System.out.print(arr.get(temp)+" ");
            temp-=1;
        }
    }
}
