package utcb.sda3;

import utcb.sda_data.SDADoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        SDADoubleLinkedList<Integer> list = new SDADoubleLinkedList<>();
        list.insertLast(3);
        list.insertLast(5);
        list.insertFirst(1);
        list.removeFirst();
        list.removeLast();
        list.removeLast();
        list.insertFirst(5);
        list.insertLast(3);
        System.out.println(list);
    }
}
