package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/health")
    public void health() {

    }

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    @PostMapping("/api/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @DeleteMapping("/api/books")
    public void deleteAllBooks() {
        libraryService.deleteAllBooks();
    }
}
