/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.*;

public class Aggregator {
    Menu menu;
    Table[] tables;
    
    public Aggregator(){
        //setup menu
        this.menu = new Menu();
        
        //set up tabs for all tables in restaurant
        tables = new Table[6];
        tables[0] = new Table(1,4);
        tables[1] = new Table(2,4);
        tables[2] = new Table(3,2);
        tables[3] = new Table(4,6);
        tables[4] = new Table(5,8);
        tables[5] = new Table(6,4);
    }
    
    public Table getTable(Integer tableNum){
        return tables[tableNum-1];
    }  
    public Table[] getTableArr(){
        return tables;
    }   
    public Menu getMenu(){
        //this can return copy, how are we implementing copy?
        return menu;
    }    
}
