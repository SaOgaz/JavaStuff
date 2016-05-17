/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

public class CMDSeatParty implements Command{
    private Aggregator agg;
    private Integer tableNum;
    private Integer customers;
   
    public CMDSeatParty(Aggregator agg, Integer tableNum, Integer customers){
        this.agg = agg;
        this.tableNum = tableNum;
        this.customers = customers;
    }
    
    @Override
    public Object execute(){
        agg.getTable(tableNum).seatParty(customers);           
        return true;
    }
    
}
