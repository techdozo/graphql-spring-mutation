package dev.techdozo.graphql.domain.repository.mapper;

import static dev.techdozo.graphql.domain.model.RatingModel.*;
import dev.techdozo.graphql.domain.repository.model.RatingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import static dev.techdozo.graphql.domain.model.RatingModel.Rating;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RatingEntityMapper {
    public static final RatingEntityMapper MAPPER = Mappers.getMapper(RatingEntityMapper.class);

    @Mapping(source = "user", target = "userId")
    public abstract RatingEntity map(Rating rating);
    @Mapping(source = "ratingInput.user", target = "userId")
    @Mapping(source = "bookId", target = "bookId")
    public abstract RatingEntity map(Integer bookId, RatingInput ratingInput);
    @Mapping(source = "userId", target = "user")
    public abstract Rating map(RatingEntity ratingEntity);
}


