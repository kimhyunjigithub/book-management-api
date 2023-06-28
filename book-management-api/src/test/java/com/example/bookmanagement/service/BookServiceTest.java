package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);

    @Test
    public void testGetBookById() {
        Book book = new Book(1L, "Book 1", "Author 1", "Publisher 1", 2021);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookById(1L);
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Book 1");
        assertThat(result.getAuthor()).isEqualTo("Author 1");
        assertThat(result.getPublisher()).isEqualTo("Publisher 1");
        assertThat(result.getPublicationYear()).isEqualTo(2021);
    }

    // 다른 테스트 메서드들도 구현 가능
}