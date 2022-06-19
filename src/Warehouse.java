import java.util.ArrayList;

public class Warehouse {
    private int volume = 50;
    private ArrayList<Product> products;
    ArrayList<Product> products1 = new ArrayList<>();

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
    public void ProductMessage(){
        for (Product product:products1) {
            System.out.println(product.toString());
        }
    }

    public String toString(int count) {
        return "Склад " + count +
                " \nМесто на складе = " + getVolume();
    }
}