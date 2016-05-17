package bestbuy;
import java.util.Calendar;

/**
 *
 * @author ogaz
 */
public class MDTaxComputation extends TaxComputation{
    private final float salesTax;
    
    public MDTaxComputation(){
        this.salesTax = 0.06f;
    }
    
    @Override
    public double computeTax(PurchasedItems items, Calendar recieptdate){       
        //check if tax holiday
        if (taxHoliday(recieptdate)){
            System.out.println("**Tax holiday**\n");
            double stillTaxed = items.getTotalSaleType(StockItem.COMPUTER);
            stillTaxed += items.getTotalSaleType(StockItem.COMPUTER_ACCESSORY);           
            return (stillTaxed * salesTax);
        } else {           
            //compute tax  for MD 6%
            double finalTax = items.getTotalSale() * salesTax;
            return finalTax;
        }        
    }
    
    @Override
    protected boolean taxHoliday(Calendar recieptDate){
        //Let's say the MD tax holiday is on July 6th (my birthday), month is 0 indexed
        int holidayMonth = 6;
        int holidayDay = 6;
        
        if (recieptDate.get(Calendar.MONTH) == holidayMonth & recieptDate.get(Calendar.DAY_OF_MONTH) == holidayDay){
            return true;
        } else { return false;}       
    }
    
}
