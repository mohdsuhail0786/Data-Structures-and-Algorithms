public class Nth_fib {
    public static void main(String[] args) {
        int n=10;
        int a=0,b=1,c=0;
        for(int i=0;i<n-2;i++){
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println(c);
    }
}
