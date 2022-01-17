import java.util.*;
public class Maximum_subsequence_sum_such_that_no_three_are_consecutive{
    public static void main(String[] args) {
        int[] dp=new int[5];
        Arrays.fill(dp,-1);
        Solution_MaxSum_without_three_consecutive obj=new Solution_MaxSum_without_three_consecutive();
        int res=obj.helper(new int[]{3000,2000,1000,3,10},4,dp);
        System.out.println(res);
      }
}

class Solution_MaxSum_without_three_consecutive{
    public int helper(int arr[],int index,int[] dp){
        //base cases
        if(index<0)
          return 0;
        if(index==0)
          return dp[0]=arr[0];
        if(index==1)
          return dp[1]=arr[1]+arr[0];
          
        //already calculated or not
        if(dp[index]!=-1)
         return dp[index];
         
        int f=0,s=0,t=0;
        //consider
        f=arr[index]+helper(arr,index-2,dp);
        s=arr[index]+arr[index-1]+helper(arr,index-3,dp);
        //not
        t=helper(arr,index-1,dp);
        return dp[index] =  Math.max(f,Math.max(s,t));
    }
}