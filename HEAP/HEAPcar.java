package HEAP;

public class HEAPcar {
    public int ID;
    public String make;
    public String model;
    public int year;
    public int mileage;
    public int price;

    public HEAPcar(int ID, String make, String model, int year, int mileage, int price) {
        this.ID = ID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public HEAPcar(HEAPcar data) {
        this.ID = data.ID;
        this.make = data.make;
        this.model = data.model;
        this.year = data.year;
        this.mileage = data.mileage;
        this.price = data.price;
    }

    public double getPrice() {
        return price;
    }

    // Implement comparison based on car price
    public int compareTo(HEAPcar other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return ID + " " + make + " " + model + " (" + year + ") " + mileage + " mi - $" + price;
    }
}
