package Drivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import HEAP.HEAPcar;
import HEAP.HEAP;

public class DealerHEAP {
    public static void main(String args[]) {
        HEAP minHeap = new HEAP(100);

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

                HEAPcar car = new HEAPcar(ID, make, model, year, mileage, price);
                minHeap.Insert(car);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Welcome to the car dealership!");
        System.out.println("Please select an option:");
        System.out.println("1. Extract min, 2. Insert, 3. Print heap, 4. Exit");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        while (option == 1 || option == 2 || option == 3) {
            if (option == 1) {
                HEAPcar temp = minHeap.ExtractMin();
                if (temp == null) {
                    System.out.println("Heap is empty. Cannot extract.");
                } else {
                    System.out.println(temp);
                }
            }

            if (option == 2) {
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

            if (option == 3) {
                minHeap.PrintMinHeap();
            }

            System.out.println();
            System.out.println("Please select an option:");
            System.out.println("1. Extract min, 2. Insert, 3. Print heap, 4. Exit");
            option = sc.nextInt();
        }

        sc.close();
    }
}
