package algorithms.leetcode;

public class New21Game {

    /**
     * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
     *
     * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。
     * 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。
     * 每次抽取都是独立的，其结果具有相同的概率。
     *
     * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
     *
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        if (N==0 && K==0) return 1;
        if (N==0){
            return 0;
        }
        /**
         * 因为不少于 K 分时，她就停止抽取数字，所以抽取的最大分K-1+W，
         * 0,1,2,....,K-1,    K,k+1,K+2,...K+W-1
         *
         * dp 表示获胜概率，我们用dp数组表示
         *
         * 求dp[x]的获胜概率，意思是说 当前分数 再次抽取一张后 获胜概率为多少。
         * 那么dp[x]=(dp[x+1]+dp[x+2]+...+dp[x+W])/W
         * dp[x]为当前分数获胜概率，而W=[1,W]之间，则 累加1~W之间的所有概率和 再除以W 平均一下，就是结果
         */
        double[] dp = new double[K+W];
        double sum = 0;
        //k-1分后再次抽分会大于N停止，所以 K~~K+W 之间的获胜概率,大于N为0，小于等于N为1
        for (int i=K;i<K+W;i++){
            if (i <= N) dp[i] = 1;
            else dp[i] = 0;
            sum += dp[i];
        }
        //K-1的获胜概率= K的概率 累加到 K+W的概率  再除以W平均
        //因为已经累加了概率sum值，所以计算概率后，动态重新计算sum值，减去多余的dp[i+W],再累加 dp[i]当前值
        for (int i=K-1;i>=0;i--){
            dp[i] = sum/W;
            sum = sum - dp[i+W] + dp[i];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        New21Game n = new New21Game();
        double f = n.new21Game(21,17,10);
        System.out.println(f);
    }
}
