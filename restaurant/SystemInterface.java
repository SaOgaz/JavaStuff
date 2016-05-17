/* 
* COSC716
* Author: Sara Ogaz
*/

package restaurant;

import menu.Menu;
import static menu.Menu.APPETIZER;
import static menu.Menu.DESSERT;
import static menu.Menu.MAIN_DISH;
import menu.MenuItemNode;
import menu.MenuIterator;
import menu.MenuItem;
import menu.Order;
import menu.Tab;

public class SystemInterface {
    private Invoker invoker;
    
    public SystemInterface(){
        invoker = new Invoker();
    }
    
 
    public void printMenu(){
        Menu menu = invoker.getMenu();
        MenuIterator itr = menu.getAllIterator();
        
        System.out.println("ALL MENU ITEMS");
        MenuItemNode item;
        Integer itemIndex = 1;
        while (itr. hasNext()){            
            item = itr.getItem();
            System.out.println(itemIndex.toString()+":"+item.getMenuItem().getItemName()+" $"+item.getMenuItem().getPrice());
            itr.next();
            itemIndex++;
        }
        item = itr.getItem();
        System.out.println(itemIndex.toString()+":"+item.getMenuItem().getItemName()+" $"+item.getMenuItem().getPrice()+'\n');
    }
    
    public void seatParty(Integer tableNum, Integer customers){
        invoker.seatParty(tableNum, customers);
        System.out.println("");
    }
    
    public void payTab(Integer tableNum, Float amountPaid){
        invoker.payTab(tableNum,amountPaid);
        getTab(tableNum);
        System.out.println("");
    }
    
    public void getTab(Integer tableNum){
        Float tabTotal = invoker.getTab(tableNum).getOwedTotal();
        System.out.println("Tab Owed for Table "+tableNum.toString()+" is: $"+tabTotal.toString()+"\n");

    }
    
    public void busTable(Integer tableNum){
        invoker.busTable(tableNum);
        System.out.println("");
    }
    
    public void enterOrder(Integer tableNum, Integer itemNum){
        Order inOrder;
        switch (itemNum){
            case 1:
                inOrder = new Order(new MenuItem("Shumai",APPETIZER,false,7.50f),tableNum);
                break;
            case 2:
                inOrder = new Order(new MenuItem("Salad", APPETIZER, true, 5.50f),tableNum);
                break;
            case 3:
                inOrder = new Order(new MenuItem("Sushi Roll", MAIN_DISH, true, 12.00f),tableNum);
                break;
            case 4:
                inOrder = new Order(new MenuItem("Tempura", MAIN_DISH, false, 7.00f),tableNum);
                break;
            case 5:
                inOrder = new Order(new MenuItem("Mochi", DESSERT, false, 5.00f),tableNum);
                break;
            case 6:
                inOrder = new Order(new MenuItem("Banana", DESSERT, true, 3.00f),tableNum);
                break;
            default:
                System.out.println("Not a valid item number!");
                inOrder = null;
        }
        System.out.println("");
        invoker.addOrder(inOrder);
    }
    
}
