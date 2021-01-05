import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Task extends Profit {

    public static void main(String[] args) {
        ArrayList costList = costList(inputNumber());
        System.out.println("List of cost: " + costList);
        System.out.println("Transactions: " + indexTotalOrder(costList));
        System.out.println("Purchased transactions: " + indexBuyOrders(indexTotalOrder(costList)));
        System.out.println("Sold transactions: " + indexSellOrders(indexTotalOrder(costList)));
        System.out.println("Total List of Profit: " + listTotalProfit(costList,
                indexSellOrders(indexTotalOrder(costList)),indexBuyOrders(indexTotalOrder(costList))));
        System.out.println("Summation of profit: " +
                sumProfit(listTotalProfit
                        (costList, indexSellOrders(indexTotalOrder(costList)),indexBuyOrders(indexTotalOrder(costList)))));
        System.out.println("returnJson: " + returnJson(indexBuyOrders(indexTotalOrder(costList)) ,
                indexSellOrders(indexTotalOrder(costList)) ,listTotalProfit(costList,
                indexSellOrders(indexTotalOrder(costList)),indexBuyOrders(indexTotalOrder(costList))),
                sumProfit(listTotalProfit
                        (costList, indexSellOrders(indexTotalOrder(costList)),indexBuyOrders(indexTotalOrder(costList))))));

        createXmlFile(indexBuyOrders(indexTotalOrder(costList)) ,
                indexSellOrders(indexTotalOrder(costList)) ,listTotalProfit(costList,
                        indexSellOrders(indexTotalOrder(costList)),indexBuyOrders(indexTotalOrder(costList))));
    }
}


