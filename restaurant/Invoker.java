/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import menu.*;

public class Invoker implements Observer{
    Aggregator agg;
    
    public Invoker(){
        agg = new Aggregator();       
        registerMyself();
    }
    
    private void registerMyself(){
        //register invoker with tables
        Table[] tableList = agg.getTableArr();
        
        int size = tableList.length;
        Table currentTable;
        for (int i=0; i<size; i++){
            currentTable = tableList[i];
            currentTable.register(this);
        }
    }
    
    public Menu getMenu(){
        return (Menu)new CMDGetMenu(agg).execute();
    }
       
    public boolean addOrder(Order inOrder){
        return (boolean)new CMDAddOrder(agg,inOrder).execute();
    }
    
    public boolean seatParty(Integer tableNumber, Integer numPeople){
        return (boolean)new CMDSeatParty(agg,tableNumber,numPeople).execute();
    }
        
    public boolean payTab(Integer tableNumber, Float amountPaid){
        return (boolean)new CMDPayTab(agg,tableNumber,amountPaid).execute();
    }
    
    public Tab getTab(Integer tableNumber){
        return (Tab)new CMDGetTab(agg,tableNumber).execute();
    }
    
    public boolean busTable(Integer tableNumber){
        return (boolean)new CMDBusTable(agg,tableNumber).execute();
    }
    
    @Override
    public void update(String outMessage){
        System.out.println(outMessage);
    }
}
