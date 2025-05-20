package task1;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDB implements Serializable {

    HashMap<Integer, Product> productHashMap = new HashMap<>();


    public void addProduct(Product product) {
        int i = 1;
        if (!productHashMap.isEmpty()) {
            i += Collections.max(productHashMap.keySet());
        }
        product.productId = i;
        productHashMap.put(product.productId, product);
    }

    public void removeProductByID(Integer id) {
        productHashMap.remove(id);
    }

    public void removeProductByName(String name) {
        Product product = null;
        for (Product p: productHashMap.values()) {
            if (p.name.equals(name)) {
                product = p;
                break;
            }
        }
        if(product != null){
            this.removeProductByID(product.productId);
        }
    }

    public void printDetails(Integer id) {
        Product product = productHashMap.get(id);
        if(product != null){
            System.out.println(product.toString());
        }
    }

    public void sort(List<Product> products) {
        Collections.sort(products);
        products.forEach(this::addProduct);
    }

    public List<Product> getTop5Products() {
        return productHashMap.values().stream().sorted((p1, p2) -> p2.quantity.compareTo(p1.quantity)).limit(5).collect(Collectors.toList());
    }

    public void productsCountByCategory() {
        Set<String> categories = productHashMap.values().stream().map(product -> product.category ).collect(Collectors.toSet());
        categories.forEach(
                c -> System.out.println(
                        c + ": " + productHashMap.values().stream().filter(product -> product.category.equals(c)).count()
                )
        );
    }

    @Override
    public String toString() {
        String str = "ProductDB{\n\tproductHashMap={\n";
        for (Map.Entry<Integer, Product> productHashMapEntry : productHashMap.entrySet()) {
            str += "\t\t" + productHashMapEntry.getKey() + ": " + productHashMapEntry.getValue() + "\n";
        }
        str += "\t}\n}";

        return str;
    }
}
