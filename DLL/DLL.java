package DLL;

public class DLL {
    public DLLNode head;
    public DLLNode tail;
    public int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLLNode Search(int ID) {
        DLLNode current = head;

        while (current != null && current.data.ID != ID) {
            current = current.next;
        }

        return current;
    }

    public void Delete(int ID) {
        DLLNode temp = Search(ID);

        if (temp == null) {
            System.out.println("No such an item to delete");
            return;
        }

        if (temp != head && temp != tail) {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        } else if (temp == tail && temp == head) {
            head = null;
            tail = null;
        } else if (temp != head && temp == tail) {
            temp.prev.next = null;
            tail = temp.prev;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Item deleted");
    }

    public void AppendToHead(DLLcar data) {
        DLLNode temp = new DLLNode(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            head.prev = temp;
            temp.next = head;
            head = temp;
        }

        size++;
    }

    public void AppendToTail(DLLcar data) {
        DLLNode temp = new DLLNode(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    public DLLNode RemoveFromHead(int ID) {
        DLLNode temp = head;

        if (temp != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            System.out.println("Empty list");
        }

        return temp;
    }

    public DLLNode RemoveFromTail() {
        DLLNode temp = tail;

        if (temp != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail.next = null;
                tail = tail.prev;
            }
        } else {
            System.out.println("Empty list");
        }

        return temp;
    }

    public void PrintCar(DLLNode car) {
        System.out.println("ID: " + car.data.ID);
        System.out.println("Make: " + car.data.make);
        System.out.println("Model: " + car.data.model);
        System.out.println("Year: " + car.data.year);
        System.out.println("Mileage: " + car.data.mileage);
        System.out.println("Price: " + car.data.price);
    }

    public void PrintAll() {
        DLLNode current = head;

        while (current != null) {
            System.out.println("ID: " + current.data.ID);
            System.out.println("Make: " + current.data.make);
            System.out.println("Model: " + current.data.model);
            System.out.println("Year: " + current.data.year);
            System.out.println("Mileage: " + current.data.mileage);
            System.out.println("Price: " + current.data.price);
            System.out.println();

            current = current.next;
        }
    }
}
