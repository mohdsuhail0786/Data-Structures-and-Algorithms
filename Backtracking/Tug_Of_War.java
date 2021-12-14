import java.util.*;

/**PEPCODING
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
 * If n is even, then sizes of two subsets must be strictly n/2
 * and if n is odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
 * 
 * Input: 6  [1,2,3,4,5,6]
 * Output: [1, 3, 6] [2, 4, 5]
 */

public class Tug_Of_War {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
        int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
        Solution obj=new Solution();
		String result=obj.findTwoSets(arr);
		System.out.println("The two sets are: "+result);
        scan.close();
	}
}

/**APPROACH
 * for each element, place one time in set 1 and one time in set2
 * and calculate the diff of sum of the two sets and take the sets with minimum sum
 */

class Solution {

    private String ans="";
    private int mindiff=Integer.MAX_VALUE;

    public String findTwoSets(int[] arr){
        helper(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        return ans;
    }

	public void helper(int[] arr, int ind, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,int soset2) {
		if(ind==arr.length){
		    int diff=Math.abs(soset1-soset2);
		    if(diff<mindiff){
		        mindiff=diff;
		        ans=set1+" "+set2;
		    }
		    return;
		}
		
		if(set1.size()< (arr.length+1)/2){
		    set1.add(arr[ind]);
		    helper(arr,ind+1,set1,set2,soset1+arr[ind],soset2);
		    set1.remove(set1.size()-1);
		}
		
		if(set2.size()< (arr.length+1)/2){
		    set2.add(arr[ind]);
		    helper(arr,ind+1,set1,set2,soset1,soset2+arr[ind]);
		    set2.remove(set2.size()-1);
		}
	}
}
