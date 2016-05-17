/*
 * COSC 716
 * Sara Ogaz
 */
package library;

public class PhyBookFactory extends AbBookFactory{    
    BookIterator ForFictIter = getPhysicalIter();
    BookIterator ForNonFictIter = getPhysicalIter();
    
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

