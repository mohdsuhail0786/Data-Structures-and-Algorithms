/**GFG PRACTICE
 * Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]),
 * the task to find a solved Sudoku.
 * For simplicity, you may assume that there will be only one unique solution.
 */

public class Sudoku_solver {
    public static void main(String[] args) {
        int[][] board = {{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},{8,0,0,0,6,0,0,0,3},{4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};
        
        Solution_Sudoku_solver obj=new Solution_Sudoku_solver();
        obj.SolveSudoku(board);
        obj.printGrid(board);
    }
}

/**APPROACH
 * iterate on each element of the grid and try each number from 1 to n if the element is 0.
 * in isSafe function check that the position for the provided element is ok or not, it will check in row, col, in the 3X3 box.
 */

class Solution_Sudoku_solver{
    public boolean isSafe(int x,int y,int val,int[][] grid){
        int n=grid.length;
        for(int i=0;i<n;i++){
            //checking in the row
            if(grid[x][i]==val) return false;
            //checking in the column
            if(grid[i][y]==val) return false;
            //checking in the 3X3 box
            int r=3*(x/3)+(i/3);
            int c=3*(y/3)+(i%3);
            if(grid[r][c]==val) return false;
        }
        return true;
    }
    
    //Function to find a solved Sudoku. 
    public boolean SolveSudoku(int grid[][])
    {
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    for(int k=1;k<=n;k++){
                        if(isSafe(i,j,k,grid)){
                            grid[i][j]=k; //fill the value
                            if(SolveSudoku(grid)) return true;
                            grid[i][j]=0; //unfill the value
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    public void printGrid (int grid[][])
    {
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
