package com.example.dataloader.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

}
