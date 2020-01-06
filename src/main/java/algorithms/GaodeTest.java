package algorithms;

public class GaodeTest {

    public static int[][] edges = new int[10][3];
    public static int N = 9;
    public static String[] des = {"来广营","春华路","望京北路","立汤路",
            "北苑东路","辛店路","北苑路","立水桥东1路","天通苑"};
    public static void init(){
        /**
         * edges 节点
         * 一维数组 表示第N个节点
         * 二维数组 0 节点本身
         *          1 与第N个节点的边
         *          2 权重
         */
        //来广营 - 春华路
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[0][2] = 4;
        //来广营 - 望京北路
        edges[1][0] = 0;
        edges[1][1] = 2;
        edges[1][2] = 1;
        //春华路 - 立汤路
        edges[2][0] = 1;
        edges[2][1] = 3;
        edges[2][2] = 2;
        //春华路 - 北苑东路
        edges[3][0] = 1;
        edges[3][1] = 4;
        edges[3][2] = 2;
        //望京北路 - 辛店路
        edges[4][0] = 2;
        edges[4][1] = 5;
        edges[4][2] = 2;
        //辛店路 - 北苑路
        edges[5][0] = 5;
        edges[5][1] = 6;
        edges[5][2] = 2;
        //北苑路 - 立汤路
        edges[6][0] = 6;
        edges[6][1] = 3;
        edges[6][2] = 2;
        //北苑东路 - 立水桥东1路
        edges[7][0] = 4;
        edges[7][1] = 7;
        edges[7][2] = 2;
        //立水桥东1路 - 天通苑
        edges[8][0] = 7;
        edges[8][1] = 8;
        edges[8][2] = 1;
        //立汤路 - 天通苑
        edges[9][0] = 3;
        edges[9][1] = 8;
        edges[9][2] = 1;
    }

    public static void main(String[] args) {
        init();
        int src = 0;
        int target = 8;
        int[][] ret = BellmanFordsShortestPath.findShortestPath(src,N,target, edges, des);
        System.out.println(des[src]+" -> "+des[target]+"最短路径="+ret[target][0]);
    }
}
