package dev.techdozo.graphql.application.service;

import dev.techdozo.graphql.domain.repository.BookRepository;
import dev.techdozo.graphql.domain.repository.mapper.BookEntityMapper;
import dev.techdozo.graphql.domain.repository.model.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static dev.techdozo.graphql.domain.model.BookModel.*;

@RequiredArgsConstructor
@Service
public class BookService {

  private final BookRepository bookRepository;

  public Collection<Book> getBooks() {
    var bookEntityMapper = BookEntityMapper.MAPPER;
    List<BookEntity> allBooks = bookRepository.findAll();
    return allBooks.stream().map(bookEntityMapper::map).toList();
  }

  public BookInfo saveBook(BookInput bookInput) {
    var bookEntityMapper = BookEntityMapper.MAPPER;
    var entity = bookEntityMapper.map(bookInput);
    var persistedBook = bookRepository.save(entity);

    return new BookInfo(
        persistedBook.getId(),
        persistedBook.getName(),
        persistedBook.getAuthor(),
        persistedBook.getPublisher(),
        persistedBook.getPrice());
  }

  public BookInfo updateBook(Integer id, BookInput bookInput) {

    var bookEntityMapper = BookEntityMapper.MAPPER;
    var entity = bookEntityMapper.map(id, bookInput);
    var persistedBook = bookRepository.save(entity);

    return new BookInfo(
        persistedBook.getId(),
        persistedBook.getName(),
        persistedBook.getAuthor(),
        persistedBook.getPublisher(),
        persistedBook.getPrice());
  }

  public BookInfo deleteBook(Integer id) {

    var maybeBook = bookRepository.findById(id);
    var book = maybeBook.orElseThrow(RuntimeException::new);
    bookRepository.delete(book);

    return new BookInfo(
        book.getId(), book.getName(), book.getAuthor(), book.getPublisher(), book.getPrice());
  }

  public Book bookById(Integer id) {
    return bookRepository
        .findById(id)
        .map(BookEntityMapper.MAPPER::map)
        .orElseThrow(RuntimeException::new);
  }
}
