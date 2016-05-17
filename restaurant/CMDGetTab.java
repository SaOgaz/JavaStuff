/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

public class CMDGetTab implements Command{
    private Aggregator agg;
    private Integer tableNum;
    
    public CMDGetTab(Aggregator agg, Integer tableNum){
        this.agg = agg;
        this.tableNum = tableNum;
    }
    
    @Override
    public Object execute(){
        return agg.getTable(tableNum).getTableTab();
    }
}
