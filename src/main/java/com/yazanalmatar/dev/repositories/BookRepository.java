package com.yazanalmatar.dev.repositories;

import com.yazanalmatar.dev.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
