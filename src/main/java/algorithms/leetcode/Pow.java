package algorithms.leetcode;

public class Pow {
    public static double myPow(double x, long n){
        return n >=0 ? foreach(x, n) : 1/foreach(x, -n);
    }

    public static double foreach(double x, long n){
        if (n == 0)
            return 1.0;
        double y = foreach(x,n/2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        double t = myPow(2,-2);
        System.out.println(t);
    }
}
