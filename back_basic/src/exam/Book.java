package exam;

import java.util.Date;

public class Book {

    String id;
    String title;
    double price;
    String author;
    String description;
    String genre;
    Date publishDate;

    public Book(String id, String title, double price, String author, String description, String genre, Date publishDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.publishDate = publishDate;
    }


    // 도서 정보를 보기 좋게 출력하기 위한 메서드
    public java.lang.String toString() {
        return java.lang.String.format("%s | %s | %.0f | %s | %s | %s | %s",
                id, title, price, author, description, genre, publishDate);
    }
}
