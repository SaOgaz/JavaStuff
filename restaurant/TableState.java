/* 
* COSC716
* Author: Sara Ogaz
*/

package restaurant;

import menu.Order;

public class TableState {
    private Table context;
    
    public TableState(Table restTable){
        setContext(restTable);
    }
    
    public TableState(TableState source){
        setContext(source.getContext());
    }
    
    public static TableState InitializeState(Table table){
        return new CleanTable(table);
    }
    
    public TableState transitionState(){
        return null;
    }
    
    public void setContext(Table restTable){
        context = restTable;
    }        
    
    public Table getContext(){
        return context;
    }
            
    public Table getTable(){
        return context;
    }
    
    public boolean seatParty(Integer numPeople){
        return false;
    }
    
    public boolean payTab(Float moneyPaid){
        return false;
    }
    
    public boolean addToTab(Order addOrder){
        return false;
    }
    
    public boolean busTable(){
        return false;
    }
   
}
