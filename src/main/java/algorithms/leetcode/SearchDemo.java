package algorithms.leetcode;

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
        if (nums.length == 0) return 0;
        int pos = 0;
        int len = nums.length;
        int sum = 0;
        int count = 0;
        for (int i=0;i<len;i++){
            if (nums[i] == k && pos > 0) count++;
            sum += nums[i];
            if (sum == k) count++;
            int innerSum = sum;
            for (int j=0;j<i;j++){
                innerSum -= nums[j];
                if (innerSum == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
       /* MountainArray a = new MountainArray();
        int index = findInMountainArray(-1,a);
        System.out.println(index);*/
       /*int[] test = {1,2,1,3,3};
        int t =singleNumber(test);
        System.out.println(t);*/
        int[] test = {1,1,1,-2,1};
        int t = subarraySum(test, 0);
        System.out.println(t);
    }
}
