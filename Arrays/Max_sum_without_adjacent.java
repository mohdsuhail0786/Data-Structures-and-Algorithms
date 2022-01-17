/**GFG PRACTICE
 * Given an array Arr of size N containing positive integers.
 * Find the maximum sum of a subsequence such that no two numbers in the sequence should be adjacent in the array.
 * Input: N = 6      Arr[] = {5, 5, 10, 100, 10, 5}
 * Output: 110
 */

public class Max_sum_without_adjacent {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = {5, 5, 10, 100, 10, 5};
        Solution_max_sum_without_adjacent obj=new Solution_max_sum_without_adjacent();
        int maxSum1 = obj.findMaxSum(arr, n);
        int maxSum2 = obj.findSum(arr, 0, 0);
        System.out.println(maxSum1);
        System.out.println(maxSum2);
    }
}

class Solution_max_sum_without_adjacent {
    //using tabulation
    int findMaxSum(int arr[], int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i-2 >= 0)
                dp[i]=Math.max(arr[i-1]+dp[i-2] , dp[i-1]);
            else
                dp[i]=Math.max(arr[i-1] , dp[i-1]);
        }
        return dp[n];
    }

    //using memoization
    int findSum(int arr[],int index,int sum){
        if(index >= arr.length)
            return sum;
        
        //include
        int i=findSum(arr, index+2, sum+arr[index]);
        //not include
        int e=findSum(arr, index+1, sum);

        return Math.max(i, e);
    }
}
