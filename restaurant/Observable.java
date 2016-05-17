/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

public interface Observable {
    public void register(Observer obs);
    public void unRegister(Observer obs);
    public void notifyObserver(String inMessage);
}
