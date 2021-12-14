import java.util.*;

/**GFG PRACTICE
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
 * Find all possible paths that the rat can take to reach from source to destination.
 * The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
 * Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
 * Input1: N = 4
    m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
    Output: [DDRDRR,DRDDRR]
 */

public class Rat_in_a_maze {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Solution obj = new Solution();
        ArrayList<String> solutions = new ArrayList<>();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=scan.nextInt();
            }
        }
        solutions=obj.findPath(mat,n);
        System.out.println("paths for rat are: "+solutions);
        scan.close();
    }
}

/**APPROACH
 * try all possible directions at the positions where rat can go i.e. mat[i][j]==1
 * and make a account of visited node also so that one should not revisit them.
 */

class Solution {
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<>();
        if(n==0 || m[0][0]==0)
            return result;
        int[][] visited = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(visited[i],0);
        helper(0,0,m,visited,n,"",result);
        return result;
    }
    
    public void helper(int i,int j,int[][] mat,int[][] visited,int n,String str,ArrayList<String> result){
        if(i==n-1 && j==n-1)
            result.add(str);
        String temp="DLRU";
        int[] dx={1,0,0,-1};
        int[] dy={0,-1,1,0};
        for(int k=0;k<4;k++){
            int newi=i+dx[k];
            int newj=j+dy[k];
            if(newi>=0 && newj>=0 && newi<n && newj<n && mat[newi][newj]==1 && visited[newi][newj]==0){
                str+=temp.charAt(k);
                visited[i][j]=1;
                helper(newi,newj,mat,visited,n,str,result);
                visited[i][j]=0;
                str=str.substring(0,str.length()-1);
            }
        }
    }
}
