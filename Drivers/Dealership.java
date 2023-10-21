package Drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import BST.BST;
import BST.BSTNode;
import BST.BSTcar;
import DLL.DLL;
import DLL.DLLNode;
import DLL.DLLcar;
import HEAP.HEAP;
import HEAP.HEAPcar;
import LIFO.LIFO;

public class Dealership {
    public static void main(String args[]) {
        DLL dll = new DLL();
        LIFO lifo = new LIFO();
        HEAP minHeap = new HEAP(100);
        BST bst = new BST();

        try {
            File file = new File("./resources/cars.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String idString = sc.nextLine();
                if (idString.isEmpty()) {
                    continue; // Skip empty lines
                }
                int ID = Integer.parseInt(idString);
                String make = sc.nextLine();
                String model = sc.nextLine();
                int year = Integer.parseInt(sc.nextLine());
                int mileage = Integer.parseInt(sc.nextLine());
                int price = Integer.parseInt(sc.nextLine());

                DLLcar ddlcar = new DLLcar(ID, make, model, year, mileage, price);
                BSTcar bstcar = new BSTcar(ID, make, model, year, mileage, price);
                HEAPcar heapcar = new HEAPcar(ID, make, model, year, mileage, price);

                dll.AppendToHead(ddlcar);
                bst.Insert(bstcar);
                minHeap.Insert(heapcar);
                lifo.Push(ddlcar);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Welcome to the car dealership!");
        System.out.println("Please, select the Data Structure you would like to use:");
        System.out.println("1. Double Linked List, 2. Binary Searh Tree, 3. LIFO Queue, 4. Min Heap, 5. Exit");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option == 1 || option == 2 || option == 3 || option == 4) {
            if (option == 1) {
                System.out.println("=======================================");
                usingDLL(dll, sc);
            }

            if (option == 2) {
                System.out.println("=======================================");
                usingBST(bst, sc);
            }

            if (option == 3) {
                System.out.println("=======================================");
                usingLIFO(lifo, sc);
            }

            if (option == 4) {
                System.out.println("=======================================");
                usingHEAP(minHeap, sc);
            }

            System.out.println();
            System.out.println("Please, select the Data Structure you would like to use:");
            System.out.println("1. Double Linked List, 2. Binary Searh Tree, 3. LIFO Queue, 4. Min Heap, 5. Exit");
            option = sc.nextInt();
        }
    }

    // ------------- HEAP ------------ //
    public static void usingHEAP(HEAP minHeap, Scanner sc) {
        System.out.println("You are using a Min Heap");
        System.out.println("Please select an option:");
        System.out.println("1. Extract min, 2. Insert, 3. Print heap, 4. Back to main menu");

        int optionHeap = sc.nextInt();

        while (optionHeap == 1 || optionHeap == 2 || optionHeap == 3) {
            if (optionHeap == 1) {
                HEAPcar temp = minHeap.ExtractMin();
                if (temp == null) {
                    System.out.println("Heap is empty. Cannot extract.");
                } else {
                    System.out.println(temp);
                }
            }

            if (optionHeap == 2) {
                System.out.println("Please enter the ID of the car you want to append to head:");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter the make:");
                String make = sc.nextLine();
                System.out.println("Please enter the model:");
                String model = sc.nextLine();
                System.out.println("Please enter the year:");
                int year = sc.nextInt();
                System.out.println("Please enter the mileage:");
                int mileage = sc.nextInt();
                System.out.println("Please enter the price:");
                int price = sc.nextInt();

                HEAPcar car = new HEAPcar(ID, make, model, year, mileage, price);
                minHeap.Insert(car);
            }

            if (optionHeap == 3) {
                minHeap.PrintMinHeap();
            }

            System.out.println();
            System.out.println("You are using a Min Heap");
            System.out.println("Please select an option:");
            System.out.println("1. Extract min, 2. Insert, 3. Print heap, 4. Back to main menu");
            optionHeap = sc.nextInt();
        }
    }

    // ------------- LIFO ------------ //
    public static void usingLIFO(LIFO lifo, Scanner sc) {
        System.out.println("You are using a LIFO Queue");
        System.out.println("Please select an option:");
        System.out.println("1. Push, 2. Pop, 3. Back to main menu");

        int optionLIFO = sc.nextInt();

        while (optionLIFO == 1 || optionLIFO == 2) {
            if (optionLIFO == 1) {
                System.out.println("Please enter the ID of the car you want to push:");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter the make:");
                String make = sc.nextLine();
                System.out.println("Please enter the model:");
                String model = sc.nextLine();
                System.out.println("Please enter the year:");
                int year = sc.nextInt();
                System.out.println("Please enter the mileage:");
                int mileage = sc.nextInt();
                System.out.println("Please enter the price:");
                int price = sc.nextInt();

                DLLcar car = new DLLcar(ID, make, model, year, mileage, price);
                lifo.Push(car);
            }

            if (optionLIFO == 2) {
                DLLNode temp = lifo.Pop();
                if (temp != null) {
                    System.out.println("Deleted car:");
                    lifo.PrintCar(temp);
                }
            }

            System.out.println();
            System.out.println("You are using a LIFO Queue");
            System.out.println("Please select an option:");
            System.out.println("1. Push, 2. Pop, 3. Back to main menu");
            optionLIFO = sc.nextInt();
        }
    }

    // ------------- BST ------------- //
    public static void usingBST(BST bst, Scanner sc) {
        System.out.println("You are using a Binary Searh Tree");
        System.out.println("Please select an option:");
        System.out.println(
                "1. Search, 2. Delete, 3. Insert, 4. InOrder, 5. PreOrder, 6. PostOrder, 7. Back to main menu");

        int option = sc.nextInt();

        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6) {
            if (option == 1) {
                System.out.println("Please enter the ID of the car you want to search for:");
                int ID = sc.nextInt();
                BSTNode temp = bst.Search(ID);

                if (temp == null) {
                    System.out.println("No such an item");
                } else {
                    bst.PrintCar(temp);
                }
            }

            if (option == 2) {
                System.out.println("Please enter the ID of the car you want to delete:");
                int ID = sc.nextInt();
                bst.Delete(ID);
            }

            if (option == 3) {
                System.out.println("Please enter the ID of the car you want to append to head:");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter the make:");
                String make = sc.nextLine();
                System.out.println("Please enter the model:");
                String model = sc.nextLine();
                System.out.println("Please enter the year:");
                int year = sc.nextInt();
                System.out.println("Please enter the mileage:");
                int mileage = sc.nextInt();
                System.out.println("Please enter the price:");
                int price = sc.nextInt();

                BSTcar car = new BSTcar(ID, make, model, year, mileage, price);
                bst.Insert(car);
            }

            if (option == 4) {
                bst.InOrder(bst.root);
            }

            if (option == 5) {
                bst.PreOrder(bst.root);
            }

            if (option == 6) {
                bst.PostOrder(bst.root);
            }

            System.out.println();
            System.out.println("Please select an option:");
            System.out.println(
                    "1. Search, 2. Delete, 3. Insert, 4. InOrder, 5. PreOrder, 6. PostOrder, 7. Back to main menu");
            option = sc.nextInt();
        }
    }

    // ------------- DLL ------------- //
    public static void usingDLL(DLL dll, Scanner sc) {
        System.out.println("You are using a Doubly Linked List");
        System.out.println("Please select an option:");
        System.out.println(
                "1. Search, 2. Delete, 3. Append to Head, 4. Append to Tail, 5. Print All, 6. Back to main menu");

        int optionDLL = sc.nextInt();

        while (optionDLL == 1 || optionDLL == 2 || optionDLL == 3 || optionDLL == 4 || optionDLL == 5) {
            if (optionDLL == 1) {
                System.out.println("Please enter the ID of the car you want to search for:");
                int ID = sc.nextInt();
                DLLNode temp = dll.Search(ID);

                if (temp == null) {
                    System.out.println("No such an item");
                } else {
                    dll.PrintCar(temp);
                }
            }

            if (optionDLL == 2) {
                System.out.println("Please enter the ID of the car you want to delete:");
                int ID = sc.nextInt();
                dll.Delete(ID);
            }

            if (optionDLL == 3) {
                System.out.println("Please enter the ID of the car you want to append to head:");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter the make:");
                String make = sc.nextLine();
                System.out.println("Please enter the model:");
                String model = sc.nextLine();
                System.out.println("Please enter the year:");
                int year = sc.nextInt();
                System.out.println("Please enter the mileage:");
                int mileage = sc.nextInt();
                System.out.println("Please enter the price:");
                int price = sc.nextInt();

                DLLcar car = new DLLcar(ID, make, model, year, mileage, price);
                dll.AppendToHead(car);
            }

            if (optionDLL == 4) {
                System.out.println("Please enter the ID of the car you want to append to tail:");
                int ID = sc.nextInt();
                sc.nextLine();
                System.out.println("Please enter the make:");
                String make = sc.nextLine();
                System.out.println("Please enter the model:");
                String model = sc.nextLine();
                System.out.println("Please enter the year:");
                int year = sc.nextInt();
                System.out.println("Please enter the mileage:");
                int mileage = sc.nextInt();
                System.out.println("Please enter the price:");
                int price = sc.nextInt();

                DLLcar car = new DLLcar(ID, make, model, year, mileage, price);
                dll.AppendToTail(car);
            }

            if (optionDLL == 5) {
                dll.PrintAll();
            }

            System.out.println();
            System.out.println("You are using a Doubly Linked List");
            System.out.println("Please select an option:");
            System.out.println(
                    "1. Search, 2. Delete, 3. Append to Head, 4. Append to Tail, 5. Print All, 6. Back to main menu");
            optionDLL = sc.nextInt();
        }
    }
}
