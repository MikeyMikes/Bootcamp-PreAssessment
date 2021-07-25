package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @DeleteMapping("/api/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllBooks() {
        libraryService.deleteAllBooks();
    }
}
