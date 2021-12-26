/**LEETCODE
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * 
 * Input: cost=[10,15,20]
 * Output: 15
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 */

public class Min_cost_climb_stairs {
    public static void main(String[] args) {
        int[] cost={10,15,20};
        Solution_min_cost_climd_stairs obj=new Solution_min_cost_climd_stairs();
        int minCost=obj.minCostClimbingStairs(cost);
        System.out.println("Minimum cost for climbing stairs is:"+minCost);
    }
}

class Solution_min_cost_climd_stairs {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                dp[i]=cost[i]+dp[i+1];
            }
            else{
                dp[i]=cost[i]+ Math.min(dp[i+1],dp[i+2]);
            }
        }
        if(n==1)
            return dp[0];
         return Math.min(dp[0],dp[1]);
    }
}
