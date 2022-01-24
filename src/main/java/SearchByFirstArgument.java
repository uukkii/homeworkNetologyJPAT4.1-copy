public interface SearchByFirstArgument { // Interface segregation principle. Созданы два интерфейса для упрощения поиска продуктов:
                                         // по одному параметру и по дополнительному параметку (SearchBySecondArgument)
    void filterByFirst(String argument);
}