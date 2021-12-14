import java.util.*;

/**LEETCODE
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * ["123","132","213","231","312","321"]
 * Given n and k, return the kth permutation sequence.
 * 
 * Input1: n = 3, k = 3
 * Output1: "213"
 * 
 * Input2: n = 4, k = 9
 * Output2: "2314"
 */

public class Kth_permutation {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        Solution obj = new Solution();
        String perm=obj.getPermutation(n,k);
        System.out.println("Kth permutation is: "+perm);
        scan.close();
    }
}

/**APPROACH
 * first find the first element of kth perm, then find second element, then third and so on. By following some steps
 * group=factorial(n-1)
 * element=arr[k/grp]
 * result+=element
 * k=k%group
 * arr.remove(element)
 * n=n-1
 */

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++)
            arr.add(i);
        String result="";
        k-=1;//because of 0 based indexing
        while(n>0){
            int grp=factorial(n-1);
            int ele=arr.get(k/grp);
            result+=ele;
            k=k%grp;
            arr.remove(new Integer(ele));
            n-=1;
        }
        return result;
    }
    
    public int factorial(int num){
        if(num==0 || num==1)
            return 1;
        else
            return num*factorial(num-1);
    }
}
