/**NADOS
 * 1. You are given a number n, representing the count of items.
 * 2. You are given n numbers, representing the values of n items.
 * 3. You are given n numbers, representing the weights of n items.
 * 3. You are given a number "cap", which is the capacity of a bag you've.
 * 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
 * 
 * Input : n=5 values=[15,14,10,45,30] weights=[2,5,1,3,4] cap=7
 * Output : 75
 */

public class Zero_One_knapsack {

    public static void main(String[] args) throws Exception {
        int n=5;
        int[] values = {15,14,10,45,30};
        int[] weights = {2,5,1,3,4};
        int cap = 7;
        int maxValue = findMaxValue(n,values,weights,cap);
        System.out.println(maxValue);
    }

    public static int findMaxValue(int n,int[] profits,int[] weights,int cap){
        int r=n+1, c=cap+1;
        int[][] dp = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else{
                    int w = weights[i-1];
                    if(j-w >= 0){
                        dp[i][j] = Math.max(dp[i-1][j] , profits[i-1]+dp[i-1][j-w]);
                    }
                    else{
                        //not included
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        return dp[n][cap];
    }
}
