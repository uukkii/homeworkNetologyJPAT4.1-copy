import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private String time;
    private final List<Map<Product, Integer>> listOrders;

    public Order() {
        listOrders = new ArrayList<>();
    }

    public List<Map<Product, Integer>> getOrders() {
        return listOrders;
    }

    public void listOrders(Map<String, Integer> order, Products products) {
        Map<Product, Integer> orderInList = new HashMap<>();
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            Product product = products.getProductsBase().get(entry.getKey());
            orderInList.put(product, entry.getValue());
        }
        listOrders.add(orderInList);
        time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss"));
    }

    public void print() {
        for (Map<Product, Integer> map : listOrders) {
            int totalValue = 0;
            System.out.println("Заказ от " + time + " = ");
            for (Map.Entry<Product, Integer> entry : map.entrySet()) {
                int value = entry.getValue() * entry.getKey().getCost();
                System.out.println(entry.getKey() + ", " + entry.getValue() + "шт. " + "\nСтоимость: " + value + " руб.");
                totalValue += value;
            }
            System.out.println("Общая стоимость: " + totalValue + " руб.\n");
        }
    }
}