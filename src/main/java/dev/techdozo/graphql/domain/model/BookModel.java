package dev.techdozo.graphql.domain.model;

public class BookModel {

  public static record Book(
      Integer id, String name, String author, String publisher, Double price) {}

  public static record BookInput(String name, String author, String publisher, Double price) {}

  public static record BookInfo(
          Integer id, String name, String author, String publisher, Double price) {}
}
