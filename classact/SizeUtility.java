/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ogaz
 */
import java.io.*;

public class SizeUtility {
    
    static String getSizeDesciption(Object o) throws UnsizedException{
        
        if ((o instanceof String) || (o instanceof StringBuffer)){
            String ret = (String)o;
            return ret.length() + " characteres";
        } else if ((o instanceof Sized) & (o instanceof StudentRecords)){
            Sized ret = (Sized)o;
            return ret.getSize();
        } else {
            throw new UnsizedException();
        }
        
    }
    
}
