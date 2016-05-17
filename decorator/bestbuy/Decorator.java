package bestbuy;

/**
 *
 * @author ogaz
 */
public abstract class Decorator implements Receipt{
    private Receipt trailer;
    
    public Decorator(Receipt r){
        trailer = r;
    }
    
    protected void callTrailer() {
        trailer.prtReceipt();
    }
    
    @Override
    public abstract void prtReceipt();
}
