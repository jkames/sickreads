package com.example.sickreads;

import java.util.Optional;

public interface ISickreadsDAO {
    Optional<Books>getBook(int id);
    void addBook(Books b);
    Optional<Author>getAuthor(int id);
    void addAuthor(Author a);
    Optional<User>getUser(int id);
    void addUser(User u);
}
