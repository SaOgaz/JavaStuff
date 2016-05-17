package bestbuy;
import java.util.Calendar;

/**
 *
 * @author ogaz
 */
public class CATaxComputation extends TaxComputation{
    private final float salesTax;
    
    public CATaxComputation(){
        this.salesTax = 0.075f;
    }
    
    @Override
    public double computeTax(PurchasedItems items, Calendar recieptdate){       
        //not tax holidays
        double finalTax = items.getTotalSale() * salesTax;
        return finalTax;       
    }
    
    @Override
    protected boolean taxHoliday(Calendar recieptDate){
        //no tax holidays
        return false;      
    }
        
}
