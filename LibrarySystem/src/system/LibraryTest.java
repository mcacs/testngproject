package system;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LibraryTest {
    private Library library;

    @BeforeClass
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook(book);
        Assert.assertTrue(library.getAllBooks().contains(book));
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book);
        library.removeBook(book);
        Assert.assertFalse(library.getAllBooks().contains(book));
    }

    @Test
    public void testGetAllBooksEmptyLibrary() {
        Assert.assertEquals(library.getAllBooks().size(), 0);
    }

    @Test
    public void testAddMultipleBooks() {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger");
        library.addBook(book1);
        library.addBook(book2);
        Assert.assertTrue(library.getAllBooks().contains(book1));
        Assert.assertTrue(library.getAllBooks().contains(book2));
    }

    @Test
    public void testRemoveNonExistentBook() {
        Book book = new Book("Pride and Prejudice", "Jane Austen");
        library.removeBook(book); // Tentando remover um livro que não existe
        Assert.assertFalse(library.getAllBooks().contains(book));
    }
}
