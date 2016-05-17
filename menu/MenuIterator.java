/* 
* COSC716
* Author: Sara Ogaz
*/
package menu;

public interface MenuIterator {
    public boolean hasNext();
    public MenuItemNode getItem();
    public void next();
}
