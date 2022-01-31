import java.util.*;

public class Maximize_The_Cut_Segments {
    public static void main(String[] args) {
        Solution_Maximize_The_Cut_Segments obj=new Solution_Maximize_The_Cut_Segments();
        int res1=obj.maximizeCuts(5,5,3,2);
        int res2=obj.utilTab(5,5,3,2);
        System.out.println(res1+" "+res2);
    }
}

class Solution_Maximize_The_Cut_Segments{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int res=utilRecursion(n,x,y,z,dp);
        return res<0 ? 0 : res;
        
        // return utilTab(n,x,y,z);
    }
    
    public int utilRecursion(int n,int x,int y,int z,int[] dp){
        
        if(n==0)
            return 0;
        
        if(dp[n]!=-1)
            return dp[n];
        
        int useX=Integer.MIN_VALUE,useY=Integer.MIN_VALUE,useZ=Integer.MIN_VALUE;
        if(n>=x) useX = utilRecursion(n-x,x,y,z,dp);
        if(n>=y) useY = utilRecursion(n-y,x,y,z,dp);
        if(n>=z) useZ = utilRecursion(n-z,x,y,z,dp);
        
        dp[n]=1+Math.max(Math.max(useX,useY),useZ);
        return dp[n];
    }
    
    public int utilTab(int n,int x,int y,int z){
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i-x>=0)
                dp[i]=Math.max(dp[i-x]+1,dp[i]);
            if(i-y>=0)
                dp[i]=Math.max(dp[i-y]+1,dp[i]);
            if(i-z>=0)
                dp[i]=Math.max(dp[i-z]+1,dp[i]);
        }
        return dp[n]<0 ? 0 : dp[n];
    }
}
