package com.audidiv.catalog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.audidiv.catalog.dto.BookCreateRequestDTO;
import com.audidiv.catalog.dto.BookDetailResponseDTO;
import com.audidiv.catalog.dto.BookListResponseDTO;
import com.audidiv.catalog.dto.BookUpdateRequestDTO;
import com.audidiv.catalog.model.Book;
import com.audidiv.catalog.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    Map<String, Book> books = new HashMap<>();

    public BookServiceImpl(){
        super();
        Book book1 = new Book();
        book1.setId("1");
        book1.setTitle("Harry Potter and the Philosopher's Stone");
        book1.setAuthor("J.K Rowling");
        book1.setDescription("Harry Potter thinks he is an ordinary boy - until he is rescued by an owl, taken to Hogwarts School of Witchcraft and Wizardry, learns to play Quidditch and does battle in a deadly duel. The Reason ... HARRY POTTER IS A WIZARD!");

        Book book2 = new Book();
        book2.setId("2");
        book2.setTitle("Harry Potter and the Chamber of Secret");
        book2.setAuthor("J.K Rowling");
        book2.setDescription("Ever since Harry Potter had come home for the summer, the Dursleys had been so mean and hideous that all Harry wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he\u2019s packing his bags, Harry receives a warning from a strange impish creature who says that if Harry returns to Hogwarts, disaster will strike.");
        
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
    }

    @Override
    public List<BookListResponseDTO> findBookAll() {
        List<Book> bookResponse = new ArrayList<>(books.values());
        return bookResponse.stream().map((b) -> {
            BookListResponseDTO dto = new BookListResponseDTO();
            dto.setTitle(b.getTitle());
            dto.setAuthor(b.getAuthor());
            dto.setDescription(b.getDescription());
            dto.setId(b.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateRequestDTO dto) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setId(UUID.randomUUID().toString());
        books.put(book.getId(), book);
    }

    @Override
    public BookDetailResponseDTO findBookDetail(String bookId) {
        Book book = books.get(bookId);
        BookDetailResponseDTO dto = new BookDetailResponseDTO();
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        return dto;
    }

    @Override
    public void updateBook(BookUpdateRequestDTO dto, String bookId) {
        Book book = books.get(bookId);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        books.put(book.getId(), book);
    }

    @Override
    public void deleteBook(String bookId) {
        books.remove(bookId);
    }

}
