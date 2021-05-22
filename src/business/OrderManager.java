package business;

import dataAccess.OrderDataAccess;
import dataAccess.OrderDBAccess;
import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import model.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrderManager {
    private OrderDataAccess dao;

    public OrderManager() throws ConnectionException {
        setDao(new OrderDBAccess());
    }

    public void setDao(OrderDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<OrderByCustomer> getAllOrders()throws SelectQueryException {
        ArrayList<OrderByCustomer> orderArrayList = dao.getAllOrders();
        return orderArrayList;
    }

    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException, NullException {
        if (customerId < 0 || startDate == null || endDate == null){
            throw new NullException("Customer id or date are null were they shouldn't be" );
        }
        ArrayList<OrderByCustomer> orderByCustomer = dao.getOrdersByCustomer(customerId, startDate, endDate);
        return orderByCustomer;

    }

    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId) throws SelectQueryException, NullException {
        if (customerId < 0){
            throw new NullException("Customer id is null were it shouldn't be" );
        }
        ArrayList<OrderByCustomer> orderByCustomers = dao.getOrdersByCustomer(customerId);
        return orderByCustomers;
    }

    public ArrayList<OrderBusinessTask> getAllOrderBusinessTask () throws SelectQueryException {
        ArrayList<OrderBusinessTask> orderBusinessTasks = dao.getAllOrderBusinessTask();
        return orderBusinessTasks;
    }

    public StatisticsModel getStatsFromAllSales (ArrayList<OrderBusinessTask> orders, int reference) {
        double max = 0;
        double profit = 0;
        double averageOrdersPrices = 0;
        int totalProductCount = 0;
        int referencedProductCount = 0;
        double referencedProductTotalPrice = 0;
        double percentageRepresentativeness;

        for(OrderBusinessTask o : orders){
            double totalPrice = 0;
            double currentPrice;

            for(OrderLineBusinessTask ol : o.getOrdersLines()){
                currentPrice = ol.getPriceSold() * ol.getQuantity();
                if(ol.getProductReference() == reference){
                    referencedProductCount += ol.getQuantity();
                    referencedProductTotalPrice += currentPrice;
                }
                totalProductCount += ol.getQuantity();
                totalPrice += currentPrice;

                if(ol.getHasDiscount()){
                    totalPrice -= totalPrice * ol.getPercentageDiscount();
                }
            }
            profit += totalPrice;
            if(max < totalPrice){
                max = totalPrice;
            }
        }
        if(orders.size() != 0){
            averageOrdersPrices = profit / orders.size();
        }
        percentageRepresentativeness = referencedProductCount / totalProductCount * 100;

        return new StatisticsModel(max, profit, averageOrdersPrices, totalProductCount, referencedProductCount, referencedProductTotalPrice, percentageRepresentativeness);
    }
}
