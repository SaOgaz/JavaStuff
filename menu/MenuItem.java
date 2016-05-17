/* 
* COSC716
* Author: Sara Ogaz
*/

package menu;

public class MenuItem {
    
    private final String itemName;
    private final Integer category;
    private final Boolean heartHealthy;
    private final Float price;
    
    //blah blah blah
    public MenuItem(String item, Integer cat, Boolean heart, Float price){
        this.itemName = item;
        this.category = cat;
        this.heartHealthy = heart;
        this.price = price;
    }
    
    public MenuItem(MenuItem dummy){
        this.itemName = dummy.getItemName();
        this.category = dummy.getCategory();
        this.heartHealthy = dummy.getHeartHealthy();
        this.price = dummy.getPrice();
    }
    
    public String getItemName(){
        return this.itemName;
    }
    
    public Integer getCategory(){
        return this.category;
    }
    
    public boolean getHeartHealthy(){
        return this.heartHealthy;
    }
    
    public Float getPrice(){
        return this.price;
    }
}
