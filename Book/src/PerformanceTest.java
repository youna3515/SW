import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PerformanceTest {
	   
	@BeforeEach
	void setUp() {
		Book book1 = new Book("1", "자바기초", "Jane", 2021);
		Book book2 = new Book("2", "자바심화", "John", 2022);
		Book book3 = new Book("3", "자바고급", "Doe", 2024);
		Book book4 = new Book("4", "파이썬기초", "Mary", 2023);
		Book book5 = new Book("5", "러스트기초", "Albert", 2020);
	
		Book.AddBook(book1);
		Book.AddBook(book2);
		Book.AddBook(book3);
		Book.AddBook(book4);
		Book.AddBook(book5);
	}

	@Test
	@Order(1)
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
	@Order(2)
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
