public class Binomial_Coefficient {
    public static void main(String[] args) {
        Solution_Binomial_coefficient obj=new Solution_Binomial_coefficient();
        System.out.println(obj.nCr(7, 4));
    }
}
class Solution_Binomial_coefficient{
    int nCr(int n, int r)
    {
        //O(n)
        // int res=1;
        // int mod=1000000007;
        // for(int i=0;i<r;i++){
        //     res*=(n-i);
        //     res/=(i+1);
        //     res%=mod;
        // }
        // return res%mod;


        //O(n*r)
        if(r>n) return 0;
        if(r==n || r==0) return 1;
        if(r==n-1) return n;
        int mod=1000000007;
        int[][] dp=new int[n+1][r+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=r;j++){
                if(j>i)
                    dp[i][j]=0;
                else if(i==j || j==0)
                    dp[i][j]=1;
                else
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%mod;
            }
        }
        return dp[n][r];
    }
}
