package bestbuy;

import java.util.*;
import java.lang.Double;
/**
 *
 * @author ogaz
 */
public class PurchasedItems {
    private ArrayList<StockItem> itemArr;
    
    public PurchasedItems(){
        //empty constructor for now I guess?
        itemArr = new ArrayList();
    }

    
    public void addItem(StockItem item){
        itemArr.add(item);
    }
    
   
    public Double getTotalSale(){
        Iterator<StockItem> receiptIter = itemArr.iterator();
        Double runningTotal = 0.0;
        while (receiptIter.hasNext()){
            runningTotal += receiptIter.next().getPrice();
        }
        return runningTotal;       
    }
    
    public Double getTotalSaleType(String type){
        Iterator<StockItem> receiptIter = itemArr.iterator();
        Double runningTotal = 0.0;
        while (receiptIter.hasNext()){
            StockItem currentItem = receiptIter.next();
            
            //check if item matches desired type
            if (currentItem.getType() == type){
                runningTotal += currentItem.getPrice();
            }
        }
        return runningTotal; 
    }
    
    public void printItems(){
        //print all item name, item type, and item price
        Iterator<StockItem> receiptIter = itemArr.iterator();
        StockItem current;
        while (receiptIter.hasNext()){
            current = receiptIter.next();
            System.out.format("%25s   %25s   $%10.2f\n",current.getName(),current.getType(),current.getPrice());
        }
    }
    
    public boolean itemFound(String itemName, String itemType){
        //check if item exsists in current itemArr
        Iterator<StockItem> receiptIter = itemArr.iterator();
        StockItem current;
        while (receiptIter.hasNext()){
            current = receiptIter.next();
            if (current.getName().equals(itemName) && current.getType().equals(itemType)){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean typeFound(String itemType){
        //check if item exsists in current itemArr
        Iterator<StockItem> receiptIter = itemArr.iterator();
        StockItem current;
        while (receiptIter.hasNext()){
            current = receiptIter.next();
            if (current.getType().equals(itemType)){
                return true;
            }
        }
        return false;
    }
}
