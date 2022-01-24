import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<String, Integer> basket;

    public Basket() {
        basket = new HashMap<>();
    }

    public Map<String, Integer> getBasket() {
        return basket;
    }

    public void putProductToBasket(String id, int quantity) {
        basket.put(id, quantity);
    }

    public void print(Products products) {
        int totalValue = 0;
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            Product product = products.getProductsBase().get(entry.getKey());
            int value = entry.getValue() * product.getCost();
            System.out.println(product + ", " + entry.getValue() + "шт., " + "\nСтоимость: " + value + " руб.");
            totalValue += value;
        }
        System.out.println("Общая стоимость: " + totalValue + " руб.\n");
    }

    public void basketRemove(String inputDel) {
        basket.remove(inputDel);
    }
}