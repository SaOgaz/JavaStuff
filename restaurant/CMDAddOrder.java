/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.Order;

public class CMDAddOrder implements Command{
    private Aggregator agg;
    private Integer tableNum;
    private Order inOrder;    
    
    public CMDAddOrder(Aggregator agg, Order inOrder){
        this.agg = agg;
        this.inOrder = inOrder;
        this.tableNum = inOrder.getTableNum();
    }
    
    @Override
    public Object execute(){
        agg.getTable(tableNum).addToTab(inOrder);
        return true;
    }
    
}
