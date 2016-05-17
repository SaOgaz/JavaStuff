/* 
* COSC716
* Author: Sara Ogaz
*/

package menu;

public class MenuItemNode {
    private MenuItem item = null;
    private MenuItemNode next = null;
    
    //blah blah blah
    public MenuItemNode(MenuItem item){
        this.item = item;
        this.next = null;
    }
    
    public MenuItemNode(MenuItem item, MenuItemNode next){
        this.item = item;
        this.next = next;
    }
    
    public void setNext(MenuItemNode nextVal){
        next = nextVal;
    }
    
    public MenuItemNode getNext(){
        return next;
    }
    
    public MenuItem getMenuItem(){
        return item;
    }
                             
    public Boolean hasNext(){
        if (next == null){
            return false;
        }
        return true;
    }
    
}
