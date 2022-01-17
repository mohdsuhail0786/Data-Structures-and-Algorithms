import java.util.*;

/*
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number.
A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion.
You have to find the longest chain which can be formed from the given set of pairs. 
*/

public class Max_length_chain {
    public static void main(String[] args) {
        Pair[] arr=new Pair[]{new Pair(5,24),new Pair(39,60),new Pair(15,28),new Pair(27,40),new Pair(50,90)};
        Solution_Max_length_chain obj=new Solution_Max_length_chain();
        int res=obj.maxChainLength(arr,5);
        System.out.println(res);
    }
}

class Solution_Max_length_chain{
    int maxChainLength(Pair arr[], int n)
    {
       int[] dp=new int[n];
       Arrays.fill(dp,1);
       int res=Integer.MIN_VALUE;
       List<Pair> lis=Arrays.asList(arr);
       Collections.sort(lis,new SortThePairs());
       for(int i=n-1;i>=0;i--){
           for(int j=i+1;j<n;j++){
               if(arr[i].y<arr[j].x && dp[i]<dp[j]+1){
                   dp[i]=dp[j]+1;
               }
           }
        res=Math.max(res,dp[i]);
       }
       return res;
    }
}

class SortThePairs implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        if(p1.x==p2.x)
            return p1.y-p2.y;
        else
            return p1.x-p2.x;
    }
}

class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
