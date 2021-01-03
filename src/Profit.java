import java.util.ArrayList;

public class Profit extends Orders {
    final double wage = 0.2d;

    public static ArrayList<Double> listTotalProfit(ArrayList<Double> costList , ArrayList<Integer> indexSellOrders ,
                                                    ArrayList<Integer> indexBuyOrders){
        Profit wageProfit = new Profit();
        ArrayList<Double> profit = new ArrayList<>();
        for (int i = 0; i < indexBuyOrders.size(); i++) {
            profit.add(costList.get(indexSellOrders.get(i)) - costList.get(indexSellOrders.get(i)) * wageProfit.wage
                    - costList.get(indexBuyOrders.get(i)));
        }
        return profit;
    }
    public static Double sumProfit(ArrayList<Double> listTotalProfit){
        double result = 0d;
        for (Double item : listTotalProfit){
            result += item;
        }
        return result;
    }
}

