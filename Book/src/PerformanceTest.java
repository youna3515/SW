import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PerformanceTest {

	 Book book1 = new Books("1", "자바기초", "Jane", 2021);
	 Book book2 = new Book("2", "자바심화", "John", 2022);
	 Book book3 = new Book("3", "자바고급", "Doe", 2024);
	 Book book4 = new Book("4", "파이썬기초", "Mary", 2023);
	 Book book5 = new Book("5", "러스트기초", "Albert", 2020);

	@Test
	@Order(1)
	void testAddBook() {
	    assertTrue(Book.AddBook(book1));
	    assertTrue(Book.AddBook(book2));
	    assertTrue(Book.AddBook(book3));
	    assertTrue(Book.AddBook(book4));
	    assertTrue(Book.AddBook(book5));
	 }
	
	@Test
	@Order(2)
	public void testSearchBookPerformance() {
		System.out.println("SearchBook 성능 테스트 시작");
		System.out.println("3번째 책 검색");
		
		// 성능 측정
		long startTime = System.nanoTime();
		Book.SearchBook("3");
		long endTime = System.nanoTime();
		long performanceTime = endTime - startTime;
		
		// 성능 출력
		System.out.println("SearchBook 성능 테스트 결과 : " + performanceTime + " ns\n");
	}
	
	@Test
	@Order(3)
	public void testSearchBsPerformance() {
		System.out.println("Search_bs 성능 테스트 시작");
		System.out.println("3번째 책 검색");
		
		// 성능 측정
		long startTime = System.nanoTime();
		Book.Search_bs("3");
		long endTime = System.nanoTime();
		long performanceTime = endTime - startTime;
		
		// 성능 출력
		System.out.println("Search_bs 성능 테스트 결과 : " + performanceTime + " ns\n");
	}

}
