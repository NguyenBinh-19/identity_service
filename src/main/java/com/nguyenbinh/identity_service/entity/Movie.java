package com.nguyenbinh.identity_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;



@Entity
@Table(name = "Movie") // Chỉ định tên bảng là "Movie"
public class Movie {
    @Id
    private int id;
    private String title;
    private String description;
    private String age_rating;
    private String type;
    private String director;
    private String actor;
    private String category;
    private int length;
    private Date release_date;
    private String language;
    private String link;
    private int price;
    private String favourite;

    public Movie() {
    }

    public Movie(String description, String title, String age_rating, String type, String director, String actor, String category, int length, Date release_date, String language, String link, int price, String favourite) {

        this.description = description;
        this.title = title;
        this.age_rating = age_rating;
        this.type = type;
        this.director = director;
        this.actor = actor;
        this.category = category;
        this.length = length;
        this.release_date = release_date;
        this.language = language;
        this.link = link;
        this.price = price;
        this.favourite = favourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge_rating() {
        return age_rating;
    }

    public void setAge_rating(String age_rating) {
        this.age_rating = age_rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
}
