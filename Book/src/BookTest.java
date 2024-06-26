import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookTest {
	
   Book book1, book2, book3, book4, book5;
   
   @BeforeEach
   void setUp() {
	   book1 = new Book("1", "자바기초", "Jane", 2021);
	   book2 = new Book("2", "자바심화", "John", 2022);
	   book3 = new Book("3", "자바고급", "Doe", 2024);
	   book4 = new Book("4", "파이썬기초", "Mary", 2023);
	   book5 = new Book("5", "러스트기초", "Albert", 2020);
   }
   
   @Test
   @Order(1)
   void testAddBook() {
      System.out.println("ADD BOOK");
      Book.RemoveBook(book1.GetId());
      Book.RemoveBook(book2.GetId());
      Book.RemoveBook(book3.GetId());
      Book.RemoveBook(book4.GetId());
      Book.RemoveBook(book5.GetId());
      assertTrue(Book.AddBook(book1));
      assertTrue(Book.AddBook(book2));
      assertTrue(Book.AddBook(book3));
      assertTrue(Book.AddBook(book4));
      assertTrue(Book.AddBook(book5));
   }

   @Test
   @Order(2)
   void testSearchBook() {
      System.out.println("SEARCH BOOK");
      assertTrue(Book.SearchBook("1"));
      assertTrue(Book.SearchBook("4"));
   }

   @Test
   @Order(3)
   void testRemoveBook() {
      System.out.println("REMOVE BOOK");
      assertTrue(Book.RemoveBook("5"));
   }
   
   @Test
   @Order(4)
   void testSearch_bs() {
      System.out.println("BINARY SEARCH BOOK");
      assertTrue(Book.Search_bs("3"));
   }

}
