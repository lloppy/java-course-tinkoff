package edu.hw3.task6;

import java.util.Queue;

public interface StockMarket {
    /**
     * Добавить акцию.
     *
     * @param stock Акция, которую нужно добавить.
     */
    void add(Stock stock);

    /**
     * Удалить акцию.
     *
     * @param stock Акция, которую нужно удалить.
     */
    void remove(Stock stock);

    /**
     * Получить информацию о самой дорогой акции.
     *
     * @return Самая дорогая акция.
     */
    Stock mostValuableStock();

    /**
     * Получить список всех акций на рынке.
     *
     * @return Все акции.
     */
    Queue<Stock> getStocks();
}
