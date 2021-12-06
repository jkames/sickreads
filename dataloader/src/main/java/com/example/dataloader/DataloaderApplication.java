package com.example.dataloader;

import com.example.dataloader.author.Author;
import com.example.dataloader.author.AuthorRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootApplication
//@PropertySource(value={"application.properties"})
public class DataloaderApplication implements CommandLineRunner{
    @Autowired
    private AuthorRepository authorRepository;

    @Value("${authorLocation:defaultValue}")
    private String authorsDumpLocation;

    @Value("${workLocation:defaultValue}")
    private String worksDumpLocation;

    public static void main(String[] args) {
        SpringApplication.run(DataloaderApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //initAuthors();
    }
    private void initAuthors(){
        Path path = Paths.get("/Users/James/sickreads/ol_dump_authors_2021-10-13.txt");

        try(Stream<String> lines = Files.lines(path)){
            lines.forEach(line ->{

                String jsonString = line.substring(line.indexOf("{"));
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Author author = new Author();
                    author.setName(jsonObject.optString("name"));
                    author.setPersonalName(jsonObject.optString("personal_name"));
                    author.setId(jsonObject.optString("key").replace("/authors/", ""));
                    System.out.println("adding "+author.getName());
                    authorRepository.save(author);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args ->{
            Author a = new Author();
            a.setId("id");
            a.setName("name");
            a.setPersonalName("pname");
            authorRepository.save(a);
        };
    }
*/
}
