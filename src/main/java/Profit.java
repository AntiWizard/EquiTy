import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Profit extends Orders {
    public static final String xmlFilePath = "C:\\Users\\alimi\\IdeaProjects\\EquiTy\\xmlfile.xml";

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static ArrayList<Double> listTotalProfit(ArrayList<Double> costList , ArrayList<Integer> indexSellOrders ,
                                                    ArrayList<Integer> indexBuyOrders){
        Profit wageProfit = new Profit();
        ArrayList<Double> profit = new ArrayList<>();
        for (int i = 0; i < indexBuyOrders.size(); i++) {
            profit.add(Double.parseDouble(df2.format(costList.get(indexSellOrders.get(i)) - costList.get(indexSellOrders.get(i)) * wageProfit.wage
                    - costList.get(indexBuyOrders.get(i)))));
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

    public static void createXmlFile (ArrayList<Integer> indexBuyOrders
            , ArrayList<Integer> indexSellOrders, ArrayList<Double> listTotalProfit){
        int id = 1;
        String inputPath = null;
        Scanner inputFile = new Scanner(System.in);
        String path = null;
        do {
            try {
                System.out.println("Enter Your Path Xml File :");
                inputPath = inputFile.next();
                path = inputPath + "\\xmlFile.xml" ;
            }catch (Exception e ){
                System.out.println("Enter Your Path Xml File :");
            }
        } while (!Files.exists(Objects.requireNonNull(Paths.get(Objects.requireNonNull(inputPath)))));

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Strategy");
            document.appendChild(root);

            for (int i = 0; i < indexBuyOrders.size();i++){
                Element Order = document.createElement("Order");

                root.appendChild(Order);

                // set an attribute to staff element
                Attr attr = document.createAttribute("id");
                attr.setValue(String.valueOf(id));
                Order.setAttributeNode(attr);

                id ++;
                //you can also use staff.setAttribute("id", "1") for this

                // Sell Order
                Element sellOrderDay = document.createElement("sellOrderDay");
                sellOrderDay.appendChild(document.createTextNode((indexSellOrders.get(i)).toString()));
                Order.appendChild(sellOrderDay);

                // lastname element
                Element buyOrderDay = document.createElement("buyOrderDay");
                buyOrderDay.appendChild(document.createTextNode((indexBuyOrders.get(i)).toString()));
                Order.appendChild(buyOrderDay);

                // email element
                Element profitDaySellToBuy = document.createElement("profitDaySellToBuy");
                profitDaySellToBuy.appendChild(document.createTextNode(listTotalProfit.get(i).toString()));
                Order.appendChild(profitDaySellToBuy);

            }

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(path));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
    public static HashMap<String, HashMap> returnJson(ArrayList<Integer> indexBuyOrders
            , ArrayList<Integer> indexSellOrders, ArrayList<Double> listTotalProfit, double sumProfit){
        HashMap<String,HashMap> result = new HashMap<>();

        int Count = 1;
        for(int i = 0; i < indexBuyOrders.size(); i++){
            HashMap<String,String> tmp = new HashMap<>();
            tmp.put("id",String.valueOf(Count));
            tmp.put("buyOrderDay",(indexBuyOrders.get(i)).toString());
            tmp.put("sellOrderDay",(indexSellOrders.get(i)).toString());
            tmp.put("profitDaySellToBuy",(listTotalProfit.get(i).toString()));
            result.put(String.valueOf(Count), tmp);
            Count ++;
        }
        HashMap<String,String> tmp2 = new HashMap<>();
        tmp2.put("sumProfit",String.valueOf(sumProfit));
        result.put("totalProfit" , tmp2);

        return result;
    }
}

