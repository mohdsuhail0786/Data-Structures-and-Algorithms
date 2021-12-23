import java.util.*;

/**INTERVIEW WITH NITESH
 * You are given a tree and a value k,
 * you have to find the kth ancestor of all the node and print them in inorder traversal
 * 
 * Input:       3
 *          2      4
 *        1   5  6
 *  k=2
 * Output: [3,-1,3,-1,3,-1]
 * 
 * for the same tree if k=1
 * then Output= [2,3,2,-1,4,3]
 */

public class Kth_ancestor_of_each_node {
    public static void main(String[] args) {
		Node root=new Node(3);
		root.left=new Node(2);
		root.right=new Node(4);
		root.left.left=new Node(1);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
        int k=2;
        Solution_Kth_ancestor_of_all_nodes obj=new Solution_Kth_ancestor_of_all_nodes();
		List<Integer> result = obj.kthAncestorOfAllNodes(root,k);
		System.out.println(result);
	}
}

/**APPROACH
 * first create a hashmap of the (node,parent) for each node (recursion or iteration-LevOrder)
 * then traverse inorderly (recursively or iteratively) and find the kth parent of each node
 */

class Solution_Kth_ancestor_of_all_nodes{
	public List<Integer> kthAncestorOfAllNodes(Node root,int k){
	    if(root==null)
	        return new ArrayList<>();
        //hashmap to store the parents of all nodes
	    HashMap<Node,Node> hs=new HashMap<>();
	    findParents(root,hs,null);
        
	    List<Integer> lis=new ArrayList<>();
	    helper(root,k,lis,hs);
	    return lis;
    }
    
    //for inorder traversal
    public void helper(Node root,int k,List<Integer> result,HashMap<Node,Node> map){
        if(root==null)
            return;
        helper(root.left,k,result,map);
        result.add(findKthparent(root,k,map));
        helper(root.right,k,result,map);
    }
    
    //this will return the kth parent of the given root
    public int findKthparent(Node n,int k,HashMap<Node,Node> map){
        Node cur=n;
        while(k-- > 0){
            if(!map.containsKey(cur))
                break;
            cur=map.get(cur);
        }
        if(k>0 || cur==null)
            return -1;
        else
            return cur.data;
    }
    
    //this will create a hashmap of all the nodes as key and values as their corresponding parents
    public void findParents(Node root,Map<Node,Node> map,Node par){
        if(root==null)
            return;
        findParents(root.left,map,root);
        if(!map.containsKey(root))
            map.put(root,par);
        findParents(root.right,map,root);
    }

}

//class for tree
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
    }
}
