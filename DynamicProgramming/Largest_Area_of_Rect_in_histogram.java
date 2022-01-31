import java.util.*;

public class Largest_Area_of_Rect_in_histogram{
    public static void main(String[] args) {
        Solution_histogram obj=new Solution_histogram();
        int result=obj.largestRectangleArea(new int[]{2,3,4,5,6,1});
        System.out.println(result);
    }
}

class Solution_histogram {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] rb=new int[n];
        int[] lb=new int[n];
        Stack<Integer> st=new Stack<>();
        //left bound first
        st.push(0);
        lb[0]=-1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty())
                lb[i]=-1;
            else
                lb[i]=st.peek();
            st.push(i);
        }
        
        //right bound
        st=new Stack<>();
        st.push(n-1);
        rb[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            
            if(st.isEmpty())
                rb[i]=n;
            else
                rb[i]=st.peek();
            st.push(i);
        }
        
        //calculate the area
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int width=rb[i]-lb[i]-1;
            maxArea=Math.max(maxArea,width*heights[i]);
        }
        return maxArea;
    }
}