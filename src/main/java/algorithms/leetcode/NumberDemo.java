package algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int start = 0;
        int end = 0;
        for (int i=0;i<s.length();i++){
            //位置i开始查询  奇数位
            int len1 = searchPalindrome(s,i,i);
            //位置i，i+1开始查询  偶数位
            int len2 = searchPalindrome(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end-start){
                //如果len=奇数则-1不影响结果
                //如果len=偶数,必须-1,因为是从位置i，i+1开始查询的,多了1位数
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 以left，right为起点，向外围扩散查询是否相等
     * 不相等则跳出循环，因不相等的时候已经向外围扩了1圈，所以需要-1
     */
    public int searchPalindrome(String s, int left, int right){
        int L=left, R=right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 判定是否有环: 假设 t 和 h 同时从起点 S 出发, t 的步长是一步, h 的步长是两步, 如果有环, 则 t 与 h 一定会在环上一点相遇, 记为 M.
     * 1 - 3
     * 3 - 4
     * 2 - 4
     * 4 - 4
     *
     * 如果t从起点出发，h从相遇位置出发，每次都移动一步，则t走了 a 步之后到达环的入口，
     * 快指针在环里走了 c 步，由于从相遇位置继续走 c 步即可回到环的入口，因此h也到达环的入口。
     * 两个指针在环的入口相遇，相遇点就是答案
     * 1  2
     * 3  4
     * 2  2
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        /*boolean is = isHappy(19);
        System.out.println(is);*/
        /*boolean is = validPalindrome("abc");
        System.out.println(is);*/
        NumberDemo demo = new NumberDemo();
        /*String s = demo.longestPalindrome("babaabad");
        System.out.println(s);*/
        int res = demo.findDuplicate(new int[]{3,1,4,2,3});
        System.out.println(res);
    }
}
