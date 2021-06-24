package com.yazanalmatar.dev.bootstrap;

import com.yazanalmatar.dev.domain.Author;
import com.yazanalmatar.dev.domain.Book;
import com.yazanalmatar.dev.domain.Publisher;
import com.yazanalmatar.dev.repositories.AuthorRepository;
import com.yazanalmatar.dev.repositories.BookRepository;
import com.yazanalmatar.dev.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "324235235");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Publisher count " + publisherRepository.count());
        System.out.println("Number of Books = " + bookRepository.count());
        System.out.println("Publisher Number of Books " + publisher.getBooks().size());
    }
}
