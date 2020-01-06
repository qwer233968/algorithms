package algorithms;

import java.util.Arrays;

/**
 * 深度优先搜索算法
 */
public class DFSShortPath {
    /**
     * 带权重有向图的 数组表示法
     */
    public static int[][] weightArray = {
            {0, 10, 0, 0, 8, 0},
            {0, 8, 0, 0, -5, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 0, 6},
            {0, 0, 0, 7, 0, 3},
            {0, 0, 0, 0, 0, 0},
    };
    static int N = 6;
    static Boolean[] W = new Boolean[N];
    static int minWeight = Integer.MAX_VALUE;
    static int start = 0;
    static int target = 5;
    public static void dfs(Integer node, Integer parent, Integer weight){
        if (minWeight < weight) {
            return;
        }
        /**
         * 无论 多少可达线路，最终都会执行这里。
         * 每条路线递归计算出总权重，计算出每条线路总权重中 最小的
         * weight 就是当前线路递归出的总权重
         * minWeight 已知的最小权重
         */
        if (node == target) {
            if (minWeight > weight) {
                minWeight = weight;
            }
            return;
        }
        W[node] = true;
        for (int i=0;i<weightArray[node].length;i++){
            if (weightArray[node][i] != 0){
                if (!W[i]){
                    dfs(i, node, weight + weightArray[node][i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Arrays.fill(W, false);
        dfs(start, null, 0);
        String[] des = {"A","B","C","D","E","F"};
        System.out.println(des[start]+" -> "+des[target]+"最短路径="+minWeight);
    }
}
