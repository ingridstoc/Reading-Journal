/**
 * Clasă pentru controller pentru gestionarea operațiunilor CRUD asociate cu entitatea Book.
 * Oferă funcționalități pentru afișarea listei de cărți, crearea, editarea și ștergerea
 * unei cărți, precum și validarea datelor introduse de utilizator.
 * @author Stochirlea Ingrid
 * @version 27 Decembrie 2024
 */


package com.example.reading_journal.controllers;

import com.example.reading_journal.models.BookDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.example.reading_journal.models.Book;
import com.example.reading_journal.services.BooksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.*;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksRepository repo;

    @GetMapping({"", "/"})
    public String showBookList(Model model) {
        List<Book> books = repo.findAll();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
        return "books/CreateBook";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute BookDto bookDto,
            BindingResult result
    ) {

        if (bookDto.getImageFile().isEmpty()) {
            result.addError(new FieldError("bookDto", "imageFile", "O imagine trebuie introdusă."));
        }

        if (result.hasErrors()) {
            return "books/CreateBook";
        }

        MultipartFile image = bookDto.getImageFile();
        String storageFileName = image.getOriginalFilename();
        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setFinishedAt(bookDto.getFinishedAt());
        book.setReview(bookDto.getReview());
        book.setFavoriteQuote(bookDto.getFavoriteQuote());
        book.setImageFileName(storageFileName);
        book.setScore(bookDto.getScore());

        repo.save(book);

        return "redirect:/books";
    }

    @GetMapping("/edit")
    public String showEditPage(
            Model model,
            @RequestParam int id
    ) {
        try {
            Book book = repo.findById(id).get();
            model.addAttribute("book", book);

            BookDto bookDto = new BookDto();
            bookDto.setName(book.getName());
            bookDto.setAuthor(book.getAuthor());
            bookDto.setFinishedAt(book.getFinishedAt());
            bookDto.setReview(book.getReview());
            bookDto.setFavoriteQuote(book.getFavoriteQuote());
            bookDto.setScore(book.getScore());

            model.addAttribute("bookDto", bookDto);
        } catch (Exception ex) {
            System.out.println("Exeception: " + ex.getMessage());
            return "redirect:/books";
        }
        return "books/EditBook";
    }

    @PostMapping("/edit")
    public String updateBook(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute BookDto bookDto,
            BindingResult result
    ) {

        try {
            Book book = repo.findById(id).get();
            model.addAttribute("book", book);

            if (result.hasErrors()) {
                return "books/EditBook";
            }

            if (!bookDto.getImageFile().isEmpty()) {
                String uploadDir = "public/images/";
                Path oldImagePath = Paths.get(uploadDir + book.getImageFileName());
                try {
                    Files.delete(oldImagePath);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.getMessage());
                }

                MultipartFile image = bookDto.getImageFile();
                String storageFileName = image.getOriginalFilename();
                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                }
                book.setImageFileName(storageFileName);
            }

            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setFinishedAt(bookDto.getFinishedAt());
            book.setReview(bookDto.getReview());
            book.setFavoriteQuote(bookDto.getFavoriteQuote());
            book.setScore(bookDto.getScore());

            repo.save(book);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/books";
    }

    @GetMapping("/delete")
    public String deleteBook(
            @RequestParam int id
    ) {
        try {
            Book book = repo.findById(id).get();

            Path imagePath = Paths.get("public/images/" + book.getImageFileName());

            try {
                Files.delete(imagePath);
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            repo.delete(book);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return "redirect:/books";
    }
}
