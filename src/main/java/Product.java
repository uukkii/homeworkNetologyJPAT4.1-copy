public class Product {
    private final String id;
    private final String type;
    private final String name;
    private final int cost;
    private final String spec;
    private final int rating;

    public Product(String id, String type, String name, int cost, String spec, int rating) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.spec = spec;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getSpecifications() {
        return spec;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return " - " + type + " " + name + " (" + spec + "), " + cost + " руб. " + "[Код: " + id + "]";
    }
}