package cn.sh.lz.cig.c2p13;

import cn.sh.lz.cig.c2c.LinkedNode;
import cn.sh.lz.cig.c2c.Node;

/**
 * Created by Link at 10:50 on 2023/08/07.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */
public class MockTest {
    public static void main(String[] args) {
        int[] l = new int[]{1, 2, 3, 3, 4, 4, 2, 1, 1};
        Node node = new Node();
        LinkedNode head = node.build(l);
        node.print(head);
        /**
         * 问题：删除单链表重复值
         */
        node.removeDuplicates(head);
        node.print(head);

        head = node.build(l);
        node.print(head);

        node.removeDuplicates2(head);
        node.print(head);
    }
}
