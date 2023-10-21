package DLL;

public class DLLNode {
    public DLLcar data;
    public DLLNode next;
    public DLLNode prev;

    public DLLNode(DLLcar data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DLLNode(DLLcar data, DLLNode next, DLLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}