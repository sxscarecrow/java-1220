package com.shenxu.zuul.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的实现 先序 中序 后序 树的深度 树的翻转
 * @author shen_xu
 * @date 2021/8/14 2:32 下午
 */
public class BinaryTree {
    /**
     * 根节点
     */
    private Node root;

    public BinaryTree(){
        init();
    }

    /**
     * 初始化二叉树
     */
    private void init(){
        Node e = new Node("e", null, null);
        Node f = new Node("f", null, null);
        Node g = new Node("g", null, null);
        Node h = new Node("h", null, null);
        Node b = new Node("b", e, f);
        Node c = new Node("c", g, h);
        Node a = new Node("a", b, c);
        // 根节点
        root = a;
    }

    /**
     * 递归
     * 先序遍历 1.先根节点 2.左叶子节点 3.右叶子节点
     * @param node 根节点
     * @param list 保存输出的结果
     * @return 返回遍历的结果
     */
    public void preOrder(Node node, List<String> list){
        list.add(node.data);
        if (node.lchild != null){
            preOrder(node.lchild, list);
        }
        if (node.rchild != null){
            preOrder(node.rchild, list);
        }
    }

    /**
     * 递归
     * 中序遍历  1.左叶子节点 2.先根节点 3.右叶子节点
     * @param node 根节点
     * @param list 保存输出的结果
     */
    public void inOrder(Node node, List<String> list){
        if (node.lchild != null){
            preOrder(node.lchild, list);
        }
        list.add(node.data);
        if (node.rchild != null){
            preOrder(node.rchild, list);
        }
    }

    /**
     * 递归
     * 后序遍历   1.左叶子节点 2.右叶子节点 3.先根节点
     * @param node 根节点
     * @param list 保存输出的结果
     */
    public void postOrder(Node node, List<String> list){
        if (node.lchild != null){
            preOrder(node.lchild, list);
        }
        if (node.rchild != null){
            preOrder(node.rchild, list);
        }
        list.add(node.data);
    }

    /**
     * 求树的深度
     * @param node 根节点
     * @return 树的深度
     */
    public int getHigh(Node node){
        if (node == null){
            return 0;
        }
        if (node.rchild == null && node.lchild == null){
            return 1;
        }
        int l = 0, r = 0;
        if (node.lchild != null){
            l += getHigh(node.lchild);
        }
        if (node.rchild != null){
            r += getHigh(node.rchild);
        }
        return l > r ? l + 1 : r + 1;
    }

    /**
     * 树的翻转 递归来实现
     */
    public Node invert(Node node){
        if (node == null){
            return null;
        }
        node.lchild = invert(node.lchild);
        node.rchild = invert(node.rchild);
        swap(node);
        return node;
    }

    public void invertStack(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            Node res = stack.pop();
            swap(res);
            if (res.lchild != null){
                stack.push(res.lchild);
            }

            if (res.rchild != null){
                stack.push(res.rchild);
            }
        }
    }

    /**
     * 交换
     * @param node 节点
     */
    private void swap(Node node){
        Node tmp = node.lchild;
        node.lchild = node.rchild;
        node.rchild = tmp;
    }

  /**
     * 树的结构
     */
    private static class Node{
        private String data;
        private Node lchild;
        private Node rchild;

        public Node(String data, Node lchild, Node rchild){
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // 先序遍历
        List<String> perList = new ArrayList<>();
        tree.preOrder(tree.root, perList);
        System.out.println("perList = " + perList);

        // 中序遍历
        List<String> inList = new ArrayList<>();
        tree.inOrder(tree.root, inList);
        System.out.println("inList = " + inList);

        // 后序遍历
        List<String> postList = new ArrayList<>();
        tree.postOrder(tree.root, postList);
        System.out.println("postList = " + postList);

        // 树的深度
        int high = tree.getHigh(tree.root);
        System.out.println("high = " + high);

        // 树的翻转 递归
        Node invert = tree.invert(tree.root);
        // 翻转后先序遍历
        List<String> perInvertList = new ArrayList<>();
        tree.preOrder(invert, perInvertList);
        System.out.println("perInvertList = " + perInvertList);

        // 栈 翻转
        tree.invertStack(tree.root);
        // 翻转后先序遍历
        List<String> perInvertStackList = new ArrayList<>();
        tree.preOrder(tree.root, perInvertStackList);
        System.out.println("perInvertStackList = " + perInvertStackList);
    }
}
