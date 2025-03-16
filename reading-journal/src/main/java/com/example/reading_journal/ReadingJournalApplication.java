/**
 * Clasă pentru aplicatia Jurnal de Lectură utilizând Spring Boot.
 * Această clasă servește drept punct de pornire al aplicației, configurând și pornind aplicația Spring.
 * @author Stochirlea Ingrid Ana Maria
 * @version 23 Decembrie 2024
 */

package com.example.reading_journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadingJournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingJournalApplication.class, args);
	}

}
