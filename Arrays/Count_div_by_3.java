/**
 * Count of different numbers divisible by 3 that can be obtained by changing at most one digit
 * Input="23"
 * Output=7 (03,33,63,93,21,24,27)
 */

public class Count_div_by_3 {
    public static void main(String[] args) {
        Solution_div_by_3 obj=new Solution_div_by_3();
        System.out.println(obj.count("0081"));
    }
}

class Solution_div_by_3{
    public int count(String str){
        int res=0;
        int sum=0;
        int n=str.length();
        //calculating the sum of the current string num
        for(int i=0;i<n;i++) sum+=str.charAt(i)-48;

        for(int i=0;i<n;i++){
            int currNum=str.charAt(i)-48;
            sum-=currNum;
            for(int j=0;j<=9;j++){
                if((sum+j)%3==0 && j!=currNum) //checking all possible ways except the current num
                    res+=1;
            }
            sum+=currNum;
        }
        if(sum%3==0) res+=1; //if current num is also divisible by 3
        return res;
    }
}
