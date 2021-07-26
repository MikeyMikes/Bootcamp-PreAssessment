package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Book> getBooks() {
        return libraryRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    static class ReturnResponse {
        List<Book> books;

        public ReturnResponse() {}

        public ReturnResponse(List<Book> books) {
            this.books = books;
        }

        public List<Book> getBooks() {
            return this.books;
        }

        public void setBooks(ArrayList<Book> books) {
            this.books = books;
        }
    }

    public void deleteAllBooks() {
        libraryRepository.deleteAll();
    }
}
