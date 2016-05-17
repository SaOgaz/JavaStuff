/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebate;

import bestbuy.AddOn;
import bestbuy.Applies;
import bestbuy.PurchasedItems;
import bestbuy.StockItem;

/**
 *
 * @author ogaz
 */
public class Rebate500 implements AddOn, Applies, Rebate{
    @Override
    public String getLines(){
        return "#####REBATE#####\n"+
                "!Mail-in Rebate for any School Supply item!\n"+
               "Name:\n"+ "Address:\n\n\n" + "Mail to: Best Buy Rebates, P.O. Box 1400, Planet Zed\n";
    }
    
    @Override
    public boolean applies(PurchasedItems items){
        return items.typeFound(StockItem.SCHOOL);
    }
}
