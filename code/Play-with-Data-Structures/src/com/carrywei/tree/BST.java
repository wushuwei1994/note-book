package com.carrywei.tree;

import com.carrywei.queue.ArrayQueue;
import com.carrywei.queue.Queue;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

/**
 * 二分搜索树
 * Created by 吴蜀威 on 2020/3/12.
 */
public class BST<T extends Comparable<T>>  {
    private int size;
    private Node root;
    private class Node{
        T e;
        Node left, right;

        public Node(T e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素，循环遍历实现
     *
     * @param e
     */
//    public void add(T e) {
//        if (isEmpty()) {
//            root = new Node(e);
//        } else {
//            Node curNode = root;
//            while (true) {
//                if (curNode.e.compareTo(e) == 0) {
//                    return;
//                }
//                //当前元素大于待添加元素，说明待添加元素为
//                if (curNode.e.compareTo(e) > 0) {
//                    if (curNode.left == null) {
//                        curNode.left = new Node(e);
//                        break;
//                    }
//                    curNode = curNode.left;
//                } else {
//                    if (curNode.right == null) {
//                        curNode.right = new Node(e);
//                        break;
//                    }
//                    curNode = curNode.right;
//                }
//            }
//        }
//        size++;
//    }

    /**
     * 添加元素，递归实现
     * @param e
     */
    public void add(T e) {
        // 递归实现一
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }

    /**
     * 递归实现一
     *
     * @param root
     * @param e
     */
//    public void add(Node root, T e) {
//        if (root.e.equals(e)) {
//            return;
//        }
//        if (e.compareTo(root.e) < 0 && root.left == null) {
//            root.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(root.e) > 0 && root.right == null) {
//            root.right = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(root.e) < 0) {
//            add(root.left, e);
//        } else {
//            add(root.right, e);
//        }
//    }

    /**
     * 添加元素，递归实现二。往根为root的树添加节点，并返回已添加好节点树的引用
     * @param root
     * @param e
     * @return
     */
    private Node add(Node root, T e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        } else {
            // 相等，则不需要任何操作
        }
        return root;
    }

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    public boolean contains(T e) {
        return contains(root, e);
    }

    private boolean contains(Node root, T e) {
        if (root == null) {
            return false;
        }
        if (root.e.equals(e)) {
            return true;
        }
        if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历,递归实现
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历，递归实现
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        } else {
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * @param node
     */
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 前序遍历，非递归实现
     */
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            //先出栈访问当前节点，再把左右节点压入栈
            Node top = s.pop();
            System.out.println(top.e);
            if (top.right != null) {
                s.push(top.right);
            }
            if (top.left != null) {
                s.push(top.left);
            }
        }
    }

    /**
     * 前序遍历，非递归实现
     */
    public void inOrderNR() {
        Stack<Node> s = new Stack<>();
        Node cur = root;
        while (!s.isEmpty() || cur != null) {
            //先把所有左子树压入栈，再访问节点，再开始访问由节点
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            Node top = s.pop();
            System.out.println(top.e);
            cur = top.right;
        }
    }

    // 二分搜索树的层序遍历，借助队列实现
    public void levelOrder(){
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayQueue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }

    /**
     * 获取树最小值
     * @return
     */
    public T minimum() {
        if (root == null) {
            return null;
        }
        return minimum(root).e;
    }

    /**
     * 递归实现获取树最小值
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }

    /**
     * 获取树最大值
     * @return
     */
    public T maximum() {
        if (root == null) {
            return null;
        }
        return maximum(root).e;
    }

    /**
     * 递归实现获取树最大值
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return maximum(node.right);
        }
    }



    /**
     * 删除树最小值，并返回删除的值
     * @return
     */
    public T removeMin() {
        if (root == null) {
            return null;
        }
        T ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 获取根为node的树删除最小值后的根节点
     * @return
     */
    private Node removeMin(Node root) {
        if (root.left == null) {
            size--;
            Node rightNode = root.right;
            root.right = null;
            return rightNode;
        } else {
            root.left = removeMin(root.left);
        }
        return root;
    }

    /**
     * 删除树最大值，并返回删除的值
     * @return
     */
    public T removeMax() {
        if (root == null) {
            return null;
        }
        T ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 获取根为node的树删除最小值后的根节点
     * @return
     */
    private Node removeMax(Node root) {
        if (root.right == null) {
            size--;
            Node leftNode = root.left;
            root.left = null;
            return leftNode;
        } else {
            root.right = removeMax(root.right);
        }
        return root;
    }

    /**
     * 删除元素为e的节点
     * @param e
     */
    public void remove(T e) {
        root = remove(root, e);
    }

    /**
     * 删除根为root的树元素为e的节点，并返回根节点
     * @param root
     * @param e
     * @return
     */
    private Node remove(Node root, T e) {
        // 未找到元素
        if (root == null) {
            return null;
        }
        // 根节点元素大于e,则从左子树删除元素e
        if (root.e.compareTo(e) > 0) {
            root.left = remove(root.left, e);
        }
        // 根节点元素小于e,则从右子树删除元素e
        else if (root.e.compareTo(e) < 0) {
            root.right = remove(root.right, e);
        }
        // 找到相应的元素
        else{
            // 如果左子树为空，则返回右子树
            if (root.left == null) {
                Node delNode = root;
                root = root.right;
                //解除删除后的节点与原来树的关系
                delNode.right = null;
                size--;
            }
            // 如果右子树为空，则返回左子树
            else if (root.right == null) {
                Node delNode = root;
                root = root.left;
                delNode.left = null;
                size--;
            }
            // 都不为空，则需要删除该节点，并用右子树最小节点当成根节点，最后把新的根节点与原来的左右子树关联起来
            else {
                // 获取右子树最小节点
                Node newRoot = minimum(root.right);
                // 删除右子树最小节点,并把删除后的节点返回
                newRoot.right = removeMin(root.right);
                newRoot.left = root.left;
                Node delNode = root;
                root = newRoot;
                delNode.left = delNode.right = null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] testData = {12, 8, 7, 5, 20, 9, 10, 30, 40};
        BST bst = new BST<Integer>();
        for (int i = 0; i < testData.length; i++) {
            bst.add(testData[i]);
        }
//                8
//               / \
//              7   9
//             /     \
//            5       10
//        System.out.println(bst.contains(5));
//        System.out.println("前序遍历：");
//        bst.preOrder();
        System.out.println("中序遍历：");
        bst.inOrder();
//        System.out.println("后序遍历：");
//        bst.postOrder();

//        System.out.println("前序遍历，非递归实现:");
//        bst.preOrderNR();
//        System.out.println("中序遍历，非递归实现:");
//        bst.inOrderNR();
//        System.out.println("层序遍历：");
//        bst.levelOrder();
//        System.out.println("最小值：" + bst.minimum());
//        System.out.println("最大值：" + bst.maximum());

//        System.out.println("删除树最小值：" + bst.removeMin());
//        bst.inOrder();
//        System.out.println("删除树最小值：" + bst.removeMin());
//        bst.inOrder();
//        System.out.println("删除树最小值：" + bst.removeMin());
//        bst.inOrder();
//        System.out.println("删除树最大值：" + bst.removeMax());
//        bst.inOrder();
//        System.out.println("删除树最大值：" + bst.removeMax());
//        bst.inOrder();

        // 删除节点
        System.out.println("删除节点：20");
        bst.remove(20);
        bst.inOrder();
    }
}