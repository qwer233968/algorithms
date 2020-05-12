package algorithms.leetcode;

public class MinStack {

    int[] stack;
    int start = 0;
    int INIT_LEN = 8;
    int sortStack[];
    boolean isSort = false;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[INIT_LEN];
    }

    public void push(int x) {
        stack[start] = x;
        start++;
        isSort = false;
        if (start == stack.length) resize();
    }

    public void pop() {
        if (start > 0) start--;
        isSort = false;
    }

    public int top() {
        return stack[start-1];
    }

    public int getMin() {
        if (isSort) return sortStack[start-1];
        sortStack();
        return sortStack[start-1];
    }

    public void sortStack(){
        sortStack = new int[start];
        for (int i=0;i<start;i++){
            sortStack[i] = stack[i];
        }
        for (int i=0;i<start-1;i++){
            for (int j=0;j<start-1-i;j++){
                if (sortStack[j]<sortStack[j+1]){
                    int temp = sortStack[j];
                    sortStack[j] = sortStack[j+1];
                    sortStack[j+1] = temp;
                }
            }
        }
        isSort = true;
    }

    public void resize(){
        int len = start * 2;
        int[] newStack = new int[len];
        for (int i=0;i<start;i++){
            newStack[i]=stack[i];
        }
        stack = newStack;
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
