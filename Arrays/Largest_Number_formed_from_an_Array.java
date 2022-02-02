import java.util.*;
/**
 * Largest Number formed from an Array
 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
 * The result is going to be very large, hence return the result in the form of a string.
 * 
 * Input: N = 5 Arr[] = {3, 30, 34, 5, 9}
 * Output: 9534330
 * Explanation: Given numbers are {3, 30, 34,5, 9}, the arrangement 9534330 gives the largest value.
 */

public class Largest_Number_formed_from_an_Array {
    public static void main(String[] args) {
        Solution_largest_num obj=new Solution_largest_num();
        System.out.println(obj.printLargest(new String[]{"3", "30", "34", "5", "9"}));
    }
}

class Solution_largest_num {
    String printLargest(String[] arr) {
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String x,String y){
                String xy=x+y;
                String yx=y+x;
                return yx.compareTo(xy);
            }
        });
        String res="";
        for(String s:arr)
            res+=s;
        return res;
    }
}
