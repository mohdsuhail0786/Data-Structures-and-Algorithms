
public class Pattern {
    public static void main(String[] args) {
        triangle(5);
        rightAngleTriangleBL(5);
        rightAngleTriangleBR(5);
        rightAngleTriangleTL(5);
        rightAngleTriangleTR(5);
        parallelogram(6, 3);
        rhombus(4);
        hollowRectangle(10);
    }

    //draw a triangle
    public static void triangle(int n){
        for(int i=1;i<=n;i++){
            //for spaces
            for(int k=1;k<=n-i;k++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    //draw a right angle triangle - 90deg at bottom left
    public static void rightAngleTriangleBL(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    //draw a right angle triangle - 90deg at bottom right
    public static void rightAngleTriangleBR(int n){
        for(int i=1;i<=n;i++){
            for(int k=1;k<=n-i;k++)
                System.out.print("  ");
            for(int j=1;j<=i;j++)
                System.out.print(" *");
            System.out.println();
        }
    }
    //draw a right angle triangle - 90deg at top left
    public static void rightAngleTriangleTL(int n){
        for(int i=5;i>=1;i--){
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    //draw a right angle triangle - 90deg at top right
    public static void rightAngleTriangleTR(int n){
        for(int i=5;i>=1;i--){
            for(int k=1;k<=n-i;k++)
                System.out.print("  ");
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    //draw a parallelogram lxh
    public static void parallelogram(int l,int h){
        for(int i=1;i<=h;i++){
            //print spaces
            for(int k=1;k<=i-1;k++)
                System.out.print("  ");
            for(int j=1;j<=l;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    //draw a rhombus of side n
    public static void rhombus(int n){
        //first print a triangle
        for(int i=1;i<=n;i++){
            //for spaces
            for(int k=1;k<=n-i;k++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();
        }
        //now append another triangle in opposite direction
        for(int i=n-1;i>=1;i--){
            for(int k=1;k<=n-i;k++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    //draw a hollow rectangle
    public static void hollowRectangle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || j==1 || i==n || j==n)
                    System.out.print("* ");
                else 
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
