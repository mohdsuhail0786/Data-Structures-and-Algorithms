/**
 * You are given a 0-indexed integer array nums. For each index i (1 <= i <= nums.length - 2) the beauty of nums[i] equals:

2, if nums[j] < nums[i] < nums[k], for all 0 <= j < i and for all i < k <= nums.length - 1.
1, if nums[i - 1] < nums[i] < nums[i + 1], and the previous condition is not satisfied.
0, if none of the previous conditions holds.
Return the sum of beauty of all nums[i] where 1 <= i <= nums.length - 2.
 */

public class Sum_of_Beauty_in_the_array {
    public static void main(String[] args) {
        System.out.println(sumOfBeauties(new int[]{2,4,6,4}));
    }

    public static int sumOfBeauties(int[] nums) {
        int n=nums.length,beauty=0;
        
        //calculate the min element on the right of each element
        int[] minRight=new int[n];
        minRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) minRight[i]=Math.min(nums[i],minRight[i+1]);
        
        //variable for storing the maximum element till now
        int maxLeft=nums[0];
        for(int i=1;i<n-1;i++){
            if(nums[i]>maxLeft && nums[i]<minRight[i+1]) beauty+=2;
            else if(nums[i]>nums[i-1] && nums[i]<nums[i+1]) beauty+=1;
            maxLeft=Math.max(maxLeft,nums[i]);
        }
        return beauty;
    }
}
