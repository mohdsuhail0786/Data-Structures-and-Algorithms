import java.util.Arrays;

public class Generate_Password {
    public static void main(String[] args) {
        Node head=new Node('b');
        head.next=new Node('b');
        head.next.next=new Node('b');
        head.next.next.next=new Node('e');
        // head.next.next.next.next=new Node('e');
        // head.next.next.next.next.next=new Node('w');
        Solution_generate_password obj=new Solution_generate_password();
        int result=obj.findLength(head);
        System.out.println(result+" "+obj.finalString);
    }
}

class Solution_generate_password{
    String finalString = "";
    //O(n^2) n for list and n for indexOf
    public int findLengthOfPassword(Node head){
        int result=Integer.MIN_VALUE;
        Node cur=head;
        int count=0;
        String pass="";
        while(cur!=null){
            if(pass.indexOf(cur.data)==-1){
                count+=1;
                pass+=cur.data;
            }
            else{
                result=Math.max(result,count);
                finalString=pass;
                count=1;
                pass=""+cur.data;
            }
            cur=cur.next;
        }
        result=Math.max(result,count);
        return result;
    }

    //O(n)
    public int findLength(Node head){
        int[] tab=new int[26];
        Arrays.fill(tab, 0);
        int result=Integer.MIN_VALUE;
        Node first=head,second=head;
        int count=0;
        while(second!=null){
            char c=second.data;
            int ascci=(int)c - 97;
            if(tab[ascci]!=0){
                result=Math.max(result, count);
                while(first.data!=c){
                    first=first.next;
                    count-=1;
                }
            }
            else{
                count+=1;
                tab[ascci]=1;
            }
            second=second.next;
        }
        result=Math.max(result, count);
        return result;
    }
}

class Node{
    char data;
    Node next;
    Node(char data){
        this.data=data;
        this.next=null;
    }
}
