
public class Balanced_bst_from_sorted_array {
    public static void main(String[] args) {
        TreeNode root=sortedArrayToBST(new int[]{-10,-3,0,5,9});
        printTree(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return helper(nums,0,n-1);
    }
    
    public static TreeNode helper(int[] nums,int s,int e){
        if(s>e) return null;
        if(s==e) return new TreeNode(nums[s]);
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,s,mid-1);
        root.right=helper(nums,mid+1,e);
        return root;
    }

    //inorder
    public static void printTree(TreeNode root){
        if(root==null) return;
        printTree(root.left);
        System.out.print(root.val+" ");
        printTree(root.right);
    }
}

class TreeNode{
    int val;
    TreeNode left=null,right=null;
    TreeNode(int val){
        this.val=val;
    }
}
