package algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberDemo {

    /**
     * 校验数字是否为快乐数
     * 在给定的进位制下，该数字所有数位(digits)的平方和，得到的新数再次求所有数位的平方和，如此重复进行，最终结果必为1。
     * 以十进位为例：
     * 2 8 → 2²+8²=68 → 6²+8²=100 → 1²+0²+0²=1
     * @param n
     * @return
     */
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

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 输入: "abca" acba
     * 输出: True
     * 解释: 你可以删除c字符。
     * @param s    vabcggcba    abcgcba   cgggc
     * @return
     */
    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }else{
                boolean flag1 = true;
                boolean flag2 = true;
                for (int i=start,j=end-1;i<j;i++,j--){
                    if (s.charAt(i) != s.charAt(j)) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i=start+1,j=end;i<j;i++,j--){
                    if (s.charAt(i) != s.charAt(j)) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*boolean is = isHappy(19);
        System.out.println(is);*/
        boolean is = validPalindrome("abc");
        System.out.println(is);
    }
}
