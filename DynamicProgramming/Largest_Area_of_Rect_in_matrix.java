import java.util.*;

public class Largest_Area_of_Rect_in_matrix {
    
}

class Solution {
    public int maxArea(int mat[][], int n, int m) {
        int[] heights=new int[m];
        for(int i=0;i<m;i++)
            heights[i]=mat[0][i];
        int maxRectArea = Integer.MIN_VALUE;
        maxRectArea = Math.max(maxRectArea,largestRectangleArea(heights));
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    heights[j]=0;
                else
                    heights[j]=heights[j]+mat[i][j];
            }
            maxRectArea = Math.max(maxRectArea,largestRectangleArea(heights));
        }
        return maxRectArea;
    }
    
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
