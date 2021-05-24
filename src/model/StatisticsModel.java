package model;

import java.text.DecimalFormat;

public class StatisticsModel {
    private double max;
    private double profit;
    private double averageOrdersPrices;
    private int totalProductCount;
    private int referencedProductCount;
    private double referencedProductTotalPrice;

    public StatisticsModel(double max, double profit, double averageOrdersPrices, int totalProductCount, int referencedProductCount, double referencedProductTotalPrice) {
        this.max = max;
        this.profit = profit;
        this.averageOrdersPrices = averageOrdersPrices;
        this.totalProductCount = totalProductCount;
        this.referencedProductCount = referencedProductCount;
        this.referencedProductTotalPrice = referencedProductTotalPrice;
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

    public double getPercentageRepresentativeness(){
        if(totalProductCount > 0){
            return ((double)referencedProductCount / totalProductCount) * 100;
        }
        return 0;
    }

}
