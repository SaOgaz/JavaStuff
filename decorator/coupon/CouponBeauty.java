/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coupon;

import bestbuy.AddOn;
import bestbuy.Applies;
import bestbuy.PurchasedItems;
import bestbuy.StockItem;


/**
 *
 * @author ogaz
 */
public class CouponBeauty implements AddOn,Applies,Coupon{
    @Override
    public String getLines(){
        return "#####COUPON#####\n"+
               "!Beauty Purchase Coupon!\n"+
               "This coupon is good for 10% of your next beauty purchase\n"+
                "Good at all participating Best Buys\n\n";
    }
    
    @Override
    public boolean applies(PurchasedItems items){
        return items.typeFound(StockItem.BEAUTY);
    }    
}
