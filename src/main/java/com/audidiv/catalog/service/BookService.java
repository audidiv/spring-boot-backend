package com.audidiv.catalog.service;

import java.util.List;

import com.audidiv.catalog.dto.BookCreateRequestDTO;
import com.audidiv.catalog.dto.BookDetailResponseDTO;
import com.audidiv.catalog.dto.BookListResponseDTO;
import com.audidiv.catalog.dto.BookUpdateRequestDTO;


public interface BookService {

    public List<BookListResponseDTO> findBookAll();

    public void createNewBook(BookCreateRequestDTO dto);

    public BookDetailResponseDTO findBookDetail(String bookId);

    public void updateBook(BookUpdateRequestDTO dto, String bookId);

    public void deleteBook(String bookId);

}
