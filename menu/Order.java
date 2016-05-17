/* 
* COSC716
* Author: Sara Ogaz
*/

package menu;

import menu.*;

public class Order {
    private MenuItem item;
    private Integer tableNum;
    
    public Order(MenuItem item, Integer tableNum){
        this.item = item;
        this.tableNum = tableNum;
    }
    
    public MenuItem getMenuItem(){
        return item;
    }
    
    public Integer getTableNum(){
        return tableNum;
    }
}
