package com.shenxu.zuul.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表的相关操作
 * @author shen_xu
 * @date 2021/8/14 4:33 下午
 */
public class SingleLinked {

    private Node head;

    public SingleLinked(){
        init();
    }

    public void init(){
        Node f = new Node("f", null);
        Node e = new Node("e", f);
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);
        head = a;
    }

    /**
     * 遍历链表
     * @param head 头
     * @param list 储存结果
     */
    public void getList(Node head, List<String> list){
        if (head == null){
            return;
        }
        list.add(head.value);
        while (head.next != null){
            list.add(head.next.value);
            head = head.next;
        }
    }

    /**
     * 链表翻转 递归
     * @param head 头
     * @return 新链表
     */
    public Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node tmp = head.next;
        Node newHead = reverse(head.next);
        tmp.next = head;
        head.next = null;
        return newHead;
    }

    // todo 遍历法
    public Node reverseList(Node head){
        Node curr = head;
        Node pre = null;

        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private static class Node{
        private String value;
        private Node next;

        public Node(String value, Node node){
            this.value = value;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        SingleLinked linked = new SingleLinked();

        // 链表遍历
        List<String> list = new ArrayList<>();
        linked.getList(linked.head, list);
        System.out.println("list = " + list);

        // 链表翻转
        Node reverse = linked.reverse(linked.head);
        List<String> reverseList = new ArrayList<>();
        linked.getList(reverse, reverseList);
        System.out.println("reverseList = " + reverseList);

        List<String> end = new ArrayList<>();
        linked.getList(linked.head, end);
        System.out.println("end = " + end);
    }
}
