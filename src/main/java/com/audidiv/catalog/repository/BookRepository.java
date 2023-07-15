package com.audidiv.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audidiv.catalog.domain.Book;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
    //select * from Book where Like "%name"
    List<Book> findAllByTitleLike(String title);

}
