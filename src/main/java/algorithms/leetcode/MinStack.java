package algorithms.leetcode;

public class MinStack {

    int[] stack;
    int start = 0;
    int INIT_LEN = 8;
    int minStack[];
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[INIT_LEN];
        minStack = new int[INIT_LEN];
    }

    public void push(int x) {
        stack[start] = x;
        if (start == 0) minStack[start] = x;
        else{
            if (minStack[start - 1] > x){
                minStack[start] = x;
            }else{
                minStack[start] = minStack[start - 1];
            }
        }
        start++;
        if (start == stack.length) resize();
    }

    public void pop() {
        if (start > 0) start--;
    }

    public int top() {
        return stack[start-1];
    }

    public int getMin() {
        return minStack[start-1];
    }

    public void resize(){
        int len = start * 2;
        int[] newStack = new int[len];
        int[] newMinStack = new int[len];
        for (int i=0;i<start;i++){
            newStack[i]=stack[i];
            newMinStack[i]=minStack[i];
        }
        stack = newStack;
        minStack = newMinStack;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(1);
        minStack.push(7);
        minStack.push(-9);
        minStack.push(11);
        minStack.push(0);
        minStack.push(5);
        int min1 = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min2 = minStack.getMin();
        System.out.println(min1);
        System.out.println(top);
        System.out.println(min2);
    }
}
