package model;

public class StatisticsModel {
    private double max;
    private double profit;
    private double averageOrdersPrices;
    private int totalProductCount;
    private int referencedProductCount;
    private double referencedProductTotalPrice;
    private double percentageRepresentativeness;

    public StatisticsModel(double max, double profit, double averageOrdersPrices, int totalProductCount, int referencedProductCount, double referencedProductTotalPrice, double percentageRepresentativeness) {
        this.max = max;
        this.profit = profit;
        this.averageOrdersPrices = averageOrdersPrices;
        this.totalProductCount = totalProductCount;
        this.referencedProductCount = referencedProductCount;
        this.referencedProductTotalPrice = referencedProductTotalPrice;
        this.percentageRepresentativeness = percentageRepresentativeness;
    }

    public double getMax() {
        return max;
    }

    public double getProfit() {
        return profit;
    }

    public double getAverageOrdersPrices() {
        return averageOrdersPrices;
    }

    public double getReferencedProductTotalPrice() {
        return referencedProductTotalPrice;
    }

    public double getPercentageRepresentativeness() {
        return percentageRepresentativeness;
    }
}
