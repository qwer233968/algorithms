package cn.mq.util.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索算法
 * 不适用 有负权环路的图
 */
public class BFSShortPath {
    /**
     * 权重图的 数组表示法
     */
    static int[][] weight = {
            {0, 10, 0, 0, 8, 0},
            {0, 8, 0, 0, -5, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 0, 6},
            {0, 0, 0, 7, 0, 3},
            {0, 0, 0, 0, 0, 0},
    };
    static int N = 6;
    static int[] W = new int[N];
    static Queue<Integer> Q = new LinkedList<Integer>();
    static int bfs(int start, int target){
        Arrays.fill(W, Integer.MAX_VALUE);
        W[start] = 0;
        Q.offer(start);
        while (!Q.isEmpty()){
            //返回第一个元素，并在队列中删除
            int node = Q.poll();
            for (int i=0;i<weight[node].length;i++){
                if (weight[node][i] != 0){
                    if (W[i] > W[node] + weight[node][i]){
                        W[i] = W[node] + weight[node][i];
                        Q.offer(i);
                    }
                }
            }
        }
        return W[target];
    }

    public static void main(String[] args) {
        int start = 0;
        int target = 5;
        int min = bfs(start, target);
        String[] des = {"A","B","C","D","E","F"};
        System.out.println(des[start]+" -> "+des[target]+"最短路径="+min);
    }
}
