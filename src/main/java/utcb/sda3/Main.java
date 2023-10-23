package utcb.sda3;

import utcb.sda_data.SDADoubleLinkedList;
import utcb.sda_data.SDADoubleLinkedListNode;

public class Main {
    public static void main(String[] args) {
        // Testam ca merge
        System.out.println("---- Test Initial ----");
        SDADoubleLinkedList<Integer> list = new SDADoubleLinkedList<>();
        list.insertLast(3);
        list.insertLast(5);
        list.insertFirst(1);
        System.out.printf("Dupa adaugari: %s\n", list);
        list.removeFirst();
        System.out.printf("Am sters primul: %s\n", list);
        list.removeLast();
        System.out.printf("Am sters ultimul: %s\n", list);
        list.removeLast();
        System.out.printf("Am sters ultimul: %s\n", list);
        list.insertFirst(5);
        list.insertLast(3);
        System.out.println(list);

        // Aplicatia 1 - Schimba fiecare aparitie a lui 'x' cu 'X'
        System.out.println("---- Aplicatia 1 ----");
        SDADoubleLinkedList<Character> list2 = new SDADoubleLinkedList<>();
        list2.insertLast('d');
        list2.insertLast('e');
        list2.insertLast('x');
        list2.insertLast('f');
        System.out.printf("Inainte de transformare: %s\n", list2);
        replaceX(list2);
        System.out.printf("Dupa transformare: %s\n", list2);

        // Aplicatie 2 - de cate ori apare 'ab'?
        System.out.println("---- Aplicatia 2 ----");
        list2.insertLast('f');
        list2.insertLast('f');
        list2.insertLast('a');
        list2.insertLast('b');
        list2.insertLast('f');
        list2.insertLast('f');
        list2.insertLast('a');
        list2.insertLast('b');
        System.out.printf("Forma listei: %s\n", list2);
        System.out.printf("Am gasit 'ab' de %d ori in lista%n", countAB(list2));
    }

    public static int countAB(SDADoubleLinkedList<Character> list) {
        int count = 0;
        SDADoubleLinkedListNode<Character> current = list.head;
        while (current != null) {
            if (current.next == null) {
                break;
            }

            if (current.data == 'a' && current.next.data == 'b') {
                count++;
            }
            current = current.next;
        }

        return count;
    }

    public static void replaceX(SDADoubleLinkedList<Character> list) {
        SDADoubleLinkedListNode<Character> current = list.head;
        while (current != null) {
            if (current.data == 'x') {
                current.data = 'X';
            }
            current = current.next;
        }
        return;
    }
}
