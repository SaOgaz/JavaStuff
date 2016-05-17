package bestbuy;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.*;

//local
import greeting.*;
import rebate.*;
import coupon.*;

/**
 *
 * @author ogaz
 */
public class ReceiptFactory {
    private String store_num;
    private String street_addr;
    private String phone;
    private String state_code;
    
    private AddOn[] addOns; //greeting, rebate and coupon add-ons
    
    public ReceiptFactory(){
        //read in config and initialize variables
        try (FileReader fileReader = new FileReader("config.txt")){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.store_num=bufferedReader.readLine();
            this.street_addr=bufferedReader.readLine();
            this.phone=bufferedReader.readLine();
            this.state_code=bufferedReader.readLine();
            bufferedReader.close();
            
        } catch (FileNotFoundException ex){
            System.out.println("Cannot find config file: config.txt");
        } catch (IOException ex){
            System.out.println("Error reading config.txt file");
        }
        
        //get addons
        getAddOns();
    }
    
    public Receipt getReceipt(PurchasedItems items, Calendar date) throws UnKnownAddOnTypeException {        
        
        Receipt receipt = new BasicReceipt(items,date);
        ((BasicReceipt)receipt).setStateCode(state_code);
        ((BasicReceipt)receipt).setStoreInfo(store_num,street_addr,phone);
        
        //link appropriate tax computation object
        System.out.println("my state code is: "+state_code);
        switch(state_code){
            case "MD":
                ((BasicReceipt)receipt).setTaxComputation(new MDTaxComputation());
                break;
            case "DE":
                ((BasicReceipt)receipt).setTaxComputation(null);
                break;
            case "CA":
                ((BasicReceipt)receipt).setTaxComputation(new CATaxComputation());
                break;
            case "MA":
                ((BasicReceipt)receipt).setTaxComputation(new MATaxComputation());
                break;
            default:
                System.out.println("couldn't find appropriate state code");
                break;
        }
        
        
        for (AddOn a: addOns){
            if (a instanceof Greeting){
                receipt = new PreDecorator(a, receipt);
            }             
            else {
                if (a instanceof Applies && ((Applies)a).applies(items)){
                    if (a instanceof Rebate || a instanceof Coupon){
                        receipt = new PostDecorator(a, receipt);
                    } else {throw new UnKnownAddOnTypeException("Unknown AddOn Type");}
                }
            }           
        }
        
        return receipt;
        
    }
    
    private void getAddOns(){
        addOns = new AddOn[5];
        
        addOns[0]=new SpringGreeting();
        addOns[1]=new CouponBeauty();
        addOns[2]=new Rebate42();
        addOns[3]=new Rebate500();
        addOns[4]=new CouponHealth();
    }
}