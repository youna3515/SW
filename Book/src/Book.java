
import java.util.ArrayList;
import java.util.List;

public class Book {
  private int id;
  private String title;
  private String author;
  private int publicationYear;
  private static List<Book> bookCollection = new ArrayList<>();

  public Book(int id, String title, String author, int publicationYear) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.publicationYear = publicationYear;
  }

  public int getId() {
      return id;
  }

  public String getTitle() {
      return title;
  }

  public String getAuthor() {
      return author;
  }

  public int getPublicationYear() {
      return publicationYear;
  }

  public static boolean addBook(Book book) {
      for (Book b : bookCollection) {
      	// 추가 
      	if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
      		System.out.println("책제목이 null이면 추가할 수 없습다.");
              return false;
          }
      	
          if (b.getId() == book.getId()) {
              System.out.println("해당 ID(" + book.getId() + ")는 이미 존재합니다.");
              return false;
          }
      }
      bookCollection.add(book);
      System.out.println(book + "도서가 추가되었습니다.");
      return true;
  }

  public static boolean removeBook(int id) {
      for (Book b : bookCollection) {
          if (b.getId() == id) {
              bookCollection.remove(b);
              System.out.println(b + "도서를 삭제하였습니다.");
              return true;
          }
      }
      System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
      return false;
  }

  public static Book searchBook(String title) {
  	
      for (Book b : bookCollection) {        	
          if (b.getTitle() == title) {
              System.out.println("검색 결과:\n" + b);
              return b;
          }
          
          // 추가 
      	if (b.getTitle() == null || b.getTitle().isEmpty()) {
              throw new IllegalArgumentException("책제목이 null이면 검색할 수 없습니다.");
          }
      }
      System.out.println("검색된 도서가 없습니다.");
      return null;
  }

  public static void clearBookCollection() {
      bookCollection.clear();
  }

  @Override
  public String toString() {
      return "Book{id: '" + id + "', 제목: '" + title + "', 저자: '" + author + "', 출판년도: " + publicationYear + "}";
  }
}
