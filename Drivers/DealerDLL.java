package Drivers;

import java.util.Scanner;

import DLL.DLL;
import DLL.DLLNode;
import DLL.DLLcar;

import java.io.File;
import java.io.FileNotFoundException;

public class DealerDLL {
    public static void main(String args[]) {
        DLL dll = new DLL();

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

                DLLcar car = new DLLcar(ID, make, model, year, mileage, price);
                dll.AppendToHead(car);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Welcome to the car dealership!");
        System.out.println("Please select an option:");
        System.out.println("1. Search, 2. Delete, 3. Append to Head, 4. Append to Tail, 5. Print All, 6. Exit");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            if (option == 1) {
                System.out.println("Please enter the ID of the car you want to search for:");
                int ID = sc.nextInt();
                DLLNode temp = dll.Search(ID);

                if (temp == null) {
                    System.out.println("No such an item");
                } else {
                    dll.PrintCar(temp);
                }
            }

            if (option == 2) {
                System.out.println("Please enter the ID of the car you want to delete:");
                int ID = sc.nextInt();
                dll.Delete(ID);
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

                DLLcar car = new DLLcar(ID, make, model, year, mileage, price);
                dll.AppendToHead(car);
            }

            if (option == 4) {
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

            if (option == 5) {
                dll.PrintAll();
            }

            System.out.println();
            System.out.println("Please select an option:");
            System.out.println("1. Search, 2. Delete, 3. Append to Head, 4. Append to Tail, 5. Print All, 6. Exit");
            option = sc.nextInt();
        }

        sc.close();
    }
}
