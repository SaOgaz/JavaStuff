/*
 * COSC 716
 * Sara Ogaz
 */

package menu;

public class Menu {
    
    public static final Integer APPETIZER = 1;
    public static final Integer MAIN_DISH = 2;
    public static final Integer DESSERT = 3;
    
    MenuItemNode firstItem,lastItem;

   
    public Menu(){
        this.firstItem = new MenuItemNode(new MenuItem("Shumai",APPETIZER,false,7.50f));
        MenuItemNode pointer = new MenuItemNode(new MenuItem("Salad", APPETIZER, true, 5.50f));
        firstItem.setNext(pointer);
        pointer.setNext(new MenuItemNode(new MenuItem("Sushi Roll", MAIN_DISH, true, 12.00f)));
        pointer = pointer.getNext();
        pointer.setNext(new MenuItemNode(new MenuItem("Tempura", MAIN_DISH, false, 7.00f)));
        pointer = pointer.getNext();
        pointer.setNext(new MenuItemNode(new MenuItem("Mochi", DESSERT, false, 5.00f)));
        pointer = pointer.getNext();
        pointer.setNext(new MenuItemNode(new MenuItem("Banana", DESSERT, true, 3.00f)));
        lastItem = pointer.getNext();
        
    }
    
    public Menu(Menu dummy){
        MenuItemNode current = this.firstItem;
        MenuIterator iter = getAllIterator();
        this.firstItem = new MenuItemNode(iter.getItem().getMenuItem());
        while (iter.hasNext()){
            current.setNext(new MenuItemNode(new MenuItem(iter.getItem().getMenuItem())));
            current = current.getNext();
        }        
    }
    
    public void addItem(String item ,Integer type, Boolean healthy, Float price){
        lastItem.setNext(new MenuItemNode(new MenuItem(item,type,healthy,price)));
        lastItem = lastItem.getNext();
    }
    
    
    public MenuIterator getAllIterator(){
        return new AllItemsIterator(firstItem);
    }
    
    public MenuIterator getItemIterator(Integer category){
        return new ItemIterator(this.firstItem,category);
    }
    
    public MenuIterator getHealthyIterator(){
        return new HeartHealthyIterator(this.firstItem);
    }
    
    public MenuIterator getPriceIterator(float myPrice){
        return new PriceIterator(this.firstItem,myPrice);
    }
   
      
   
    //Iterator CLASSES GO in this class
    private class AllItemsIterator implements MenuIterator{       
        MenuItemNode current;
       
        public AllItemsIterator(MenuItemNode myMenu){
            this.current = myMenu;
        }
              
        @Override
        public boolean hasNext(){
            return current.hasNext();
        }
        
        @Override
        public MenuItemNode getItem(){
            return current;
        }    
       
        @Override
        public void next(){
            current = current.getNext();
        }       
    }
   
    //Item Iterator
    private class ItemIterator implements MenuIterator{      
        MenuItemNode current;
        Integer category;
       
        public ItemIterator(MenuItemNode myMenu, Integer catIter){
            this.current = myMenu;
            this.category = catIter;
            goToStart();
        }       
        
        private void goToStart(){
            while (current.hasNext() && !current.getMenuItem().getCategory().equals(category)){
                current = current.getNext();
            }
        }
        
        @Override
        public boolean hasNext(){
            //move to first item            
            MenuItemNode temp = current;
            
            while (temp.hasNext()){
                if (temp.getNext().getMenuItem().getCategory().equals(category)){
                    return true;
                } else{temp = temp.getNext(); }                             
            }
            return false;       
        }
       
        @Override
        public MenuItemNode getItem(){
            return current;           
        }
       
        @Override
        public void next(){
            while (!current.getNext().getMenuItem().getCategory().equals(category)){
                current = current.getNext();
            }
            current = current.getNext();
        }
    }
       
    //HeartHealthyIterator
    private class HeartHealthyIterator implements MenuIterator{      
        MenuItemNode current;
       
        public HeartHealthyIterator(MenuItemNode myMenu){
            this.current = myMenu;
            goToStart();
        }
        
        private void goToStart(){
            while (current.hasNext() && !current.getMenuItem().getHeartHealthy()){
                current = current.getNext();
            }
        }
        
        @Override
        public boolean hasNext(){
            //move to first item            
            MenuItemNode temp = current;            
                        
            while (temp.hasNext()){
                if (temp.getNext().getMenuItem().getHeartHealthy()){
                    return true;
                } else {temp = temp.getNext();}                              
            }
            return false;       
        }
              
        @Override
        public MenuItemNode getItem(){
            return current;          
        }
       
        @Override
        public void next(){
            while (!current.getNext().getMenuItem().getHeartHealthy()){
                current = current.getNext();
            }
            current = current.getNext();
        }            
    }
   
    //PriceIterator
    private class PriceIterator implements MenuIterator{   
        MenuItemNode current;
        float price;
       
        public PriceIterator(MenuItemNode myMenu, Float myPrice){
            this.current = myMenu;
            this.price = myPrice;
            goToStart();
        }
        
        private void goToStart(){
            while (current.hasNext() && (!current.getMenuItem().getCategory().equals(MAIN_DISH) || 
                    current.getMenuItem().getPrice() > price)){
                current = current.getNext();
            }
        }
        
        @Override
        public boolean hasNext(){           
            MenuItemNode temp = current;            
            while (temp.hasNext()){
                if (temp.getNext().getMenuItem().getCategory().equals(MAIN_DISH) && 
                        temp.getNext().getMenuItem().getPrice() < price){
                    return true;
                } else{temp = temp.getNext(); }                             
            }
            return false;       
        }             
       
        @Override
        public MenuItemNode getItem(){
            return current;
           
        }
       
        @Override
        public void next(){
            while (!current.getNext().getMenuItem().getCategory().equals(MAIN_DISH) || 
                    current.getNext().getMenuItem().getPrice() > price){
                current = current.getNext();
            }
            current = current.getNext();
        }
    }
   
}
