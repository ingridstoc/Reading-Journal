/**
 * Clasa pentru reprezentarea unui obiect de tip BookDto, utilizat pentru validarea și transferul
 * datelor introduse de utilizator în legătură cu o carte.
 * @author Stochirlea Ingrid
 * @version 27 Decembrie 2024
 */

package com.example.reading_journal.models;

import com.example.reading_journal.validation.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.*;

import java.util.Date;

public class BookDto {
    @NotEmpty(message = "Numele trebuie introdus.")
    @Size(max = 100, message = "Numele nu trebuie să depășească 100 de litere.")
    private String name;
    @NotEmpty(message = "Autorul trebuie introdus.")
    @Size(max = 100, message = "Numele autorului nu trebuie să depășească 100 de litere.")
    @Pattern(regexp = "^[a-zA-ZăâîșțĂÂÎȘȚ\\s]+$", message = "Autorul trebuie să conțină doar litere și spații.")
    private String author;
    @NotEmpty(message = "O recenzie trebuie introdusă.")
    @Size(max = 2500, message = "Recenzia nu trebuie să depășească 2500 de litere.")
    private String review;
    @NotEmpty(message = "Un citat preferat din carte trebuie introdus.")
    @Size(max = 2500, message = "Citatul nu trebuie să depășească 2500 de litere.")
    private String favoriteQuote;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data finalizării cărții trebuie introdusă.")
    @PastOrPresent(message = "Data finalizării nu poate fi în viitor.")
    private Date finishedAt;

    @Min(value = 1, message = "Scorul nu poate fi mai mic decât 1.")
    @Max(value = 10, message = "Scorul nu poate fi mai mare decât 10.")
    private int score;
    private MultipartFile imageFile;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
