/*
 * COSC 716
 * Sara Ogaz
 */

package library;

public class Book {
    
    public static final String FICTION = "Fiction";
    public static final String NONFICTION = "Non-Fiction";
    
    public static final String PHYSICAL = "Physical";
    public static final String EBOOK = "E-Book";
    public static final String BOTH = "E-Book and Physical";
    
    String title,author;
    String ftype,mtype;
    
    public Book(String title, String author, String ftype, String mtype){
        this.title = title;
        this.author = author;
        this.ftype = ftype;
        this.mtype = mtype;
    }
    
    public String getFtype(){
        return ftype;
    }
    
    public String getMtype(){
        return mtype;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
}
