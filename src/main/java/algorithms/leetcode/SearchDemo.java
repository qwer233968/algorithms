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

    public static void main(String[] args) {
        MountainArray a = new MountainArray();
        int index = findInMountainArray(-1,a);
        System.out.println(index);
    }
}
