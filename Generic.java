package preparation;

import java.util.ArrayList;
import java.util.List;

public class Generic {

   //Upper bound wildcard
//	in category
   public static void deleteBook(List<? extends Book> bookList, Book book) {
      bookList.remove(book);
      System.out.println("Book Removed");
   }

   //Lower bound wildcard
   //out category
   public static void addBook(List<? super FictionBook> bookList) {
      bookList.add(new FictionBook("Fiction Book"));
      System.out.println("Book Added");
   }


   public static void main(String[] args) {

      List<Library> LibraryList= new LibraryList<Book>();
      List<FictionBook> fictionBookList= new ArrayList<FictionBook>();

      //add list of super class Animal of Cat class
      addBook(bookList);
      //add list of Cat class
      addBook(fictionBookList);
      addBook(fictionBookList);

      Book book = fictionBookList.get(0);
      //delete cat
      deleteBook(fictionBookList, book);
   }
}

class Library {
   String name;
   Library(String name) {
      this.name = name;
   }
   public String toString() {
      return name;
   }
}

class Book extends Library {
   Book(String name) {
      super(name);
   }
}

class FictionBook extends Book {
   FictionBook(String name) {
      super(name);
   }
}

class Newspaper extends Library {
   Newspaper(String name) {
      super(name);
   }
}
