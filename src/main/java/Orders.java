import java.util.ArrayList;

public class Orders extends Users{
    final double wage = 0.2d;

    public static int indexStartCost(ArrayList<Double> costList , int index){
        Orders order = new Orders();
        for (int i = index + 1; i < costList.size(); i++){
            if((costList.get(i) - costList.get(i)*order.wage) > costList.get(index)){
                break;
            }
            else {
                index = i;
                indexStartCost(costList , index);
            }

        }
        return index;
    }
    public static int indexEfficientCost(ArrayList<Double> costList , int indexStartCost){
        Orders order = new Orders();
        for(int i = indexStartCost + 1 ; i < costList.size(); i++){
            if((costList.get(i) - costList.get(i)*order.wage) >= costList.get(indexStartCost)){
                indexStartCost = i;
                indexEfficientCost(costList , indexStartCost);
            }
            else break;
        }
        return indexStartCost;
    }
    public static ArrayList<Integer> indexStartToEfficient(int indexStartCost , int indexEfficientCost){
        ArrayList<Integer> indexStartToEfficient = new ArrayList<>();
        indexStartToEfficient.add(indexStartCost);
        indexStartToEfficient.add(indexEfficientCost);
        return indexStartToEfficient;
    }
    public static ArrayList<ArrayList<Integer>> indexTotalOrder(ArrayList<Double> costList){
        int index = 0;
        ArrayList<Integer> lastResult;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        do {
            result.add(indexStartToEfficient(indexStartCost(costList,index),
                    indexEfficientCost(costList,indexStartCost(costList,index))));
            index = indexEfficientCost(costList,  indexStartCost(costList,index)) + 1;
            lastResult = result.get(result.size() - 1 );
        }while (!lastResult.get(0).equals(lastResult.get(1)));
        result.remove(result.get(result.size()-1));

        return result;
    }
    public static ArrayList<Integer> indexSellOrders(ArrayList<ArrayList<Integer>> indexTotalOrder){
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> item : indexTotalOrder) {
            result.add(item.get(1));
        }
        return result;
    }
    public static ArrayList<Integer> indexBuyOrders(ArrayList<ArrayList<Integer>> indexTotalOrder){
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> item : indexTotalOrder) {
            result.add(item.get(0));
        }
        return result;
    }
}
