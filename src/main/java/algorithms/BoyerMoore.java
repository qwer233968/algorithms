package cn.mq.util.algorithms;

public class BoyerMoore {

    /**
     * 首先，candidate被设置为第一个元素1，count也变成1，由于1不是多数元素，
     * 所以当扫描到数组某个位置时，count一定会减为0。在我们的例子中，当扫描到第四个位置时，count变成0.
     * count 值变化过程：
     * [1,2,1,0……
     *
     * 当count变成0时，对于每一个出现的1，我们都用一个0与其进行抵消，所以我们消耗掉了与其一样多的0，
     * 而0是多数元素，这意味着当扫描到第四个位置时，我们已经最大程度的消耗掉了多数元素。
     * 然而，对于数组从第五个位置开始的剩余部分，0依然是其中的多数元素
     * (注意，多数元素出现次数大于? n/2 ?，而我们扫描过的部分中多数元素只占一般，那剩余部分中多数元素必然还是那个数字)。
     * 如果之前用于抵消的元素中存在非多数元素，那么数组剩余部分包含的多数元素就更多了。
     *
     * 类似的，假设第一个数字就是多数元素，那么当count减为0时，我们消耗掉了与多数元素一样多的非多数元素，
     * 那么同样道理，数组剩余部分中的多数元素数值不变。
     *
     * 这两种情况证明了关键的一点：数组中从candidate被赋值到count减到0的那一段可以被去除，
     * 余下部分的多数元素依然是原数组的多数元素。
     * 我们可以不断重复这个过程，直到扫描到数组尾部，那么count必然会大于0，
     * 而且这个count对应的candinate就是原数组的多数元素。
     */
    public static int[] array = {1,1,0,0,0,1,0};
    public static void main(String[] args) {
        int candidate = 0;
        int count = 0;
        for (int i=0;i<array.length;i++){
            if (count == 0){
                candidate = array[i];
            }
            if (array[i] == candidate){
                count++;
            }else{
                count--;
            }
        }
        System.out.println("多数元素="+candidate);
        int tmp_count=0;
        for(int j=0;j<array.length;j++){
            if(array[j]==candidate){
                tmp_count++;
            }
        }
        //检验number是否超过了总数的一半
        if(tmp_count>=(float)(array.length+1)/2){
            System.out.println(candidate+" 超过了半数");
        }else{
            System.out.println(candidate+" 未超过半数");
        }

        /**
         * 并行算法实现
         * 基本思想为对原数组采用分治的方法，把数组划分成很多段(每段大小可以不相同)，
         * 在每段中计算出candidate-count二元组，然后得到最终结果
         *
         * 举个例子，原数组为[1,1,0,1,1,0,1,0,0]
         * 划分1：
         * [1,1,0,1,1] –> (candidate,count)=(1,3)
         * 划分2：
         * [0,1,0,0] –> (candidate,count)=(0,2)
         * 根据(1,3)和(0,2)可得，原数组的多数元素为1.
         */
    }
}
