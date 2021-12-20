import java.util.*;

/**CODING NINJA
 * Print All Possible Paths From Top Left Corner To Bottom Right Corner Of A 2-D Matrix
 * You are given an ‘M*N’ Matrix, You need to print all possible paths from its top left corner to the bottom right corner
 * given that you can either move right i.e from (i,j) to (i,j+1) or down i.e from (i, j) to (i+1, j).
 * 
 * Input: 2 3
 *        [1 2 3]
 *        [4 5 6]
 * Output: [1 2 3 6]
 *         [1 2 5 6]
 *         [1 4 5 6]
 */

public class Paths_from_start_to_end_of_matrix {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Solution_path_start_end obj = new Solution_path_start_end();
        int m=scan.nextInt();
        int n=scan.nextInt();
        int[][] mat=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=scan.nextInt();
            }
        }
        int[][] result=obj.printAllPaths(mat,m,n);
        System.out.println("paths are:");
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        scan.close();
    }
}

/**APPROACH
 * same as rat in a maze
 */

class Solution_path_start_end {
    public int[][] printAllPaths(int[][] mat, int m, int n) {
     	List<List<Integer>> result=new ArrayList<>();
        helper(mat,m,n,0,0,result,new ArrayList<>());
        int r=result.size();
        int c=m+n-1;
        int[][] resultantMatrix=new int[r][c];
        for(int i=0;i<r;i++){
            List<Integer> temp=result.get(i);
            for(int j=0;j<c;j++){
                resultantMatrix[i][j]=temp.get(j);
            }
        }
        return resultantMatrix;
    }
    
    public void helper(int[][] mat,int r,int c,int s,int e,List<List<Integer>> result,List<Integer> cur){
        if(s==r-1 && e==c-1){
			List<Integer> temp=new ArrayList<>(cur);
            temp.add(mat[s][e]);
            result.add(temp);
        }
        else{
            int[] dx={1,0};
            int[] dy={0,1};
            for(int i=0;i<2;i++){
                int news=s+dx[i];
                int newe=e+dy[i];
                if(news>=0 && news<r && newe>=0 && newe<c){
                    cur.add(mat[s][e]);
                    helper(mat,r,c,news,newe,result,cur);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
}

