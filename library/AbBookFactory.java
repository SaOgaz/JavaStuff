/*
 * COSC 716
 * Sara Ogaz
 */

package library;

import java.util.*;


public abstract class AbBookFactory{    
    
    abstract Book getFiction();
    abstract Book getNonFiction();
    abstract Boolean hasNextFiction();
    abstract Boolean hasNextNonFiction();
    
    static ArrayList<Book> myLibrary = new ArrayList<Book>();
    
    /**
     * return bookfactory according to type
     */     
    public static AbBookFactory getBookFactory(String type) throws IllegalArgumentException{
        switch (type){
            case "EBook":
                return new EBookFactory();
            case "PhyBook":
                return new PhyBookFactory();}
        
        throw new IllegalArgumentException("Not a valid factory type input");
    }
    
    
    public static void addBook(Book newBook){
        myLibrary.add(newBook);
    }
    
     
    public BookIterator getEBookIter(){
        return new EBookIterator();    
    }   
    
    public BookIterator getPhysicalIter(){
        return new PhysicalIterator();
    }
    
    public class EBookIterator implements BookIterator{
        Iterator<Book> myIter = myLibrary.iterator();
        Book nextBook;
                
        @Override
        public boolean hasNext(){
            while (myIter.hasNext()){
                nextBook = myIter.next();
                if (nextBook.getMtype().equals(Book.EBOOK) || nextBook.getMtype().equals(Book.BOTH)){
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public Book getBook(){            
            return nextBook;
        }
    }


    
    public class PhysicalIterator implements BookIterator{
        Iterator<Book> myIter = myLibrary.iterator();
        Book nextBook;
        
        @Override
        public boolean hasNext(){
            while (myIter.hasNext()){
                nextBook = myIter.next();
                if (nextBook.getMtype().equals(Book.PHYSICAL) || nextBook.getMtype().equals(Book.BOTH)){
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public Book getBook(){
            return nextBook; 
        }
        
    } 
    
}
