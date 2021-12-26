/**LEETCODE
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * 
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount: 
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */

public class Coin_change_combinations {
    public static void main(String[] args) throws Exception {
        int[] coins={1,2,5};
        int amt=5;
        Solution_coin_change_combination obj=new Solution_coin_change_combination();
        int permutations = obj.change(amt,coins);
        System.out.println(permutations);
    }
}

class Solution_coin_change_combination {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int coin : coins){
            for(int i=1;i<=amount;i++){
                if(i-coin >= 0){
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
