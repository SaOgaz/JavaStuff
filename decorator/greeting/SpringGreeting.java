package greeting;

import bestbuy.AddOn;
/**
 *
 * @author ogaz
 */
public class SpringGreeting implements AddOn,Greeting{
    public String getLines() {
        return "*** Happy Spring from Best Buy ***\n";
    }
}
