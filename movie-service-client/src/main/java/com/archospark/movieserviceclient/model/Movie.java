package com.archospark.movieserviceclient.model;

import java.util.Collections;
import java.util.List;

public class Movie {
    private Long id;
    private String name;
    private String description;
    private Integer releaseYear;
    private Integer length;
    private List<Review> reviews = Collections.emptyList();
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", releaseYear=").append(releaseYear);
        sb.append(", length=").append(length);
        sb.append('}');
        return sb.toString();
    }
}
