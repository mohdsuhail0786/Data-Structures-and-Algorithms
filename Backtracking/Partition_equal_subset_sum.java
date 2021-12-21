/**GFG PRACTICE
 * Given an array arr[] of size N,
 * check if it can be partitioned into two parts such that the sum of elements in both parts is the same.
 * 
 * Input: n=3 arr=[1,2,1]
 * Output: YES {1,1} {2}
 * 
 * Input: n=5 arr=[3,5,2,6,1]
 * Output: NO
 */

public class Partition_equal_subset_sum {
    public static void main(String[] args) {
        int n = 4;
        int[] arr={1,5,11,5}; //{1,5,5} {11}
        Solution_partion_equal_subset_sum obj=new Solution_partion_equal_subset_sum();
        int result=obj.equalPartition(n, arr);
        if(result==1) 
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

/**APPROACH
 * first find the sum of the array and check if it is odd then return false
 * now follow the same approach as in combinational sum, divide the given array into two sets and check their sum
 */

class Solution_partion_equal_subset_sum{
    public int equalPartition(int N, int arr[])
    {
        int arrSum=0;
        for(int i : arr) arrSum+=i;
        
        if(arrSum%2 == 1) return 0;
        
        boolean res = solution(0,arr,0,0,arrSum/2);
        if(res) return 1;
        else return 0;
    }
    
    public boolean solution(int index,int[] arr,int soset1,int soset2,int maxSum){
        if(index==arr.length){
            if(soset1==soset2)
                return true;
            else
                return false;
        }
        
        if((soset1+arr[index])<=maxSum){
            soset1+=arr[index];
            if(solution(index+1,arr,soset1,soset2,maxSum)) return true;
            soset1-=arr[index];
        }
        
        if((soset2+arr[index])<=maxSum){
            soset2+=arr[index];
            if(solution(index+1,arr,soset1,soset2,maxSum)) return true;
            soset2-=arr[index];
        }
        
        return false;
    }
}
