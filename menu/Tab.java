package menu;

import java.util.ArrayList;
import java.util.Iterator;

public class Tab {
    ArrayList<Order> orderList;
    Float amountPaid;
    
    public Tab(){
        this.orderList = new ArrayList();
        amountPaid = 0.0f;
        
    }
    
    public void addItem(Order newOrder){
        orderList.add(newOrder);
    }
    
    public Float getTabTotal(){
        Float total=0f;
        Iterator<Order> iterator = orderList.iterator();
        while (iterator.hasNext()){
            total += iterator.next().getMenuItem().getPrice();
        }
        return total;
    }
    
    public Float getOwedTotal(){
        return getTabTotal() - amountPaid;
    }
    
    public void resetTab(){
        this.orderList = new ArrayList();
    }
    
    public void payTab(Float payment){
        amountPaid += payment;
    }
    
    public boolean isTabPaid(){
        if (getOwedTotal() < 0){
            return true;
        } else {
            return false;
        }
    }
}
