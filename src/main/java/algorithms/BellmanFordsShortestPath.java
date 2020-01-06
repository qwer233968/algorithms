package algorithms;

import java.util.Arrays;

public class BellmanFordsShortestPath {

    public static int[][] edges = new int[8][3];
    public static int N = 6;

    public static void init(){
        //A-B
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[0][2] = 10;
        //A-E
        edges[1][0] = 0;
        edges[1][1] = 4;
        edges[1][2] = 8;
        //B-C
        edges[2][0] = 1;
        edges[2][1] = 2;
        edges[2][2] = 8;
        //B-E
        edges[3][0] = 1;
        edges[3][1] = 4;
        edges[3][2] = -5;
        //D-C
        edges[4][0] = 3;
        edges[4][1] = 2;
        edges[4][2] = 2;
        //D-F
        edges[5][0] = 3;
        edges[5][1] = 5;
        edges[5][2] = 6;
        //E-D
        edges[6][0] = 4;
        edges[6][1] = 3;
        edges[6][2] = 7;
        //E-F
        edges[7][0] = 4;
        edges[7][1] = 5;
        edges[7][2] = 3;

        /*//D-B
        edges[8][0] = 3;
        edges[8][1] = 1;
        edges[8][2] = -8;*/
    }

    public static int[][] findShortestPath(int src, int n, int target, int[][] edges, String[] des) {
        /**
         * 对于一条边u -> v，设其权重为weight(u, v)，
         * 而结点u，v距离源结点src的距离分别为dist[u]，dist[v]。
         * 则dist[v] = min(dist[v], dist[u] + weight(u,v)
         */
        int[] dist = new int[n];
        int[] pre = new int[n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist, INF);
        //记录最短路径
        dist[src] = 0;
        Arrays.fill(pre, Integer.MAX_VALUE);
        //previous 上一个节点
        pre[src] = 0;
        //因为对于N个结点的图来说，不包含环的最短距离最长为N-1个边，所以该算法需要循环检查所有边N-1次
        //在每一次循环中该算法都检查所有的边。
        //对于第i次循环，算法将得到从源结点出发不超过i步能够到达的结点的最短距离
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], weight = edge[2];
                if (dist[v] > dist[u] + weight) {
                    pre[v] = u;
                }
                dist[v] = Math.min(dist[v], dist[u] + weight);
            }
        }

        /**
         * 算法将再多循环检查一遍所有的边并尝试更新最短路径。
         * 如果从源结点出发到某一点的最短距离在这一次循环中能够被更新，
         * 则说明在这一路径上至少存在一个权重之和为负的环,该负权重带环图 包含权重之和为负的环 问题无解。
         */
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (dist[u] < INF && dist[u] + weight < dist[v]) {
                System.out.println(des[src]+" -> "+ des[v] + ",路径上至少存在一个权重之和为负的环");
            }
        }

        int[][] ret = new int[n][2];
        for (int i = 0; i < n; i++) {
            ret[i] = new int[]{dist[i] == INF ? Integer.MAX_VALUE : dist[i], pre[i]};
        }
        System.out.print(des[target]);
        while (target != src){
            int previou = pre[target];
            System.out.print(" -> " + des[previou]);
            target = previou;
        }
        System.out.println();
        return ret;
    }

    public static void main(String[] args) {
        String[] des = {"A","B","C","D","E","F"};
        init();
        int src = 0;
        int target = 5;
        int[][] ret = findShortestPath(src,N,target, edges, des);
        System.out.println(des[src]+" -> "+des[target]+"最短路径="+ret[target][0]);
    }
}
