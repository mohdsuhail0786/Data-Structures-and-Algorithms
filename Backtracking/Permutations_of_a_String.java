import java.util.*;

/**GFG PRACTICE
 * Given a string S. The task is to print all permutations of a given string in lexicographically sorted order.
 * Input: "ABC"
 * Output: [ABC,ACB,BAC,BCA,CAB,CBA]
 */

public class Permutations_of_a_String {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        Solution obj = new Solution();
        List<String> result=new ArrayList<>();
        result=obj.find_permutation(s);
        System.out.println("Permutations of the given string are: "+result);
        scan.close();
    }
}

/**APPROACH
 * iterate over the string and for each next index(including itself), swap the characters and increment the index 
 * and call for the next index
 * and also again swap the elements to acquire original string
 */

class Solution {
    public List<String> find_permutation(String S) {
        List<String> Permutations = new ArrayList<>();
        generatePermutations(S,0,Permutations);
        Collections.sort(Permutations);
        return Permutations;
    }
    
    public void generatePermutations(String s,int index,List<String> result){
        if(index==s.length()-1)
            result.add(s);
        else{
            for(int i=index;i<s.length();i++){
                s=swap(s,index,i);
                generatePermutations(s,index+1,result);
                s=swap(s,index,i);
            }
        }
    }
    
    public String swap(String str,int f,int s){
        char[] arr=str.toCharArray();
        char temp=arr[f];
        arr[f]=arr[s];
        arr[s]=temp;
        return String.valueOf(arr);
    }
}
