import java.util.*;

public class Rating {
    protected final int MAX_RATING = 5; // Не допускаем появления магического числа.
    private final Map<String, Product> rating;

    public Rating(Products products) {
        rating = products.getProductsBase();
    }

    public Map<String, Product> getRating() {
        return rating;
    }

    public void print() {
        List<Product> productList = new ArrayList<>(rating.values());
        productList.sort(Comparator.comparing(Product::getRating));
        Collections.reverse(productList);
        for (Product product : productList) {
            System.out.println(product.getRating() + "/" + MAX_RATING + " " + product); // Magic
        }
    }
}
