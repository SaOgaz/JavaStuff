package bestbuy;

import java.util.Calendar;
/**
 *
 * @author ogaz
 */
public abstract class TaxComputation {
    
    public abstract double computeTax(PurchasedItems items, Calendar receiptDate);
    
    protected abstract boolean taxHoliday(Calendar receiptDate);
}
