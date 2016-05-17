package bestbuy;


import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author ogaz
 */
public class BestBuy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //get receipt date
        Calendar date = Calendar.getInstance();
        
        Scanner user_input = new Scanner(System.in);
        System.out.println("Please provide year,month, and date, seperated by commas");
        String[] dateString = user_input.next().split(","); 
        
        date.set(Integer.parseInt(dateString[0]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[2]));

        
        //display all available products to user
        System.out.println("\n List of Available Products:");
        System.out.format("ID %35s %11s\n","Item Name","Item Price");
        System.out.format("1  %35s $%10.2f\n","Cats Quest - Book",10.99f);
        System.out.format("2  %35s $%10.2f\n","Hitchhikers Guide...-Paper",19.99f);
        System.out.format("3  %35s $%10.2f\n","Fancy PC Laptop",2000.99f);
        System.out.format("4  %35s $%10.2f\n","USB Speakers",60.00f);
        System.out.format("5  %35s $%10.2f\n","Hockey Stick",49.99f);
        System.out.format("6  %35s $%10.2f\n","Band Aids",2.89f);
        System.out.format("7  %35s $%10.2f\n","Cover Girl Mascara",7.99f);
        System.out.format("8  %35s $%10.2f\n","Pencil Case",5.00f);        
        

        //get all user selections
        PurchasedItems items = new PurchasedItems();
        System.out.println("\nPlease select your purchases.\nEnter ID number, enter 'q' when finished.\n\n");
        String nextI = user_input.next();       
        while (!nextI.equals("q")){            
            switch (nextI){
                case "1":
                   items.addItem(new StockItem("Cats Quest",10.99f,StockItem.BOOK));
                   break;
                case "2":
                   items.addItem(new StockItem("Hitchhikers Guide to the Universe",19.99f,StockItem.BOOK)); 
                   break;
                case "3":
                   items.addItem(new StockItem("Fancy PC Laptop",2000.99f,StockItem.COMPUTER)); 
                   break;
                case "4":
                   items.addItem(new StockItem("USB Speakers",60.00f,StockItem.COMPUTER_ACCESSORY)); 
                   break;
                case "5":
                   items.addItem(new StockItem("Hockey Stick",49.99f,StockItem.SPORTS)); 
                   break;  
                case "6":
                   items.addItem(new StockItem("Band Aids",2.89f,StockItem.HEALTH)); 
                   break;   
                case "7":
                   items.addItem(new StockItem("Cover Girl Mascara",7.99f,StockItem.BEAUTY)); 
                   break; 
                case "8":
                   items.addItem(new StockItem("Pencil Case",5.00f,StockItem.SCHOOL)); 
                   break;                  
                default:
                    System.out.println("Not a valid ID number, please try again");
                    break;
            }
            nextI = user_input.next();
        }
        
        System.out.print("\n\n");
        
        
        //create receipt
        ReceiptFactory factory = new ReceiptFactory();
        
        //catch getReceipt excetions
        try{
            Receipt receipt = factory.getReceipt(items,date);
            receipt.prtReceipt();
        } catch (UnKnownAddOnTypeException ex){
            System.out.println(ex.toString());
        }
        
    }
    
}
