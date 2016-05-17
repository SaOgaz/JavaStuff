/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;
import menu.*;

public class CMDGetMenu implements Command{
    private Aggregator agg;
   
    public CMDGetMenu(Aggregator agg){
        this.agg = agg;
    }
    
    @Override
    public Object execute(){
        //there's an issue with my Menu copying
        //return new Menu(agg.getMenu());
        return agg.getMenu();
    }
}
