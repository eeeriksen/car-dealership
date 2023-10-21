package HEAP;

public class HEAP {
    private HEAPcar[] heap;
    private int size;
    private int capacity;

    public HEAP(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new HEAPcar[capacity];
    }

    private int Parent(int index) {
        return (index - 1) / 2;
    }

    private int LeftChild(int index) {
        return 2 * index + 1;
    }

    private int RightChild(int index) {
        return 2 * index + 2;
    }

    private void Swap(int i, int j) {
        HEAPcar temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void Insert(HEAPcar car) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        size++;
        int current = size - 1;
        heap[current] = car;

        while (current != 0 && heap[current].compareTo(heap[Parent(current)]) < 0) {
            Swap(current, Parent(current));
            current = Parent(current);
        }
    }

    public HEAPcar ExtractMin() {
        if (size <= 0) {
            return null;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        HEAPcar root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        MinHeapify(0);

        return root;
    }

    private void MinHeapify(int index) {
        int left = LeftChild(index);
        int right = RightChild(index);
        int smallest = index;

        if (left < size && heap[left].compareTo(heap[smallest]) < 0) {
            smallest = left;
        }
        if (right < size && heap[right].compareTo(heap[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            Swap(index, smallest);
            MinHeapify(smallest);
        }
    }

    public void PrintMinHeap() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }
}
