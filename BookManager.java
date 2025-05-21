import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Book class with attributes
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Book{Title='" + title + "', Author='" + author + "', ISBN='" + isbn + "'}";
    }
}

// Collection class
class BookCollection {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book);
    }

    public void removeBookByISBN(String isbn) {
        Iterator<Book> iterator = books.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Removed: " + book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the collection.");
        } else {
            System.out.println("Books in the collection:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

// Main class
public class BookManager {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        Book book1 = new Book("Java Basics", "Joseph Betty", "1234567890");
        Book book2 = new Book("Effective Java", "Joshua Samuel", "0987654321");

        collection.addBook(book1);
        collection.addBook(book2);
        collection.displayBooks();

        collection.removeBookByISBN("1234567890");
        collection.displayBooks();
    }
}
