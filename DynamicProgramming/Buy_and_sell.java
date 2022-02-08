public class Buy_and_sell {
    public static void main(String[] args) {
        Solution_buy_sell obj=new Solution_buy_sell();
        System.out.println(obj.buyAndSell1(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.buyAndSell2(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.buyAndSell3(new int[]{7,1,5,3,6,4}));
        System.out.println(obj.buyAndSell4(3,new int[]{7,1,5,3,6,4}));
    }   
}

class Solution_buy_sell {
    /**
     * only one transaction allowed
     * buy on 1 and sell on 6 -- profit 5
     */
    public int buyAndSell1(int[] prices){
        int buying=prices[0],n=prices.length;
        int maxProfit=0;
        for(int i=1;i<n;i++){
            if(prices[i]>buying) maxProfit=Math.max(maxProfit,prices[i]-buying);
            else buying=prices[i];
        }
        return maxProfit;
    }

    /**
     * infinite transactions allowed
     * 1. buy on 1 and sell on 5 -- profit 4
     * 2. buy on 3 and sell on 6 -- profit 3
     * Total profit -- 7
     */
    public int buyAndSell2(int[] prices) {
        int b=0,s=0,profit=0;
        int n=prices.length;
        for(int i=1;i<n;i++){
            //dip-collect current profit
            if(prices[i]<prices[s]){
                profit+=(prices[s]-prices[b]);
                b=s=i;
            }
            //rise-increment sell date
            else{
                s+=1;
            }
        }
        if(s==n-1) profit+=(prices[s]-prices[b]);
        
        return profit;
    }

    /**
     * atmost 2 transactions allowed
     * 1. buy on 1 and sell on 5 -- profit 4
     * 2. buy on 3 and sell on 6 -- profit 3
     * Total profit -- 7
     */
    public int buyAndSell3(int[] prices) {
        int n=prices.length;
        int[] selltodayorbefore=new int[n];
        int[] buytodayorafter=new int[n];
        //maxprofit in buying and selling at index i -- today or before
        selltodayorbefore[0]=0;
        int minPrice=prices[0],maxProfit=0;
        for(int i=1;i<n;i++){
            if(prices[i]>=minPrice) maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            else minPrice=prices[i];
            
            selltodayorbefore[i]=maxProfit;
        }
        
        //maxprofit in buying and selling at index i -- today or after
        int maxPrice=prices[n-1];
        maxProfit=0;
        for(int i=n-2;i>=0;i--){
            if(prices[i]<=maxPrice) maxProfit=Math.max(maxProfit,maxPrice-prices[i]);
            else maxPrice=prices[i];
            
            buytodayorafter[i]=maxProfit;
        }
        
        //now any index i store 2 info -- one is buy or sell before today and second is buy or sell after today
        maxProfit=0;
        for(int i=0;i<n;i++) maxProfit=Math.max(maxProfit,selltodayorbefore[i]+buytodayorafter[i]);
        
        return maxProfit;
    }

    /**
     * atmost k transactions allowed
     */
    public int buyAndSell4(int k, int[] prices) {
        int n=prices.length;
        if(n<=1 || k==0) return 0;
        int[][] dp=new int[k+1][n];
        for(int i=0;i<=k;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0) dp[i][j]=0;
                else{
                    dp[i][j]=dp[i][j-1];
                    for(int c=j-1;c>=0;c--)
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][c]+(prices[j]-prices[c]));
                }
            }
        }
        return dp[k][n-1];
    }
}
