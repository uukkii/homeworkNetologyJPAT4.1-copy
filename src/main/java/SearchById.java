import java.util.Map;

public class SearchById implements SearchByFirstArgument { // Interface segregation principle.
    private final Map<String, Product> productsBase;

    public SearchById(Map<String, Product> productsBase) {
        this.productsBase = productsBase;
    }

    @Override
    public void filterByFirst(String id) {
        System.out.println("Найденный товар: " + productsBase.get(id));
    }
}
