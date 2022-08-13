package dev.techdozo.graphql.domain.repository.mapper;

import dev.techdozo.graphql.domain.repository.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import static dev.techdozo.graphql.domain.model.BookModel.Book;
import static dev.techdozo.graphql.domain.model.BookModel.BookInput;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BookEntityMapper {
  public static final BookEntityMapper MAPPER = Mappers.getMapper(BookEntityMapper.class);

  public abstract BookEntity map(Book book);

  public abstract Book map(BookEntity bookEntity);

  public abstract BookEntity map(BookInput bookInput);

  public abstract BookEntity map(Integer id, BookInput bookInput);
}
