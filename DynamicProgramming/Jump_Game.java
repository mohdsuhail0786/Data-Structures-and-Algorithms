/**
 * Given an positive integer N and a list of N integers A[].
 * Each element in the array denotes the maximum length of jump you can cover.
 * Find out if you can make it to the last index if you start at the first index of the list.
 * Input: N = 6 A[] = {1, 2, 0, 3, 0, 0} 
 * Output: 1
 * Explanation: Jump 1 step from first index to second index. Then jump 2 steps to reach 4th index, and now jump 2 steps to reach the end.
 */

public class Jump_Game {
    public static void main(String[] args) {
        Solution_jump_game obj=new Solution_jump_game();
        System.out.println(obj.canReach(new int[]{1, 2, 0, 3, 0, 0}, 6));
    }
}

class Solution_jump_game {
    public int canReach(int[] arr, int n) {
        int[] dp=new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(arr[i]==0) dp[i]=Integer.MAX_VALUE;
            //out of bounds
            else if(i+arr[i]>=n-1){
                dp[i]=1;
            }
            else{
                int loop=i+arr[i];
                int min=Integer.MAX_VALUE;
                for(int j=i+1;j<=loop;j++)
                    min=Math.min(min,dp[j]);
                if(min==Integer.MAX_VALUE) dp[i]=min;
                else dp[i]=min+1;
            }
        }
        if(dp[0]==Integer.MAX_VALUE) return 0;
        else return 1;
    }
};
