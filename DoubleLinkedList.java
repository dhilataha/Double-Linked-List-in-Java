public class DoubleLinkedList {
    Node first, last;
    public DoubleLinkedList() {
        // first = null;
        // last = null;
    }
    public boolean isEmpty() {
        return (first == null);
    }
    public void addHead (int data) {        // Menambah Node dari Depan
        Node node = new Node (data);
        if (isEmpty()) {
            last = node;
        } else {
            first.prev = node;
        }
        node.next = first;
        first = node;
    }
    public void addTail (int data) {        // Menambah Node dari Belakang
        Node node = new Node (data);
        if (isEmpty()) {
            addHead(data);
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
    }
    public void addMid(int data, int index){        // Menambah Node dari Index
        if (index == 0) {
            addHead(data);
            return;
        }
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
            if (current == null) {
                System.out.println("Index yang di Masukkan Lebih Dari " + count());
                return;
            }
        }
        Node node = new Node(data);
        if(current == last){
           addTail(data);
           return;
        }
        node.next = current.next;
        current.next.prev = node;
        node.prev = current;
        current.next = node;
    }
    public void deleteHead() {                  // Menghapus Node dari Depan
        if (isEmpty()) {
            return;
        }
        first = first.next;
        return; 
    }
    public void deleteTail() {                  // Menghapus Node dari Belakang
        if (isEmpty()) {
            return;
        }
        last.prev.next = null;
        last = last.prev;
        return; 
    }
    public void deleteData(int data) {          // Menghapus data
        Node current = first;
        if (current.data == data) {
            deleteHead();
            return;
        }
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public void search(int data) {              // Mencari data
        Node current = first;
        int index = 1;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Data " + data + " Terletak di Posisi " + index);
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println("Data Tidak di Temukan");
    }
    private int count() {
        Node current = first;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
    public void nodeLength() {                  // Mencari Panjang Node
        int length = count();
        System.out.println("Panjang Node adalah " + length);
    }
    public void sum() {                         // Menghitung Jumlah data di Node
        Node current = first;
        int sum = 0;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        System.out.println("Jumlah Keseluruhan adalah " + sum);
    }
    public void max() {                         // Mencari Nilai Max Dalam Node
        Node current = first;
        int max = Integer.MIN_VALUE;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        System.out.println("Nilai Terbesar adalah " + max); 
    }
    public void min() {                         // Mencari Nilai Min Dalam Node
        Node current = first;
        int min = Integer.MAX_VALUE;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        System.out.println("Nilai Terkecil adalah " + min); 
    }
    private void sort() {   
        Node current = first;
        for (int i = 0; i < count(); i++) {
            while (current != last) {
                if(current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
            current = first;
        }
    }
    public void sortToMax() {                   // Mengurutkan dari Terkecil ke Terbesar
        sort();
        printForward();
    }
    public void sortToMin() {                   // Mengurutkan dari Terbesar ke Terkecil 
        sort();
        printBackward();
    }
    public void printForward() {                // Cetak Dari Depan
        Node current = first;
        while (current != null) {
            current.show();
            current = current.next;
        }
        System.out.println(); 
    }
    public void printBackward() {               // Cetak Dari Belakang
        Node current = last;
        while (current != null) {
            current.show();
            current = current.prev;
        }
        System.out.println();
    }
}
