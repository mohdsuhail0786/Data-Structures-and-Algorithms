/**NADOS
 * 1. You are given a number n, representing the count of elements in the array.
 * 2. You are given n numbers of the array.
 * 3. You are given a number "tar".
 * 4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
 *  
 * Input : n=5  arr=[4,2,7,1,3]  tar=10
 * Output: true
 */

public class Target_sum_subset{
    public static void main(String[] args) throws Exception {
        int n=5;
        int[] arr={4,2,7,1,3};
        int tar = 10;
        boolean isSubsetExists = findSubSet(n,arr,tar);
        System.out.println(isSubsetExists);
    }

    public static boolean findSubSet(int n,int[] arr,int target){
        int r=n+1,c=target+1;
        boolean[][] dp = new boolean[r][c];

        dp[0][0]=true;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j]=false;
                }
                else if(j==0){
                    dp[i][j]=true;
                }
                else{
                    if(dp[i-1][j])
                        dp[i][j]=true;
                    else{
                        if(j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]])
                            dp[i][j] = true;
                        else 
                            dp[i][j]=false;
                    }
                }
            }
        }

        return dp[n][target];
    }
}