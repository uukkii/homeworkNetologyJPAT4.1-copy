import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String goodbye = "Будем рады видеть Вас снова!";
        final String welcome = "Добро пожаловать в ОнлайнБакалею!";

        Scanner console = new Scanner(System.in);
        Products products = new Products();// Single-Responsibility principle. Класс отвечает исключительно за базу данных магазина.
        products.fill();
        Rating rating = new Rating(products);
        Basket basket = new Basket();
        Order order = new Order();


        System.out.println(welcome); // Приветствие убрано в константу.
        while (true) {
            showMainMenu(); // Отображение меню убрано в отдельный метод
            int choice = console.nextInt();
            console.nextLine();
            if (choice == 0) {
                System.out.println(goodbye);
                break;
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("Список товаров:");
                    products.print(); // Liskov substitution principle. Классы Basket, Order, Products и Rating имеют
                                      // свои методы print(). Поскольку классы не являются наследниками, они не связаны
                                      // между собой и не мешают работе с объектами классов.
                    while (true) {
                        showShoppingMenu();
                        String input = console.nextLine();
                        if (input.equals("0"))
                            break;
                        String[] position = input.split(" ");
                        basket.putProductToBasket(position[0], Integer.parseInt(position[1]));
                    }
                }
                case 2 -> {
                    showSearchSubmenu();
                    int input = console.nextInt();
                    console.nextLine();
                    if (input == 0)
                        break;
                    switch (input) {
                        case 1 -> {
                            System.out.println("Введите id товара:");
                            String productId = console.nextLine();
                            new SearchById(products.getProductsBase()).filterByFirst(productId);
                        }

                        case 2 -> {
                            System.out.println("Введите наименование товара");
                            String productName = console.nextLine();
                            new SearchByName(products.getProductsBase()).filterByFirst(productName);
                        }

                        case 3 -> {
                            System.out.println("""
                                    Введите название товара и его спецификацию через пробел:
                                    Пример: 'Слойка с вареньем'.
                                    -----------------------------
                                    """);
                            String userInput = console.nextLine();
                            String[] arrayInput = userInput.split(" ", 2);
                            SearchByNameAndSpec search = new SearchByNameAndSpec(products.getProductsBase());
                            search.filterByFirst(arrayInput[0]);
                            search.filterBySecond(arrayInput[1]);
                        }
                        default -> defaultThrow();
                    }
                }
                case 3 -> {
                    if (basket.getBasket().isEmpty())
                        System.out.println("В корзине пусто!");
                    else {
                        System.out.println("В корзине есть следующие товары: ");
                        basket.print(products); // DRY
                        while (true) {
                            showBasketSubmenu();
                            int input = console.nextInt();
                            console.nextLine();
                            if (input == 0)
                                break;

                            switch (input) {
                                case 1 -> {
                                    while (true) {
                                        basket.print(products);
                                        System.out.println("Для удаления товара введине его Код или введите `0` для выхода в прошлое меню");
                                        String selectedProduct = console.nextLine();
                                        if (selectedProduct.equals("0"))
                                            break;
                                        basket.basketRemove(selectedProduct);
                                    }
                                }

                                case 2 -> {
                                    order.listOrders(basket.getBasket(), products);
                                    System.out.println("Заказ оформлен!");
                                    basket.getBasket().clear();
                                }
                                default -> defaultThrow();
                            }
                        }
                    }
                }

                case 4 -> {
                    System.out.println("Ваши активные заказы:");
                    order.print();
                }

                case 5 -> {
                    System.out.println("Рейтинг товаров ОнлайнБакалеи:");
                    rating.print();
                }

                default -> defaultThrow();
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("""
                Главное меню:
                 1. Начать покупки
                 2. Поиск товара
                 3. Корзина
                 4. Мои заказы
                 5. Рейтинг товаров
                 0. Выход
                 -----------------------------
                """);
    }

    public static void showShoppingMenu() {
        System.out.println("""
                Чтобы положить товар в корзину введите Код товара и его количество через пробел.
                Пример: 'id000101 2'.
                Или введите `0` для выхода в главное меню.
                -----------------------------
                """);
    }

    public static void showSearchSubmenu() {
        System.out.println("""
                Поиск товара:
                 1. Поиск товара по id.
                 2. Поиск по наименованию товара.
                 3. Поиск по типу и названию товара.
                 0. Выход в главное меню.
                 -----------------------------
                 """);
    }

    public static void showBasketSubmenu() {
        System.out.println("""
                Меню корзины:
                 1. Удалить товар из корзины
                 2. Оформить заказ
                 0. Выход
                 -----------------------------
                 """);
    }

    public static void defaultThrow() {
        throw new IllegalStateException("Допустимый диапазон ввода: 0-3"); // DRY
    }
}