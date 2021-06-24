package com.yazanalmatar.dev.repositories;

import com.yazanalmatar.dev.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
