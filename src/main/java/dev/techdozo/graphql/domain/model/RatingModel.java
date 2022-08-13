package dev.techdozo.graphql.domain.model;

public class RatingModel {
  public static record Rating(
      Integer id, Integer bookId, Integer rating, String comment, String user) {}

  public static record RatingInput(Integer rating, String comment, String user) {}
}
