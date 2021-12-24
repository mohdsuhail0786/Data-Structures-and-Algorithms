/**INTERVIEW WITH NITESH & LEETCODE
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 1
 * Output: [-1,-1]
 */

public class Occurence_in_sorted_array {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int target=7;
        Solution_occurence_of_element obj=new Solution_occurence_of_element();
        int[] result=obj.searchRange(arr, target);
        if(result[0]==-1)
            System.out.println("Element Not Found");
        System.out.println("["+result[0]+" , "+result[1]+"]");
    }
}

/**APPROACH
 * use binary search to find the first occurence of the element and 
 * similarly use binary search for finding the last occurence of the element
 */

class Solution_occurence_of_element {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=first(nums,target);
        result[1]=last(nums,target);
        return result;
    }
    
    //finding first occurence
    public int first(int[] nums,int target){
        int l=0,r=nums.length-1,mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                if(mid-1>=0 && nums[mid-1]==target)
                    r=mid-1;
                else{
                    return mid;
                }
            }
            else if(nums[mid]<target)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
    
    //finding last occurence
    public int last(int[] nums,int target){
        int l=0,r=nums.length-1,mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                if(mid+1<nums.length && nums[mid+1]==target)
                    l=mid+1;
                else{
                    return mid;
                }
            }
            else if(nums[mid]<target)
                l=mid+1;
            else
                r=mid-1;
        }
        return -1;
    }
}
