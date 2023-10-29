package edu.hw3.task6;

import java.util.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StockTest {

    @Test
    void testThatAddIncreasesStockCount() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Apple", 100));
        stockMarket.add(new Stock("Google", 200));
        stockMarket.add(new Stock("Microsoft", 200));

        Queue<Stock> allStocks = stockMarket.getStocks();
        assertEquals(3, allStocks.size());
    }

    @Test
    void testThatRemoveDecreasesStockCount() {
        StockMarket stockMarket = new StockMarketImpl();
        Stock appleCompany = new Stock("Apple", 100);

        stockMarket.add(new Stock("Google", 200));
        stockMarket.add(appleCompany);
        stockMarket.remove(appleCompany);

        Queue<Stock> allStocks = stockMarket.getStocks();
        assertEquals(1, allStocks.size());
    }

    @Test
    void testThatMostValuableStockReturnsTheMostValuable() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Netflix", 150));
        stockMarket.add(new Stock("Apple", 100));
        stockMarket.add(new Stock("Google", 200));
        assertEquals(
            new Stock("Google", 200).getPrice(),
            stockMarket.mostValuableStock().getPrice()
        );
    }

    @Test
    void testThatMostValuableStockReturnsNullWhenThereIsNoStock() {
        StockMarket stockMarket = new StockMarketImpl();
        assertNull(stockMarket.mostValuableStock());
    }

    @Test
    void testThatMostValuableStockGetsReturnedTheBiggerValue() {
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Apple", 100));
        stockMarket.add(new Stock("Apple", 150));
        stockMarket.add(new Stock("Microsoft", 100));
        assertEquals(
            new Stock("Apple", 150).getPrice(),
            stockMarket.mostValuableStock().getPrice()
        );
    }

}
