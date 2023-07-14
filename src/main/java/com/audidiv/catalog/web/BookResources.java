package com.audidiv.catalog.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.audidiv.catalog.dto.BookCreateRequestDTO;
import com.audidiv.catalog.dto.BookDetailResponseDTO;
import com.audidiv.catalog.dto.BookListResponseDTO;
import com.audidiv.catalog.dto.BookUpdateRequestDTO;
import com.audidiv.catalog.service.BookService;

@RestController
public class BookResources {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDetailResponseDTO> findBookDetail(@PathVariable("bookId") String bookId){
        BookDetailResponseDTO dto = bookService.findBookDetail(bookId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/book")
    public ResponseEntity<Void> createANewBook(@RequestBody BookCreateRequestDTO dto) throws URISyntaxException {
        bookService.createNewBook(dto);
        return ResponseEntity.created(new URI("/book")).build();
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookListResponseDTO>> findBookAll(){
        List<BookListResponseDTO> dtos = bookService.findBookAll();
        return ResponseEntity.ok().body(dtos);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> updateABook(@PathVariable("bookId") String bookId, @RequestBody BookUpdateRequestDTO dto) throws URISyntaxException{
        bookService.updateBook(dto, bookId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("book/{bookId}")
    public ResponseEntity<Void> deleteABook(@PathVariable("bookId") String bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

}
