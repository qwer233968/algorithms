package algorithms.leetcode;

public class MountainArray {
    //[0,1,2,4,2,1]
    //3
    //[1,5,2]
    //2  5
    //[0,1,5,3,0]
    //0
    //[0,5,3,1]
    //1

    public static final int[] array = {0,1,5,3,0};
    public int get(int index) {
        return array[index];
    }
    public int length() {
        return array.length;
    }
}
