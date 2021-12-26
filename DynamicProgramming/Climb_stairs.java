import java.util.*;

/**LEETCODE
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Climb_stairs{
    public static void main(String[] args) {
        int n=6;
        Solution_climb_stairs obj=new Solution_climb_stairs();
        int result=obj.climbStairs(n);
        System.out.println("Number of paths: "+result);

        obj.printAllPaths(n,new ArrayList<>());
    }
}

class Solution_climb_stairs {
    public int climbStairs(int n){
        int res=helper(n,new int[n+1]);
        return res;
    }
    
    //this will find the number of paths (using memoization to reduce func calls)
    public int helper(int n,int[] dp){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        int one=helper(n-1,dp);
        int two=helper(n-2,dp);
        
        dp[n]=one+two;
        return dp[n];
    }
    
    //print all paths (using backtracking)
    public void printAllPaths(int n,List<Integer> curPath){
        if(n<0)
            return;
        if(n==0){
            List<Integer> cur=new ArrayList<>(curPath);
            for(int i : cur) System.out.print(i+" ");
            System.out.println();
        }

        curPath.add(1);
        printAllPaths(n-1, curPath);
        curPath.remove(curPath.size()-1);

        curPath.add(2);
        printAllPaths(n-2, curPath);
        curPath.remove(curPath.size()-1);
    }
}