/* 
* COSC716
* Author: Sara Ogaz
*/

package restaurant;

import menu.Order;

public class SeatedTable extends TableState{
    
    public SeatedTable(Table restTable){
        super(restTable);
    }
    
    public SeatedTable(TableState source){
        super(source);
    }
    
    @Override
    public TableState transitionState(){
        if ((getContext().getTableTab().isTabPaid())){
            getContext().setSeated(0);
            getContext().resetTab();
            System.out.println("Changing state...");
            getContext().setState(new DirtyTable(this));
            Integer tableNum = getContext().getTableNum();
            getContext().notifyObserver("Table Number "+tableNum.toString()+"'s tab "
                    + "is paid and ready to be bused");
        }
        return getContext().getState();       
    }
    
    
    @Override
    public boolean seatParty(Integer numPeople){
        System.out.println("Can't seat here, table already taken.");
        return false;
    }
    
    @Override
    public boolean payTab(Float moneyPaid){
        getContext().getTableTab().payTab(moneyPaid);
        transitionState();
        return true;
    }    
 
    @Override
    public boolean addToTab(Order addOrder){
        getContext().getTableTab().addItem(addOrder);
        return true;
    }
    
    @Override
    public boolean busTable(){
        System.out.println("Table is in use.");
        return false;
    }
    
}
