import java.util.*;

public class Detect_loop {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=head.next;
        Solution_detect_loop obj=new Solution_detect_loop();
        System.out.println(obj.detectLoop1(head));
        System.out.println(obj.detectLoop2(head));
        System.out.println(obj.detectLoop3(head));
    }
}

/**
 * 3 APPROACHES
 * 1. store the addresses of the nodes in a hashset
 * 2. modify the ListNode structure and assign a flag visited to ListNode
 * 3. using floyd-cycle finding algo, using 2 pointers
 */
class Solution_detect_loop{
    public boolean detectLoop1(ListNode head){
        HashSet<ListNode> set=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp)) return true;
            set.add(temp);
            temp=temp.next;
        }
        return false;
    }

    public boolean detectLoop2(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            if(temp.isVisited) return true;
            temp.isVisited=true;
            temp=temp.next;
        }
        return false;
    }

    public boolean detectLoop3(ListNode head){
        ListNode slowp=head,fastp=head;
        while(slowp!=null && fastp!=null && fastp.next!=null){
            slowp=slowp.next;
            fastp=fastp.next.next;
            if(slowp==fastp) return true;
        }
        return false;
    }
}

class ListNode{
    int data;
    ListNode next;
    boolean isVisited;
    ListNode(int data){
        this.data=data;
        this.next=null;
        this.isVisited=false;
    }
}
