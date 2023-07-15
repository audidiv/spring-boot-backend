package com.audidiv.catalog.service;

import java.util.List;

import com.audidiv.catalog.dto.BookCreateRequestDTO;
import com.audidiv.catalog.dto.BookDetailResponseDTO;
import com.audidiv.catalog.dto.BookListResponseDTO;
import com.audidiv.catalog.dto.BookUpdateRequestDTO;


public interface BookService {

    public List<BookListResponseDTO> findBookAll();

    public void createNewBook(BookCreateRequestDTO dto);

    public BookDetailResponseDTO findBookDetail(Long bookId);

    public void updateBook(BookUpdateRequestDTO dto, Long bookId);

    public void deleteBook(Long bookId);

}
