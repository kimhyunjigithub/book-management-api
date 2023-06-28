package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setTitle("Book 1");
        book.setAuthor("Author 1");
        book.setPublisher("Publisher 1");
        book.setPublicationYear(2021);

        Book savedBook = entityManager.persistAndFlush(book);
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("Book 1");
        assertThat(savedBook.getAuthor()).isEqualTo("Author 1");
        assertThat(savedBook.getPublisher()).isEqualTo("Publisher 1");
        assertThat(savedBook.getPublicationYear()).isEqualTo(2021);
    }

    // 다른 테스트 메서드들도 구현 가능
}