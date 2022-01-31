import java.util.*;

public class Egg_Drop {
    public static void main(String[] args) {
        Solution_Egg_Drop obj=new Solution_Egg_Drop();
        int result=obj.eggDrop(2, 4);
        System.out.println(result);
    }
}

class Solution_Egg_Drop{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    int eggDrop(int n, int k) 
	{
	    int[][] mat=new int[n+1][k+1];
	    for(int[] arr : mat)
	        Arrays.fill(arr,-1);
	    return util(n,k,mat);
	}
	
	int util(int n,int f,int[][] mat){
    if(n==0 || f==0) return 0;
    if(f==1) return 1;
    if(n==1) return f;
    if(mat[n][f]!=-1) return mat[n][f];
    int minimumMoves = Integer.MAX_VALUE;
    for(int i=1;i<=f;i++){
      int survives = util(n,f-i,mat);
      int brokes = util(n-1,i-1,mat);
      minimumMoves = Math.min(Math.max(brokes,survives),minimumMoves);
    }
    mat[n][f]=minimumMoves+1;
    return minimumMoves+1;   
  }
}
