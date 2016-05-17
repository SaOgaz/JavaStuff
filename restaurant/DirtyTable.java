/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.Order;

public class DirtyTable extends TableState{
    
    public DirtyTable(Table restTable){
        super(restTable);
    }
    
    public DirtyTable(TableState source){
        super(source);
    }
    
    @Override
    public TableState transitionState(){
        if (getContext().getTableClean() == true){
            System.out.println("Changing state...");
            getContext().setState(new CleanTable(this));
            Integer tableNum = getContext().getTableNum();
            getContext().notifyObserver("Table Number "+tableNum.toString()+" is clean "
                    + "and ready to be seated");
        }
        return getContext().getState();       
    }
    
    @Override
    public boolean seatParty(Integer numPeople){
        System.out.println("Cannot seat here, table needs to be bused.");
        return false;
    }
    
    @Override
    public boolean payTab(Float moneyPaid){
        System.out.println("Tab has already been paid, table needs to be bused.");
        return false;
    }
    
    @Override
    public boolean addToTab(Order addOrder){
        System.out.println("Cannot add to table tab, no party seated.");
        return false;
    }
    
    @Override
    public boolean busTable(){
        getContext().setTableClean(true);
        transitionState();
        return true;
    }
}
