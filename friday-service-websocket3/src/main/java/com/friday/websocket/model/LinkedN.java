package com.friday.websocket.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Simon.z
 * @since: 2020-12-01
 */
@Setter
@Getter
public class LinkedN {

    private int value;

    LinkedN next;

    public LinkedN(int value){
        this.value = value;
    }

    public LinkedN reverse(LinkedN head){
        LinkedN pre = null;
        LinkedN next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkedN head1 = new LinkedN(0);
        LinkedN head2 = new LinkedN(1);
        LinkedN head3 = new LinkedN(2);
        LinkedN head4 = new LinkedN(3);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head4);

        // 打印反转前
        LinkedN head = head1;
        while (head != null){
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }

        System.out.println();
        System.out.println("*******************");
        // 调用反转方法后
        head1 = head1.reverse(head1);
        while (head1 != null){
            System.out.print(head1.getValue() + " ");
            head1 = head1.getNext();
        }
        System.out.println();
    }
}
