import java.util.*;

/**NADOS
 * You are given a number n, representing the number of rows.
 * You are given a number m, representing the number of columns.
 * You are given n*m numbers, representing elements of 2d array a, which represents a maze.
 * You are standing in top-left cell and are required to move to bottom-right cell.
 * You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
 * Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
 * You are required to traverse through the matrix and print the cost of path which is least costly.
 * 
 * Input : n=3 m=3 maze=[1,3,1][1,5,1][4,2,1]
 * Output : 7
 */

public class Min_cost_maze_traversal {

    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int n = 3;
        int m = 3;
        int[][] maze = {{1,3,1},{1,5,1},{4,2,1}};

        int minCost = findMinimumCost(n,m,maze);
        System.out.println(minCost);
        scan.close();
    }

    public static int findMinimumCost(int n,int m,int[][] maze){
        int[][] dp = new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1)
                    dp[i][j]=maze[i][j];
                else if(i == n-1)
                    dp[i][j] = dp[i][j+1] + maze[i][j];
                else if(j == m-1)
                    dp[i][j] = dp[i+1][j] + maze[i][j];
                else
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + maze[i][j];
            }
        }

        return dp[0][0];
    }

}
