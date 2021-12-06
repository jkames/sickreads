package com.example.dataloader.author;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Author {
    @Id
/*
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
*/
    private String id;
    @Lob
    @Column(columnDefinition = "text")
    private String name;
    @Lob
    @Column(columnDefinition = "text")
    private String personalName;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPersonalName() {
        return personalName;
    }
    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
