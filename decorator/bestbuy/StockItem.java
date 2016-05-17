package bestbuy;

/**
 *
 * @author ogaz
 */
public class StockItem {
    private String itemName;
    private float itemPrice;
    private String itemType;
    
    public static final String COMPUTER = "computer";
    public static final String COMPUTER_ACCESSORY = "computer accessories";
    public static final String SPORTS = "sports equimpent";
    public static final String HEALTH = "health aid";
    public static final String BEAUTY = "beauty aid";
    public static final String SCHOOL = "school supplies";
    public static final String BOOK = "book";
    
    
    public StockItem(String name, float price, String type){
        this.itemName = name;
        this.itemPrice = price;
        this.itemType = type;
    }
    
    public String getName(){
        return itemName;
    }
    
    public float getPrice(){
        return itemPrice;
    }
    
    public String getType(){
        return itemType;
    }
}
