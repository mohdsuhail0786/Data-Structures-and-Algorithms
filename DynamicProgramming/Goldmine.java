/**NADOS
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns
 * 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
 * 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
 * 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
 * 6. Each cell has a value that is the amount of gold available in the cell.
 * 7. You are required to identify the maximum amount of gold that can be dug out from the mine.
 * 
 * Input : n=3 m=3 goldmine=[1,3,1][1,5,1][4,2,1]
 * Output : 10
 */

public class Goldmine {

    public static void main(String[] args) throws Exception {
        int n = 3;
        int m = 3;
        int[][] mine = {{1,3,1},{1,5,1},{4,2,1}};

        int maxGold = findMaxGold(n,m,mine);
        System.out.println(maxGold);
    }

    public static int findMaxGold(int n,int m,int[][] mine){
        int[][] dp = new int[n][m];
        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1)
                    dp[i][j] = mine[i][j];
                else if(i == 0)
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                else if(i == n-1)
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                else
                    dp[i][j] = mine[i][j] + Math.max(Math.max(dp[i-1][j+1],dp[i][j+1]),dp[i+1][j+1]);
            }
        }

        int max=dp[0][0];
        for(int i=1;i<n;i++)
            if(max<dp[i][0])
                max=dp[i][0];

        return max;
    }

}
