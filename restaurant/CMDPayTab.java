/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.Menu;

public class CMDPayTab implements Command{
    private Aggregator agg;
    private Integer tableNum;
    private Float payment;
   
    public CMDPayTab(Aggregator agg, Integer tableNum, Float payment){
        this.agg = agg;
        this.tableNum = tableNum;
        this.payment = payment;
    }
    
    @Override
    public Object execute(){
        agg.getTable(tableNum).payTab(payment);           
        return true;
    }
    
    
}
