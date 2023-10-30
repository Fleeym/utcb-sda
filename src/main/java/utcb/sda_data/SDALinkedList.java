package utcb.sda_data;

public class SDALinkedList<T> {
    public SDALinkedListNode<T> head = null;
    public SDALinkedListNode<T> tail = null;

    private void initializeList(T data) {
        head = new SDALinkedListNode<>();
        head.data = data;
        tail = head;
    }

    public void insertLast(T item) {
        if (head == null) {
            initializeList(item);
            return;
        }

        SDALinkedListNode<T> newItem = new SDALinkedListNode<>();
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
        SDALinkedListNode<T> newItem = new SDALinkedListNode<>();
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

        SDALinkedListNode<T> current = head;
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
