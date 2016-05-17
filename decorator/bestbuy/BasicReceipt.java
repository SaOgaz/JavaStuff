package bestbuy;
import java.util.Calendar;
import java.lang.Double;


/**
 *
 * @author ogaz
 */
public class BasicReceipt implements Receipt{
    private String storeInfo; //store number, store address, phone number
    private String stateCode; // MD,DE,CA or MA
    
    private PurchasedItems items;
    private Calendar date;
    private TaxComputation tc;
    
    public BasicReceipt(PurchasedItems items, Calendar date) {
        this.items = items;
        this.date = date;
    }
    
    public void setTaxComputation(TaxComputation input_tc){
        tc = input_tc;
    }
    
    public void setStoreInfo(String num, String address, String phone){
        storeInfo = "----------------\nStore Number "+
                num+"\n"+address+"\n"+phone+"\n----------------\n";
    }
    
    public void setStateCode(String state){
        stateCode = state;
    }
    
    public void addSalesItem(StockItem newItem){
        items.addItem(newItem);
    }
    
    @Override
    public void prtReceipt() {
        //print a short header and all times purchased, with price and item type
        System.out.print(storeInfo);
        System.out.println("Itemeized Purchases:");
        items.printItems();
        Double tot_sale = items.getTotalSale();
        System.out.format("\nSale Total: $%10.2f\n",tot_sale);
        Double tot;
                
        if (tc != null){
            Double tot_tax = tc.computeTax(items,date);
            tot = tot_sale+tot_tax;
            System.out.format(" Tax Total: $%10.2f\n",tot_tax);
        } else {tot = tot_sale;}
        System.out.println("            -----------");
        System.out.format(" Total Due: $%10.2f\n\n\n",tot);
    }
}
