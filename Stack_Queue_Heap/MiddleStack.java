public class MiddleStack{
    DoublyNode top=null,mid=null;
    int count=0;

    //this will add element to the stack
    void push(int data){
        DoublyNode n=new DoublyNode(data);
        if(top!=null){
            n.next=top;
            top.prev=n;
        }
        top=n;
        count+=1;
        if(count==1)
            mid=n;
        else if(count%2==1)
            mid=mid.prev;
    }

    //this will return and delete the top of the stack
    int pop(){
        if(top==null)
            return -1;
        int val=top.data;
        count-=1;
        if(top.next==null)
            top=null;
        else{
            top.next.prev=null;
            top=top.next;
        }
        if(count%2==0)
            mid=mid.next;
        return val;
    }

    //this will return the middle element of the stack
    int findMiddle(){
        if(mid==null)
            return -1;
        else return mid.data;
    }

    //this will return and delete the middle element of the stack
    int deleteMiddle(){
        if(mid==null)
            return -1;
        int val=mid.data;
        count-=1;
        if(mid.prev==null){
            mid=null;
            top=null;
        }
        else if(mid.next==null){
            mid.prev.next=mid.next;
            mid=mid.prev;
        }
        else{
            mid.next.prev=mid.prev;
            mid.prev.next=mid.next;
            if(count%2==0)
                mid=mid.next;
            else 
                mid=mid.prev;
        }
        return val;
    }

    void print(){
        if(top==null)
            return;
        DoublyNode temp=top;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

class Main{
    public static void main(String[] args){
        MiddleStack st=new MiddleStack();
        System.out.println(st.pop());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.print();
        System.out.println(st.findMiddle());
        System.out.println(st.deleteMiddle());
        st.print();
        System.out.println(st.findMiddle());
        System.out.println(st.deleteMiddle());
        System.out.println(st.findMiddle());
    }
}

class DoublyNode{
    int data;
    DoublyNode next,prev;
    DoublyNode(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}