import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	@Test
	void testAddBook() {
		System.out.println("ADD BOOK");
		Book book1 = new Book("1", "자바기초", "Jane", 2021);
		assertTrue(Book.AddBook(book1));
		assertFalse(Book.AddBook(book1));
	}

	@Test
	void testSearchBook() {
		System.out.println("SEARCH BOOK");
		assertTrue(Book.SearchBook("1"));
		assertFalse(Book.SearchBook("2"));
		assertFalse(Book.SearchBook("4"));
	}

	@Test
	void testRemoveBook() {
		System.out.println("REMOVE BOOK");
		assertTrue(Book.RemoveBook("1"));
		assertFalse(Book.RemoveBook("1"));
	}

}