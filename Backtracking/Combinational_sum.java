import java.util.*;

/**GFG PRACTICE
 * Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B.
 * The same number may be chosen from the array any number of times to make B.
 * Note:
 * 1. All numbers will be positive integers.
 * 2. Elements in a combination (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * 3. The combinations themselves must be sorted in ascending order.
 * 
 * Input: N = 4
 * arr[] = {7,2,6,5}
 * B = 16
 * 
 * Output: [[2,2,2,2,2,2,2,2],[2,2,2,2,2,6],[2,2,2,5,5],[2,2,5,7],[2,2,6,6],[2,7,7],[5,5,6]]
 */

public class Combinational_sum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Solution_combinational_sum obj = new Solution_combinational_sum();
        ArrayList<Integer> lis=new ArrayList<>();
        for(int i=0;i<n;i++){
            lis.add(scan.nextInt());
        }
        int b=scan.nextInt();
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        combinations=obj.combinationSum(lis,b);
        System.out.println("All combinations of the given array for the given sum are: "+combinations);
        scan.close();
    }
}

/**APPROACH
 * almost similar to the subsets of an array
 * for each index we have to take two decisions include or not to include
 * the only difference is we have to include a element till it is in the range of given sum
 */

class Solution_combinational_sum
{
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(A.size()==0)
            return result;
        Set<Integer> set=new HashSet<>(A);
        List<Integer> arr=new ArrayList<>(set);
        Collections.sort(arr);
        helper(arr,B,0,result,new ArrayList<>());
        return result;
    }
    
    public void helper(List<Integer> lis,int sum,int ind,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> cur){
        if(sum==0){
            ArrayList<Integer> temp=new ArrayList<>(cur);
            Collections.sort(temp);
            result.add(temp);
            return;
        }
        if(ind>=lis.size())
            return;
        int ele=lis.get(ind);
        //include
        if(sum-ele>=0){
            cur.add(ele);
            helper(lis,sum-ele,ind,result,cur);
            cur.remove(cur.size()-1);
        }
        //not include
        helper(lis,sum,ind+1,result,cur);
    }
}
