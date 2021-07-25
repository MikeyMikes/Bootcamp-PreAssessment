package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Book addBook(Book book) {
        return libraryRepository.save(book);
    }

    public ResponseEntity getBooks() {
        return ResponseEntity.ok(libraryRepository.findAll(Sort.by(Sort.Direction.ASC, "title")));
    }

    public void deleteAllBooks() {
        libraryRepository.deleteAll();
    }
}
