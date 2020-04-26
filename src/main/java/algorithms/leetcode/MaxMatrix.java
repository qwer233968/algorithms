package algorithms.leetcode;

import algorithms.PrintUtil;

/**
 * 给定一个正整数和负整数组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
 *
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 *
 */
public class MaxMatrix {
    static final int[][] matrix = {{9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}};

    static int[] getMaxMatrix(int[][] matrix){
        int result[] = new int[4];
        int m1 = 0 ,m2 = 0; //记录开始坐标
        int[] b = new int[matrix[0].length]; //每列的和
        int maxNum = Integer.MIN_VALUE;
        int N = matrix.length;
        int M = matrix[0].length;
        int sum = 0;
        for(int i=0;i<N;i++){
            for (int t=0;t<M;t++) b[t] = 0;
            for(int j=i;j<N;j++){
                sum = 0;
                for (int k=0;k<M;k++){
                    b[k]+=matrix[j][k];
                    if (sum > 0){
                        sum += b[k];
                    }else{
                        sum = b[k];
                        m1 = i;
                        m2 = k;
                    }
                    if (sum > maxNum){
                        maxNum = sum;
                        result[0] = m1;
                        result[1] = m2;
                        result[2] = j;
                        result[3] = k;
                    }
                }
            }
        }
        System.out.println(PrintUtil.toString(result));
        return result;
    }

    public static void main(String[] args) {
        getMaxMatrix(matrix);
    }
}
