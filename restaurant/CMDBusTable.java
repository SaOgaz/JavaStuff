/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.Order;

public class CMDBusTable implements Command{
    private Aggregator agg;
    private Integer tableNum;   
    
    public CMDBusTable(Aggregator agg, Integer tableNum){
        this.agg = agg;
        this.tableNum = tableNum;
    }
    
    @Override
    public Object execute(){
        agg.getTable(this.tableNum).busTable();
        return true;
    }
    
}
