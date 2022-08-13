package dev.techdozo.graphql.domain.repository;

import dev.techdozo.graphql.domain.repository.model.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
    List<RatingEntity> findByBookId(Integer bookId);
    List<RatingEntity> findByBookIdIn(Collection<Integer> books);
}
