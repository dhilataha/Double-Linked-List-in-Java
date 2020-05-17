public class DLLApp {
    public static void main(String[] aris) {
        DoubleLinkedList link = new DoubleLinkedList();        
        link.addHead(3);
        link.addHead(13);
        link.addHead(5);
        link.addHead(71);
        link.addHead(21);
        link.addHead(62);
        link.printForward();
        link.search(13);
        link.addMid(89, 22);
        System.out.println(link.first.data);
        System.out.println(link.last.data);
    }
}