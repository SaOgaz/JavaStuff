package bestbuy;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ogaz
 */
public class MATaxComputation extends TaxComputation{    
    private final float salesTax;
    
    public MATaxComputation(){
        this.salesTax = 0.0625f;
    }
    
    @Override
    public double computeTax(PurchasedItems items, Calendar recieptdate){        
        //check if tax holiday
        if (taxHoliday(recieptdate)){
            double unTaxedTot = 0;
            System.out.println("**Tax holiday**\n");
            unTaxedTot += items.getTotalSaleType(StockItem.SCHOOL);
            unTaxedTot += items.getTotalSaleType(StockItem.COMPUTER);
            unTaxedTot += items.getTotalSaleType(StockItem.SPORTS);
            unTaxedTot += items.getTotalSaleType(StockItem.HEALTH);
            unTaxedTot += items.getTotalSaleType(StockItem.BEAUTY);           
            
            double stillTaxed = items.getTotalSale() - unTaxedTot;           
            return (stillTaxed * salesTax);
        } else {           
            //compute tax  for MA
            double finalTax = items.getTotalSale() * salesTax;
            return finalTax;
        }        
    }
    
    @Override
    protected boolean taxHoliday(Calendar recieptDate){
        //holiday is second weekend of August
        int holidayMonth = 7;
        int holidayWeekSat = 2;
        int holidayWeekSun = 3;
        int holidayDay2 = GregorianCalendar.SUNDAY;
        
        if (recieptDate.get(Calendar.MONTH) == holidayMonth){
            if (recieptDate.get(Calendar.WEEK_OF_MONTH) == holidayWeekSat 
                    & recieptDate.get(Calendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY){
                return true;
            } else if (recieptDate.get(Calendar.WEEK_OF_MONTH) == holidayWeekSun 
                    & recieptDate.get(Calendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY){
                return true;
            } else {
                return false;
            }
                    
        } else {
            return false;
        }
    }
                

    
}
