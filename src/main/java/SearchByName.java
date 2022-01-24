import java.util.Map;

public class SearchByName implements SearchByFirstArgument { // Interface segregation principle.
    private final Map<String, Product> productsBase;

    public SearchByName(Map<String, Product> productsBase) {
        this.productsBase = productsBase;
    }


    @Override
    public void filterByFirst(String name) {
        for (Map.Entry<String, Product> entry : productsBase.entrySet()) {
            if (entry.getValue()
                    .getName()
                    .equals(name)) {
                System.out.println("Найденный товар:" + entry.getValue());
            }
        }
    }

    public Map<String, Product> getProductsBase() {
        return productsBase;
    }
}
