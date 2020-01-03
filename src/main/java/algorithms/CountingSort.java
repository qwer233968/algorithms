package cn.mq.util.algorithms;

import java.util.Random;

public class CountingSort {
    public static int N = 10;

    public static void printArray(int[] array, String tag){
        System.out.print(tag + " = ");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[N];
        int[] counts = new int[N];
        int[] sorted = new int[N];
        for (int i=0;i<N;i++){
            array[i] = r.nextInt(N);
        }
        printArray(array,"待排序数组");

        for (int i=0;i<array.length;i++){
            counts[array[i]]++;
        }
        printArray(counts,"计算数据出现多少次");

        for (int i=1;i<counts.length;i++){
            counts[i]+=counts[i-1];
        }
        printArray(counts,"计算数据应该排在多少位");

        //开始排序
        for (int i=array.length-1;i>=0;i--){
            int pos = counts[array[i]];
            sorted[pos-1] = array[i];
            counts[array[i]]--;
        }
        printArray(sorted,"排序");
    }
}
