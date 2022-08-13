package dev.techdozo.graphql.application.service;

import dev.techdozo.graphql.domain.repository.RatingRepository;
import dev.techdozo.graphql.domain.repository.mapper.RatingEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static dev.techdozo.graphql.domain.model.BookModel.Book;
import static dev.techdozo.graphql.domain.model.RatingModel.Rating;
import static dev.techdozo.graphql.domain.model.RatingModel.RatingInput;

@RequiredArgsConstructor
@Service
@Slf4j
public class RatingService {

  private final RatingRepository ratingRepository;

  public List<Rating> ratings(Book book) {
    return ratingRepository.findByBookId(book.id()).stream()
        .map(RatingEntityMapper.MAPPER::map)
        .toList();
  }

  public Map<Book, List<Rating>> ratingsForBooks(List<Book> books) {
    return books.stream()
        .collect(
            Collectors.toMap(
                Function.identity(),
                book ->
                    ratingRepository.findByBookId(book.id()).stream()
                        .map(RatingEntityMapper.MAPPER::map)
                        .toList()));
  }

  public Rating addRating(Integer bookId, RatingInput ratingInput) {
    log.info("Saving rating for book, id {}", bookId);
    var ratingEntityMapper = RatingEntityMapper.MAPPER;
    var ratingEntity = ratingEntityMapper.map(bookId, ratingInput);
    var savedRating = ratingRepository.save(ratingEntity);
    log.info("Saved rating, {} ", savedRating);
    return ratingEntityMapper.map(savedRating);
  }
}
