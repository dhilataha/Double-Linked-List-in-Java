public class Node {
    int data;
    Node next, prev;
    public Node(int data) {
        this.data = data;
    }
    public void show() {
        System.out.print("["+data+"]");
    }
}