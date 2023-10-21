package Drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import DLL.DLLNode;
import DLL.DLLcar;
import LIFO.LIFO;

public class DealerLIFO {
    public static void main(String args[]) {
        LIFO lifo = new LIFO();

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
                lifo.Push(car);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Welcome to the car dealership!");
        System.out.println("Please select an option:");
        System.out.println("1. Push, 2. Pop, 3. Exit");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option == 1 || option == 2) {
            if (option == 1) {
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

            if (option == 2) {
                DLLNode temp = lifo.Pop();
                if (temp != null) {
                    System.out.println("Deleted car:");
                    lifo.PrintCar(temp);
                }
            }

            System.out.println();
            System.out.println("Please select an option:");
            System.out.println("1. Push, 2. Pop, 3. Exit");
            option = sc.nextInt();
        }

        sc.close();
    }
}
