package edu.hw3.task6;

public final class Stock {
    private final String companyName;
    private final int companyPrice;

    public Stock(final String company, final int price) {
        this.companyName = company;
        this.companyPrice = price;
    }

    public int getPrice() {
        return companyPrice;
    }
}
