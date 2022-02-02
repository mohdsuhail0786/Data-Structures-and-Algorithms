/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
 * Find the missing element.
*/

public class Missing_number_in_array {
    public static void main(String[] args) {
        Solution_missing_number obj=new Solution_missing_number();
        System.out.println(obj.MissingNumber(new int[]{1,2,4,5}, 5));
        System.out.println(obj.MissingNumber1(new int[]{1,2,4,5}, 5));
    }
}

/**
 * 2 APPROACHES
 * 1. calculate the sum of all the elements and subtract it from (n*(n+1))/2
 * 2. calculate the xor of all the element with the natural number upto that number
 */
class Solution_missing_number{
    int MissingNumber(int array[], int n) {
        int xor=0;
        for(int i=0;i<array.length;i++){
            xor^=array[i];
            xor^=(i+1);
        }
        return xor^n;
    }
    int MissingNumber1(int array[], int n) {
        int sum=0;
        for(int i : array) sum+=i;
        int finalSum=(n*(n+1))/2;
        return finalSum-sum;
    }
}
