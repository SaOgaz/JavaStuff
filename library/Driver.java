/*
 * COSC 716
 * Sara Ogaz
 */

package library;

public class Driver{

    public static void main(String[] args) {
        
        AbBookFactory.addBook(new Book("How to Care For Your Dragon","Yoshi Story",Book.NONFICTION,Book.BOTH));
        AbBookFactory.addBook(new Book("Mario's Day Out","Luigi Brother",Book.FICTION,Book.EBOOK));
        AbBookFactory.addBook(new Book("Hot Griddle Cakes","Sonic Hedgehog",Book.NONFICTION,Book.PHYSICAL));
        AbBookFactory.addBook(new Book("Fun With Pirana Plants","Princess Peach",Book.NONFICTION,Book.EBOOK));
        AbBookFactory.addBook(new Book("The Hylian","Roger Cuckoo",Book.FICTION,Book.PHYSICAL));
        AbBookFactory.addBook(new Book("Song of Storms","Frank Ocarina",Book.FICTION,Book.BOTH));
        AbBookFactory.addBook(new Book("What are Iterators","Ian Fredrick",Book.NONFICTION,Book.EBOOK));
        AbBookFactory.addBook(new Book("My Cat Grue","Ian Fredrick",Book.FICTION,Book.BOTH));
                
        Book testBook,testBook1;


        AbBookFactory etest = AbBookFactory.getBookFactory("EBook");
        while (etest.hasNextNonFiction()){
            testBook = etest.getNonFiction();
            System.out.println(testBook.getTitle()+" "+testBook.getFtype()+" "+testBook.getMtype());
        }
        System.out.println("\n");
        
        AbBookFactory ptest = AbBookFactory.getBookFactory("PhyBook");
        while (ptest.hasNextFiction()){
            testBook1 = ptest.getFiction();
            System.out.println(testBook1.getTitle()+" "+testBook1.getFtype()+" "+testBook1.getMtype());
        }
    }

}
