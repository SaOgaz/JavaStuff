package coupon;

import bestbuy.AddOn;
import bestbuy.Applies;
import bestbuy.PurchasedItems;
import bestbuy.StockItem;
/**
 *
 * @author ogaz
 */
public class CouponHealth implements AddOn,Applies,Coupon{
    @Override
    public String getLines(){
        return "#####COUPON#####\n"+
               "!Health Aid Purchase Coupon!\n"+
               "This coupon is good for 15% of your next health aid purchase\n"+
                "Good at all participating Best Buys\n\n";
    }
    
    @Override
    public boolean applies(PurchasedItems items){
        return items.typeFound(StockItem.HEALTH);
    }      
}
