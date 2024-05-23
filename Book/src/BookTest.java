import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {


    @Test
    void testAddBook() {
        System.out.println("책 추가 테스트 시작");
        Book book1 = new Book(7, "확률과통계", "Park", 2020);
        Book book2 = new Book(8, "인지공학", "Kim", 2022);
        Book book3 = new Book(9, null, "Lee", 2024);

        assertTrue(Book.addBook(book1));
        assertFalse(Book.addBook(book1)); // 중복 추가 시도
        assertTrue(Book.addBook(book2));
        assertFalse(Book.addBook(book3)); //책제목이 null 이면 책이 추가되지 않음
    }

    @Test
    void testSearchBook() {
        System.out.println("책 검색 테스트 시작");

        assertNotNull(Book.searchBook("확률과통계"));
        assertNotNull(Book.searchBook("인지공학"));
        assertNull(Book.searchBook("데이터베이스 시스템")); // 존재하지 않는 책 검색
    }

    @Test
    void testRemoveBook() {
        System.out.println("책 제거 테스트 시작");
        assertTrue(Book.removeBook(7));
        assertTrue(Book.removeBook(8));
        assertFalse(Book.removeBook(9)); // 존재하지 않는 책 제거 시도
    }
}
