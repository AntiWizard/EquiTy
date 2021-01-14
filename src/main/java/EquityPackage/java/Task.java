package EquityPackage.java;

import java.util.ArrayList;

public class Task {

    public static void main(String[] args) {
        ArrayList<Double> costList = Users.costList(Users.inputNumber());
        System.out.println("List of cost: " + costList);
        System.out.println("Transactions: " + Orders.indexTotalOrder(costList));
        System.out.println("Purchased transactions: " + Orders.indexBuyOrders(Orders.indexTotalOrder(costList)));
        System.out.println("Sold transactions: " + Orders.indexSellOrders(Orders.indexTotalOrder(costList)));
        System.out.println("Total List of EquityPackage.java.Profit: " + Profit.listTotalProfit(costList,
                Orders.indexSellOrders(Orders.indexTotalOrder(costList)), Orders.indexBuyOrders(Orders.indexTotalOrder(costList))));
        System.out.println("Summation of profit: " +
                Profit.sumProfit(Profit.listTotalProfit
                        (costList, Orders.indexSellOrders(Orders.indexTotalOrder(costList)), Orders.indexBuyOrders(Orders.indexTotalOrder(costList)))));
        System.out.println("returnJson: " + Profit.returnJson(Orders.indexBuyOrders(Orders.indexTotalOrder(costList)) ,
                Orders.indexSellOrders(Orders.indexTotalOrder(costList)) , Profit.listTotalProfit(costList,
                Orders.indexSellOrders(Orders.indexTotalOrder(costList)), Orders.indexBuyOrders(Orders.indexTotalOrder(costList))),
                Profit.sumProfit(Profit.listTotalProfit
                        (costList, Orders.indexSellOrders(Orders.indexTotalOrder(costList)), Orders.indexBuyOrders(Orders.indexTotalOrder(costList))))));

        Profit.createXmlFile(Orders.indexBuyOrders(Orders.indexTotalOrder(costList)) ,
                Orders.indexSellOrders(Orders.indexTotalOrder(costList)) , Profit.listTotalProfit(costList,
                        Orders.indexSellOrders(Orders.indexTotalOrder(costList)), Orders.indexBuyOrders(Orders.indexTotalOrder(costList))));
    }
}


