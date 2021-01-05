import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    public static int inputNumber(){
        int inputNum = 0;
        Scanner inputNumScanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter Your Numbers(Integer , greater than 0(>0)) :");
                inputNum = Integer.parseInt(inputNumScanner.next());
            }catch (Exception e ){
                System.out.println("Just enter Number(between [1-1000]) not any thing else :");
            }
        } while (inputNum < 1);
        return inputNum;
    }
    public static ArrayList<Double> costList(int inputNum){
        int Count = 0;
        double Cost;
        ArrayList<Double> costList = new ArrayList<>();
        Scanner inputNumScanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Enter Your Costs :");
                Cost = Double.parseDouble(inputNumScanner.next());
                if (Cost > 0){
                    costList.add(Cost);
                    Count ++;
                }
                else {
                    System.out.println("Cost must be greater than 0(0>)!!");
                }
            }catch (Exception e ){
                System.out.println("Just enter Cost(between [100-10^9]) not any type else :");
            }
        } while (inputNum > Count);
        return costList;
    }
}
