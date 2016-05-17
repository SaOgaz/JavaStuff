/*
 * COSC 716
 * Sara Ogaz
 */

package library;

import java.util.*;

public class EBookFactory extends AbBookFactory{
    BookIterator ForFictIter = getEBookIter();
    BookIterator ForNonFictIter = getEBookIter();
    
    Book nextFictBook,nextNonFictBook;
    
    @Override
    public Book getFiction(){
        return nextFictBook;
    }
    
    @Override
    public Boolean hasNextFiction(){
        while (ForFictIter.hasNext()){
            nextFictBook = ForFictIter.getBook();
            if (nextFictBook.getFtype().equals(Book.FICTION)){
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public Book getNonFiction(){
        return nextNonFictBook;
    }        
    
    @Override
    public Boolean hasNextNonFiction(){
        while (ForNonFictIter.hasNext()){
            nextNonFictBook = ForNonFictIter.getBook();
            if (nextNonFictBook.getFtype().equals(Book.NONFICTION)){
                return true;
            }
        }
        return false;
    }
    
    
}
