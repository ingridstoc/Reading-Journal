/**
 * Clasa pentru reprezentarea unei carti in aplicatia jurnalului (getters + setters). Aceasta clasa contine titlul cartii,
 * autorul, data cand a fost terminata, recenzia,citatul preferat, numele fisierului imaginii asociate si scorul acordat.
 * @author Stochirlea Ingrid Ana Maria
 * @version 27 Decembrie 2024
 */

package com.example.reading_journal.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String author;
    private Date finishedAt;
    @Column(columnDefinition = "TEXT")
    private String review;
    @Column(columnDefinition = "TEXT")
    private String favoriteQuote;
    private String imageFileName;
    private int score;

    public String getFavoriteQuote() {
        return favoriteQuote;
    }

    public void setFavoriteQuote(String favoriteQuote) {
        this.favoriteQuote = favoriteQuote;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
