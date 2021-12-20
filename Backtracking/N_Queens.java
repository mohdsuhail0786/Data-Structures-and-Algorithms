import java.util.*;

/**LEETCODE QUESTION
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Input: 4
 * Output: [["..Q.","Q...","...Q",".Q.."],[".Q..","...Q","Q...","..Q."]]
 * 
 * Conditions:->
 * 1. Only one queen in one col
 * 2. Only one queen in one row
 * 3. No Queen should attack any other queen
 */

public class N_Queens {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Solution_n_queens obj = new Solution_n_queens();
        List<List<String>> solutions = new ArrayList<>();
        solutions=obj.solveNQueens(n);
        System.out.println("Solution to n queens are: "+solutions);
        scan.close();
    }
}

/**APPROACH
 * take a column and find the safe position for the queen in that column.
 * similarly recursively iterate for all such possible cases in which we can place the queen in the columns
 * before placing a queen, check that queen is safe at that position or not, if safe then fill it
 */

class Solution_n_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        int[][] m=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(m[i],0);
        fillQueens(n,0,m,result);
        return result;
    }
    
    public void fillQueens(int n,int col,int[][] mat,List<List<String>> result){
        if(col==n){
            ArrayList<String> lis=new ArrayList<>();
            for(int j=0;j<n;j++){
                String temp="";
                for(int i=0;i<n;i++){
                    if(mat[j][i]==1){
                        temp+='Q';
                    }
                    else
                        temp+='.';
                }
                lis.add(temp);
            }
            result.add(lis);
            return;
        }
        for(int i=0;i<n;i++){
            if(canFill(mat,n,i,col)){
                mat[i][col]=1;
                fillQueens(n,col+1,mat,result);
                mat[i][col]=0;
            }
        }
    }
    
    public static boolean canFill(int[][] mat,int n,int row,int col){
        int i=row,j=col;
        
        //left
        for(j=0;j<=col;j++){
            if(mat[row][j]==1)
                return false;
        }
        //up-left
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(mat[i][j]==1)
                return false;
            i-=1;
            j-=1;
        }
        //down-left
        i=row;
        j=col;
        while(i <n && j >=0){
            if(mat[i][j]==1)
                return false;
            i+=1;
            j-=1;
        }
        return true;
    }
}
