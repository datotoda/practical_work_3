package task1;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable, Comparable {
    public Integer productId;
    public String name;
    public String category;
    public Double price;
    public Integer quantity;
    public List<String> listOfComments;

    public Product(String name, String category, Double price, Integer quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", listOfComments=" + listOfComments +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product p = (Product) o;

        int compare = this.name.compareTo(p.name);
        if (compare == 0) {
            compare = this.category.compareTo(p.category);
        }
        if (compare == 0) {
            compare = this.price.compareTo(p.price);
        }
        if (compare == 0) {
            compare = this.productId.compareTo(p.productId);
        }

        return compare;
    }
}
