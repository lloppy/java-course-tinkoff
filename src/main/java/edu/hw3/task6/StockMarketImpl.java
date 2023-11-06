package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class StockMarketImpl implements StockMarket {
    private Queue<Stock> stocks = new PriorityQueue<>(
        Comparator.comparing(Stock::getPrice).reversed()
    );

    @Override
    public void add(final Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(final Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }

    @Override
    public Queue<Stock> getStocks() {
        return stocks;
    }
}
