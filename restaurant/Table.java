/* 
* COSC716
* Author: Sara Ogaz
*/

package restaurant;

import java.util.ArrayList;
import java.util.Iterator;

import menu.Tab;
import menu.Order;


/**
 *
 * @author ogaz
 */
public class Table implements Observable{
    private final Integer tableNum;
    private final Integer seatNum;
    private Integer custSeated;
    private Tab tableTab;
    private boolean tableClean;
    
    private ArrayList<Observer> observerList;
    private TableState objState;
    
    public Table(Integer tableNum, Integer seats){
        this.tableNum = tableNum;
        this.seatNum = seats;
        this.custSeated = 0;
        this.tableTab = new Tab();
        this.tableClean = true;
        
        this.observerList = new ArrayList();
        objState = TableState.InitializeState(this);
    }
    
    public void setState(TableState newState){
        objState = newState;
    }
    
    public TableState getState(){
        return objState;
    }
    
    public boolean seatParty(Integer numPeople){
        return getState().seatParty(numPeople);
    }
    
    public boolean payTab(Float moneyPaid){
        return getState().payTab(moneyPaid);
    }
    
    public boolean addToTab(Order newOrder){
        return getState().addToTab(newOrder);
    }
    
    public boolean resetTab(){
        this.tableTab = new Tab();
        return true;
    }
    
    public boolean busTable(){
        return getState().busTable();
    }
    
    public void setSeated(Integer numPeople){
        custSeated = numPeople;
    }
    
    public Integer getSeated(){
        return custSeated;
    }
    
    public Integer getTableNum(){
        return tableNum;
    }
    
    public Integer getSeatNum(){
        return seatNum;
    }
    
    public boolean getTableClean(){
        return tableClean;
    }
    
    public void setTableClean(boolean cleanBool){
        tableClean = cleanBool;
    }
    
    public Tab getTableTab(){
        return tableTab;
    }
    
    @Override
    public void register(Observer obs){
        observerList.add(obs);
    }
    
    @Override
    public void unRegister(Observer obs){
        if (observerList.remove(obs)){
            System.out.println("Succesfully removed from the ObserverList.");
        } else { System.out.println("Observer was not in ObserverList.");}
    }
    
    @Override
    public void notifyObserver(String inMessage){
        //only send certain notifications to certain groups
        Iterator<Observer> iterator = observerList.iterator();
        while (iterator.hasNext()){
            Observer next = iterator.next();
            next.update(inMessage);
        }
    }
}
