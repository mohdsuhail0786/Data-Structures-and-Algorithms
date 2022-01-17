import java.util.*;

public class Maximum_Sum_of_nonAdjacent_nodes {
    
}


class Solution_Maximum_sum{
    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root)
    {
        if(root==null)  return 0;
        
        int result = findMaxSum(root,new HashMap<Node,Integer>());
        
        return result;
    }
    
    static int findMaxSum(Node root,HashMap<Node,Integer> map){
        if(root==null)  return 0;
        
        if(map.containsKey(root))
            return map.get(root);
        
        int consider=root.data;
        if(root.left!=null)
            consider=consider+findMaxSum(root.left.left,map)+findMaxSum(root.left.right,map);
        if(root.right!=null)
            consider=consider+findMaxSum(root.right.left,map)+findMaxSum(root.right.right,map);
            
        int not_consider = findMaxSum(root.left,map)+findMaxSum(root.right,map);
        
        map.put(root,Math.max(consider,not_consider));
        return map.get(root);
    }
}

class Node{
    int data;
    Node left=null,right=null;
    Node(int data){
        this.data=data;
    }
}
