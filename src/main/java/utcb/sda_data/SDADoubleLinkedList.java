package utcb.sda_data;

class SDADoubleLinkedListNode<T> {
    public T data;
    public SDADoubleLinkedListNode<T> next;
    public SDADoubleLinkedListNode<T> previous;
}

public class SDADoubleLinkedList<T> {
    private SDADoubleLinkedListNode<T> head = null;
    private SDADoubleLinkedListNode<T> tail = null;

    private void initializeList(T data) {
        head = new SDADoubleLinkedListNode<>();
        head.data = data;
        tail = head;
    }

    public void insertLast(T item) {
        if (head == null) {
            initializeList(item);
            return;
        }

        SDADoubleLinkedListNode<T> newItem = new SDADoubleLinkedListNode<>();
        newItem.data = item;
        if (head == tail) {
            newItem.previous = head;
            head.next = newItem;
            tail = newItem;
            return;
        }

        tail.next = newItem;
        newItem.previous = tail;
        tail = newItem;
    }

    public void insertFirst(T item) {
        if (head == null) {
            initializeList(item);
            return;
        }
        SDADoubleLinkedListNode<T> newItem = new SDADoubleLinkedListNode<>();
        newItem.data = item;

        head.previous = newItem;
        newItem.next = head;
        head = newItem;
    }

    public T removeLast() {
        T ret;
        if (head == tail) {
            ret = head.data;
            head = null;
            tail = null;
            return ret;
        }

        ret = tail.data;
        tail = tail.previous;
        tail.next = null;
        return ret;
    }

    public T removeFirst() {
        T ret;
        if (head == tail) {
            ret = head.data;
            head = null;
            tail = null;
            return ret;
        }

        ret = head.data;
        head = head.next;
        head.previous = null;
        return ret;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        SDADoubleLinkedListNode<T> current = head;
        while (current != null) {
            sb.append(current.data.toString());
            sb.append(", ");
            current = current.next;
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }
}
