/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.Order;

public class CleanTable extends TableState{
    
    public CleanTable(Table restTable){
        super(restTable);
    }
    
    public CleanTable(TableState source){
        super(source);
    }
    
    @Override
    public TableState transitionState(){
        if (getContext().getSeated() > 0){
            System.out.println("Changing state...");
            getContext().setState(new SeatedTable(this));
            Integer tableNum = getContext().getTableNum();
            getContext().notifyObserver("Table Number "+tableNum.toString()+" is seated "
                    + "and needs waitstaff");
        }
        
        return getContext().getState();
    }
    
    @Override
    public boolean seatParty(Integer numPeople){
        if (getContext().getSeated() <= getContext().getSeatNum()){
            getContext().setSeated(numPeople);
            transitionState();
            return true;
        } else {
            System.out.println("Party too large for this table");
            return false;
        }
    }
    
    @Override
    public boolean payTab(Float moneyPaid){
        System.out.println("No tab open, table ready for seating.");
        return false;
    }
    
    @Override
    public boolean addToTab(Order addOrder){
        System.out.println("No tab open, table ready for seating");
        return false;
    }
    
    @Override
    public boolean busTable(){
        System.out.println("Table is already clean");
        return false;
    }
     
}

