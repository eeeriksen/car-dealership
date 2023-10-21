package DLL;

public class DLLcar {
    public int ID;
    public String make;
    public String model;
    public int year;
    public int mileage;
    public int price;

    public DLLcar(int ID, String make, String model, int year, int mileage, int price) {
        this.ID = ID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public DLLcar(DLLcar data) {
        this.ID = data.ID;
        this.make = data.make;
        this.model = data.model;
        this.year = data.year;
        this.mileage = data.mileage;
        this.price = data.price;
    }
}
