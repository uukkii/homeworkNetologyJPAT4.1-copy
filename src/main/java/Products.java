import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Products {
    private final Map<String, Product> productsBase;

    private final Product product1 = new Product("id000101", "Хлеб", "Городской", 40, "белый", 4);
    private final Product product2 = new Product("id000102", "Хлеб", "Бородинский", 60, "ржаной", 5);
    private final Product product3 = new Product("id000103", "Булочка", "Особая", 35, "с творогом", 4);
    private final Product product4 = new Product("id000104", "Булочка", "Валуевская", 30, "с сахаром", 5);
    private final Product product5 = new Product("id000105", "Слойка", "Сладкая", 40, "с вареньем", 3);
    private final Product product6 = new Product("id000106", "Слойка", "Соленая", 50, "с сыром", 5);

    public Products() {
        productsBase = new HashMap<>();
    }

    public Map<String, Product> getProductsBase() {
        return productsBase;
    }

    public void fill() {
        productsBase.put(product1.getId(), product1);
        productsBase.put(product2.getId(), product2);
        productsBase.put(product3.getId(), product3);
        productsBase.put(product4.getId(), product4);
        productsBase.put(product5.getId(), product5);
        productsBase.put(product6.getId(), product6);
    }

    public void print() {
        TreeMap<String, Product> productTreeMap = new TreeMap<>(productsBase);
        for (Map.Entry<String, Product> entry : productTreeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}