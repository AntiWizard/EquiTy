import EquityPackage.java.Orders;
import EquityPackage.java.Profit;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestOfTest {

    @Test
    void showAssertionOfTest1() {
        ArrayList<String> exceptedNumbers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        exceptedNumbers.add("12");
        exceptedNumbers.add("1");
        exceptedNumbers.add("-1");
        exceptedNumbers.add("1242");
        exceptedNumbers.add("aa");
        exceptedNumbers.add("true");
        exceptedNumbers.add(" ");
        exceptedNumbers.add("78");
        exceptedNumbers.add("8");
        result.add(2);
        result.add(1);
        result.add(1);
        result.add(4);
        result.add(2);
        result.add(1);

    }

    @Test
    void showIndexStartCostOrders() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        int result;
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(1.1);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result = 1;
        System.out.println( exceptedNumbers);
        assertEquals(result , Orders.indexStartCost(exceptedNumbers,0));
    }
    @Test
    void showIndexEfficientCostOrders() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        int result;
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(1.1);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result = 3;
        assertEquals(result , Orders.indexEfficientCost(exceptedNumbers,Orders.indexStartCost(exceptedNumbers,0)));
    }
    @Test
    void showIndexTotalOrder() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(1.1);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        tmp.add(1);
        tmp.add(3);
        result.add(tmp);
        assertArrayEquals(result.toArray() , Orders.indexTotalOrder(exceptedNumbers).toArray());
    }
    @Test
    void showIndexSellOrders() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(1.1);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result.add(3);
        assertArrayEquals(result.toArray() , Orders.indexSellOrders(Orders.indexTotalOrder(exceptedNumbers)).toArray());
    }

    @Test
    void showIndexBuyOrders() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(1.1);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result.add(1);
        assertArrayEquals(result.toArray() , Orders.indexBuyOrders(Orders.indexTotalOrder(exceptedNumbers)).toArray());
    }

    @Test
    void showIndexStartToEfficient() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(1.1);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result.add(1);
        result.add(3);
        assertArrayEquals(result.toArray() , Orders.indexStartToEfficient
                (Orders.indexStartCost(exceptedNumbers,0),Orders.indexEfficientCost
                        (exceptedNumbers,Orders.indexStartCost(exceptedNumbers,0))).toArray());
    }
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Test
    void showListTotalProfit() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        ArrayList<Double> result = new ArrayList<>();
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(10.0);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result.add(Double.parseDouble(df2.format(exceptedNumbers.get(3) - exceptedNumbers.get(3)*0.2 - exceptedNumbers.get(1))));
        assertArrayEquals(result.toArray() , Profit.listTotalProfit(exceptedNumbers,
                Orders.indexSellOrders(Orders.indexTotalOrder(exceptedNumbers)),
                Orders.indexBuyOrders(Orders.indexTotalOrder(exceptedNumbers)))
                .toArray());
    }
    @Test
    void showSumProfit() {
        ArrayList<Double> exceptedNumbers = new ArrayList<>();
        Double result ;
        exceptedNumbers.add(12.0);
        exceptedNumbers.add(10.0);
        exceptedNumbers.add(1242.3);
        exceptedNumbers.add(231312312.123);
        exceptedNumbers.add(78.1243);
        exceptedNumbers.add(8.25);
        result = Double.parseDouble(df2.format(exceptedNumbers.get(3) - exceptedNumbers.get(3)*0.2 - exceptedNumbers.get(1)));
        assertEquals(result , Profit.sumProfit(Profit.listTotalProfit(
                exceptedNumbers,Orders.indexSellOrders(Orders.indexTotalOrder(exceptedNumbers)),
                Orders.indexBuyOrders(Orders.indexTotalOrder(exceptedNumbers)))));
    }
}
