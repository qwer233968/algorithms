package algorithms.leetcode;

import java.util.Arrays;

public class SearchDemo {

    /**
     * 2分查找法
     * @param start 开始
     * @param end 结尾
     * @param mountainArr  数组
     * @param target  目标
     * @param asc  升序true/降序false
     * @return
     */
    public static int search(int start, int end, MountainArray mountainArr, int target, boolean asc){
        while(start <= end){
            int mid = (start + end)/2;
            int val = mountainArr.get(mid);
            if (val == target){
                return mid;
            }
            if (val < target){
                start = asc ? mid + 1 : start;
                end = asc ? end : mid - 1;
            }else{
                start = asc ? start : mid + 1;
                end = asc ? mid - 1 : end;
            }
        }
        return -1;
    }

    /**
     * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
     *
     * 如果不存在这样的下标 index，就请返回 -1。
     *
     * @param target
     * @param mountainArr
     * @return
     */
    public static int findInMountainArray(int target, MountainArray mountainArr){
        int end = mountainArr.length() - 1;
        int start = 0;
        while (start<end){
            int mid = (start + end)/2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        int peek = start;
        int index = -1;
        index = search(0,peek,mountainArr,target,true);
        if (index == -1)
            index = search(peek+1, mountainArr.length()-1,mountainArr,target, false);
        return index;
    }

    /**
     * 查询数组中只出现1次的数字
     * int[] test = {1,2,1,3,3};
     * @param nums
     * @return 2
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i=0;i<len;i++){
            int sum = 0;
            for (int j=i;j>=0;j--){
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）
     * 并返回该子数组所对应的乘积。
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i=0;i<len;i++){
            int multiply = 1;
            for (int j=i;j>=0;j--){
                multiply *= nums[j];
                if (multiply > res) res = multiply;
            }
        }
        return res;
    }

    /**
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
     *  每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        /**
         * 以2进制表示 5个元音字母出现的奇偶性 00000 ~ 11111
         * 正好可以用数组最大值 1 << 5=11111表示
         */
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            /**
             * ^ 运算 同0异1 可以表示出现的奇偶
             */
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            /**
             * 如果一个元音字母出现的次数为偶数，则对应的2进制位一定=0
             * 如果一个元音字母出现的次数为奇数，则对应的2进制位一定=1
             * pos[0]=0
             *
             */
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       /* MountainArray a = new MountainArray();
        int index = findInMountainArray(-1,a);
        System.out.println(index);*/
       /*int[] test = {1,2,1,3,3};
        int t =singleNumber(test);
        System.out.println(t);*/
        /*int[] test = {1,1,1};
        int t = subarraySum(test, 2);
        System.out.println(t);*/
        /*int[] test = {-2,0,-1};
        int t = maxProduct(test);
        System.out.println(t);*/
        SearchDemo demo = new SearchDemo();
        int len = demo.findTheLongestSubstring("eleetminicoworoep");
        System.out.println(len);
    }
}
