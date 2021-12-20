import java.util.*;

/**GFG
 * Given a N*N board with the Knight placed on the first block of an empty board.
 * Moving according to the rules of chess knight must visit each square exactly once.
 * Print the order of each cell in which they are visited.
 */

public class Knights_tour_problem{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n=scan.nextInt();
        int[][] pathMat = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(pathMat[i], -1);
        pathMat[0][0]=0;
        
        Solution_for_knights_tour obj=new Solution_for_knights_tour();
        obj.findPathOfTheKnight(0,0,n,pathMat);
        
        scan.close();
    }
}

/**APPROACH
 * same as n-queen problem and rat in a maze.
 * simply find the directions of the knight and try each possible one
 * and when first combination found then simply print and return from recursion
 */

class Solution_for_knights_tour{
    public boolean findPathOfTheKnight(int x,int y,int n,int[][] mat){
        if(mat[x][y]==(n*n)-1){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    System.out.print(mat[i][j]+" ");
                System.out.println();   
            }
            return true;
        }
        else{
            // DR,RD,RU,UR,UL,LU,LD,DL
            int dx[] = {2,1,-1,-2,-2,-1, 1, 2};
            int dy[] = {1,2, 2, 1,-1,-2,-2,-1};
            for(int i=0;i<8;i++){
                int new_x=x+dx[i];
                int new_y=y+dy[i];
                if(isValid(new_x,n) && isValid(new_y,n) && mat[new_x][new_y]==-1){
                    mat[new_x][new_y]=mat[x][y]+1; //visit
                    if(findPathOfTheKnight(new_x,new_y,n,mat)) return true;
                    mat[new_x][new_y]=-1; //unvisit
                }
            }
            return false;
        }
    }

    public boolean isValid(int present,int actual){
        if(present>=0 && present<actual)
                return true;
        else    
            return false;
    }

    public boolean allFilled(int[][] mat,int n){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(mat[i][j]==-1)
                    return false;
        return true;
    }
}