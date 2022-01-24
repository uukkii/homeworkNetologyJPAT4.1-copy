import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchByNameAndSpec implements SearchByFirstArgument, SearchBySecondArgument { // Interface segregation principle.

    private final Map<String, Product> productsBase;
    private final List<Product> productList = new ArrayList<>();

    public SearchByNameAndSpec(Map<String, Product> productsBase) {
        this.productsBase = productsBase;
    }

    @Override
    public void filterByFirst(String type) {
        for (Map.Entry<String, Product> entry : productsBase.entrySet()) {
            if (type.equals(entry.getValue().getType())) {
                productList.add(entry.getValue());
            }
        }
    }

    @Override
    public void filterBySecond(String spec) {
        for (Product product : productList) {
            if (spec.equals(product.getSpecifications())) {
                System.out.println("Найденный товар: " + product);
            }
        }
    }

    public Map<String, Product> getProductsBase() {
        return productsBase;
    }
}
