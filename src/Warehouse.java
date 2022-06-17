import java.util.ArrayList;

public class Warehouse {
    private int volume = 50;
    private ArrayList<Product> products;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String toString() {
        return "Склад " +
                " \nМесто на складе = " + getVolume() +
                "\n"+ getProducts() + "\n";
    }
}