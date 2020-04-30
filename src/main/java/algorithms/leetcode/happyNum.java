package algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class happyNum {
    public static boolean isHappy(int n) {
        if (n < 0) return false;
        int powSum = 0;
        Set<Integer> set = new HashSet<Integer>();
        do {
            if (powSum != 0)set.add(powSum);
            powSum = 0;
            String str = String.valueOf(n);
            int len = str.length();
            for (int i=0;i<len;i++){
                System.out.print(str.charAt(i));
                System.out.print("-");
                powSum += Math.pow(Integer.parseInt(str.substring(i,i+1)),2);
            }
            System.out.println();
            System.out.println(powSum);
            if (powSum == 1) {
                return true;
            } else {
               n = powSum;
            }
        }while (!set.contains(powSum));
        return false;
    }

    public static void main(String[] args) {
        boolean is = isHappy(19);
        System.out.println(is);
    }
}
