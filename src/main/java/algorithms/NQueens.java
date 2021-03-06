package algorithms;

public class NQueens {
    //4个皇后
    static final int N = 4;
    //记录皇后位置
    protected static int[][] queens = new int[N][2];
    static void init(){
        for (int i=0;i<N;i++){
            queens[i][0] = -1;
            queens[i][1] = -1;
        }
    }

    /**
     * 获取指定皇后位置
     * @param targetQueen 目标
     * @return
     */
    static int[] getQueenPos(int targetQueen){
        return queens[targetQueen];
    }

    /**
     * 判断皇后周围是否有其他皇后
     * @param row 行
     * @param col 列
     * @param targetQueen 需要查询的皇后
     * @return
     */
    static boolean valideQueen(int row, int col, int targetQueen){
        for (int i=0;i<targetQueen;i++){
            int[] qPos = getQueenPos(i);
            if (qPos[0] == row || qPos[1] == col || (Math.abs(qPos[0] - row) == Math.abs(qPos[1] - col))){
                return false;
            }
        }
        return true;
    }

    static boolean nQ(int col, int targetQueen){
        if (targetQueen >= N){
            return true;
        }
        boolean found = false;
        int row = 0;
        while(row < N && (!found)){
            if (valideQueen(row, col, targetQueen)){
                queens[targetQueen][0] = row;
                queens[targetQueen][1] = col;
                System.out.println("找到位置Queen：" + targetQueen + ", row："+row+", col："+col);
                found = nQ(col+1, targetQueen+1);
            }
            if (!found){
                System.out.println("未找到位置Queen：" + targetQueen + ", row："+row+", col："+col);
            }
            row++;
        }
        return found;
    }

    public static void main(String[] args) {
        nQ(0,0);

        //打印出皇后位置图
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                boolean flag = false;
                for (int q=0;q<N;q++){
                    if (queens[q][0] == i && queens[q][1] == j){
                        flag = true;
                    }
                }
                if (flag){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
        System.out.println("结束");
    }
}
