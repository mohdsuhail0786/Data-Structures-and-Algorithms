/*
Input: rows=4
       1
      1 1
     1 2 1
    1 3 3 1
*/

public class Pascal_triangle {
    public static void main(String[] args) {
        Solution_pascal_triangle obj=new Solution_pascal_triangle();
        obj.drawTriangle(5);
        System.out.println("Element is:"+obj.findKthElementOfNthRow(5, 3));//5th row-3rd element
        obj.printNthRow(5);
    }
}

class Solution_pascal_triangle{
    void drawTriangle(int rows){
        int[][] arr=new int[rows][rows];
        for(int i=0;i<rows;i++){
            //print spaces
            for(int k=0;k<rows-i-1;k++)
                System.out.print(" ");
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    arr[i][j]=1;
                else
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    int findKthElementOfNthRow(int n,int k){
        int res=1;
        for(int i=0;i<k-1;i++){
            res*=(n-1-i);
            res/=(i+1);
        }
        return res;
    }

    void printNthRow(int n){
        int res=1;
        for(int i=0;i<n;i++){
            System.out.print(res+" ");
            res*=(n-1-i);
            res/=(i+1);
        }
    }
}
