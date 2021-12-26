/**NADOS
 * You are given an array of coins and you are given an amount.
 * You are required to calculate and print the number of permutations of the n coins using which the amount amount can be paid.
 * Input : coins=[2,3,5,6]  amount = 7
 * Output : 5
 */

public class Coin_change_permutations {

    public static void main(String[] args) throws Exception {
        int[] coins={2,3,5,6};
        int amt=7;
        int permutations = findCoinChangePermutations(amt,coins,new int[amt+1]);
        System.out.println(permutations);
    }

    public static int findCoinChangePermutations(int n,int[] coins,int[] dp){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        int total=0;
        for(int coin : coins){
            if(n-coin >= 0){
                total += findCoinChangePermutations(n-coin,coins,dp);
            }
        }
        dp[n]=total;
        return total;
    }
}
