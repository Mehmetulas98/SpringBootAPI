package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BookConroller {
    @Autowired
    private BookRepository repository;

    // Add book
    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return book.getBookName() + " is saved";
    }

    // List all books
    @GetMapping("/listBooks")
    public List<Book> listBooks(){
        return repository.findAll();
    }

    // Query with  ID
    @GetMapping("getBookID/{id}")
    public Optional<Book> queryWithBookId(@PathVariable int id){
        return repository.findById(id);
    }
    // Delete book with ID
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
         repository.deleteById(id);
         return "book deleted";
    }

}
