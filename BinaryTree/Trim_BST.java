public class Trim_BST {
    
}

class TreeNode {
    int val;
    TreeNode left=null;
    TreeNode right=null;
    TreeNode(int val) { this.val = val; }
}

class Solution_trim_bst {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)
            return null;
        
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        
        if(root.val < low){
            TreeNode right = root.right;
            root=null;
            return right;
        }
        
        if(root.val > high){
            TreeNode left = root.left;
            root=null;
            return left;
        }
        
        return root;
    }
}
