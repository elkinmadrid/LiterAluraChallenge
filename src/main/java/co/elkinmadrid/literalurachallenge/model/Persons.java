package co.elkinmadrid.literalurachallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Persons(
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("name") String name,
        @JsonAlias("death_year") Integer deathYear
) {
}
