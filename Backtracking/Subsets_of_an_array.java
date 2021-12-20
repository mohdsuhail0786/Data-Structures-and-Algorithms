import java.util.*;

/**LEETCODE
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * Input : [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

public class Subsets_of_an_array {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Solution_subsets_of_array obj = new Solution_subsets_of_array();
        List<List<Integer>> allSubsets = new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        allSubsets=obj.subsets(arr);
        System.out.println("Subsets of the given array are: "+allSubsets);
        scan.close();
    }
}

/**APPROACH
 * iterate over the array and take decision for each element
 * include the current element or not to include the current element
 */

class Solution_subsets_of_array {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,0,result,new ArrayList<>());
        return result;
    }
    
    public void helper(int[] arr,int index,List<List<Integer>> result,List<Integer> cur){
        if(index==arr.length){
            result.add(cur);
        }
        else{
            //not include the index
            helper(arr,index+1,result,new ArrayList<>(cur));
            //include the index
            cur.add(arr[index]);
            helper(arr,index+1,result,new ArrayList<>(cur));
        }
    }
}
