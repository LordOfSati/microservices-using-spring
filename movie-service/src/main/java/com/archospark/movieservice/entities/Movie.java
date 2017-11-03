package com.archospark.movieservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="movies")
public class Movie {

    @Id
    private Long id;
    private String name;
    private String description;
    @Field(value="year")
    private Integer releaseYear;
    private Integer length;
    private String[] genre;

    public Movie() {
    }

    public Movie(String name, String description, Integer releaseYear, Integer length) {
        this.name = name;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", length=" + length +
                '}';
    }
}
