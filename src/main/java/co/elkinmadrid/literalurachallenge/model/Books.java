package co.elkinmadrid.literalurachallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Books(
        Long id,
        String title,
        List<String> subjects,
        List<Persons> authors,
        List<Persons> translators,
        List<String> languages,
        @JsonAlias("download_count") Integer downloadCount
) {
}
