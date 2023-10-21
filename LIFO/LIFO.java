package LIFO;

import DLL.DLL;
import DLL.DLLNode;
import DLL.DLLcar;

public class LIFO {
    DLL lifo = new DLL();

    public void PrintAll() {
        lifo.PrintAll();
    }

    public void PrintCar(DLLNode temp) {
        lifo.PrintCar(temp);
    }

    public DLLNode Search(int ID) {
        return lifo.Search(ID);
    }

    public void Push(DLLcar data) {
        lifo.AppendToTail(data);
    }

    public DLLNode Pop() {
        DLLNode temp = lifo.tail;
        lifo.RemoveFromTail();
        return temp;
    }
}
