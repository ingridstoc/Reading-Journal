/**
 * Interfață pentru gestionarea entităților Book în aplicația Jurnal de Lectură.
 * Va fi folosită pentru interacțiunea cu baza de date pentru operațiuni specifice cărților.
 * @author Stochirlea Ingrid Ana Maria
 * @version 27 Decembrie 2024
 */

package com.example.reading_journal.services;

import com.example.reading_journal.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}
