package DataStruct.linear.list;

import DataStruct.linear.LinearList;

public class NodeList<T> implements LinearList<T> {

    private Node<T> head = null;
    private Node<T> back = null;
    private int     size = 0;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T element) {
        if (back==null&&head==null){
            // empty
            head = new Node<>(element);
            back = head;
        }else{
            back.last = new Node<>(element);
            back.last.next = back;
            back = back.last;
        }
    }

    @Override
    public T pop() {
        if (this.size<1) {
            Node<T> temp = head;
            head = head.last;
            head.next = null;
            return temp.value;
        }else {
            T temp = this.back.value;
            this.head = null;
            this.back = null;
            return temp;
        }
    }

    @Override
    public void show() {
        Node<T> temp = this.back;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}


class Node<T>{

    public T value;
    public Node<T> next = null;
    public Node<T> last = null;

    public Node(T value){
        this.value = value;
    }

}