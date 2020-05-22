package algorithms.leetcode;

import java.util.*;

public class TreeDemo {

    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode node = q.poll();
                list.add(node.val);
                size--;
                if (null != node.left) q.offer(node.left);
                if (null != node.right) q.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null || preorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack();
        //中序遍历指针
        int inorderIndex = 0;
        //头结点一定是前序遍历的 第一个
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i=1;i<preorder.length;i++){
            int preV = preorder[i];
            TreeNode node = stack.peek();
            //如果栈顶！= 中序遍历节点 那i节点一定是栈顶的左节点
            //因为中序遍历->先左-中-右。如果是栈顶右节点的话,必须==inorderIndex指针值
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preV);
                //更新 栈顶节点
                stack.push(node.left);
            }else{
                //如果栈顶==inorderIndex指针值，表示已经在树中存在
                //循环停止时,上次弹出的栈值 就是i节点的父节点
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preV);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root);*/
        TreeDemo demo = new TreeDemo();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode t = demo.buildTree(pre, in);
        System.out.println(t);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
