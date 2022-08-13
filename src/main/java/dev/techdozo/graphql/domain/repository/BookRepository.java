package dev.techdozo.graphql.domain.repository;

import dev.techdozo.graphql.domain.repository.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
