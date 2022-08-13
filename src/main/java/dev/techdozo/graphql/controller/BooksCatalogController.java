package dev.techdozo.graphql.controller;

import static dev.techdozo.graphql.domain.model.RatingModel.*;

import dev.techdozo.graphql.application.service.BookService;
import dev.techdozo.graphql.application.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static dev.techdozo.graphql.domain.model.BookModel.*;

@Slf4j
@Controller
public class BooksCatalogController {

  private final BookService bookService;
  private final RatingService ratingService;

  public BooksCatalogController(
          BookService bookService, RatingService ratingService) {
    this.bookService = bookService;
    this.ratingService = ratingService;
  }

  @QueryMapping()
  public Collection<Book> books() {
    log.info("Fetching all books..");
    return bookService.getBooks();
  }

  @QueryMapping
  public Book bookById(@Argument Integer id) {
    log.info("Getting book by id, {}",id );
    return bookService.bookById(id);
  }

  @MutationMapping
  public BookInfo addBook(@Argument BookInput book) {
    log.info("Saving book, name {}", book.name());
    return bookService.saveBook(book);
  }

  @MutationMapping
  public BookInfo updateBook(@Argument Integer id, @Argument BookInput book) {
    log.info("Updating book, id {}", id);
    return bookService.updateBook(id, book);
  }

  @MutationMapping
  public BookInfo deleteBook(@Argument Integer id) {
    log.info("Updating book, id {}", id);
    return bookService.deleteBook(id);
  }

  @MutationMapping
  public Rating addRating(@Argument Integer bookId, @Argument RatingInput rating) {
    log.info("Saving rating for book, id {}", bookId);
    return ratingService.addRating(bookId, rating);
  }

  @BatchMapping
  public Map<Book, List<Rating>> ratings(List<Book> books) {
    log.info("Fetching ratings for books {} ", books);
    return ratingService.ratingsForBooks(books);
  }
}
